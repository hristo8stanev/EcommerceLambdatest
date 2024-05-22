package pages.checkoutpage;

import core.baseassertions.BaseAssertions;
import factories.CustomerFactory;
import org.junit.jupiter.api.Assertions;
import pages.cartpage.CheckoutInformation;
import pages.productpage.ProductDetails;

import static core.driver.Driver.*;

import java.text.NumberFormat;
import java.util.Arrays;

import static constants.Constants.*;
import static core.basepage.WebPage.getNumberFormat;

public class CheckoutPageAssertions extends BaseAssertions<CheckoutPageMap> {

    public void assertConfirmButtonDisplayed() {
        boolean isConfirmButtonDisplayed = elementsT().confirmOrderButton().isDisplayed();
        var confirmButtonMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ERROR_MESSAGE_LOGOUT_BUTTON, isConfirmButtonDisplayed, true);
        Assertions.assertTrue(isConfirmButtonDisplayed, ERROR_MESSAGE_LOGOUT_BUTTON);
    }

    public void assertSuccessfullyCheckoutOrder() {
        var expectedMessage = SUCCESSFULLY_PURCHASE_MESSAGE;
        var successfullyCheckoutOrderMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_LOGOUT_BUTTON, elementsT().successfullyConfirmOrderText().getText(), expectedMessage);
        Assertions.assertEquals(elementsT().successfullyConfirmOrderText().getText(), expectedMessage, successfullyCheckoutOrderMessage);
    }

    public void assertProductInformationCorrect(ProductDetails expectedProduct) {

        String nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(),
                expectedProduct.getName()
        );

        String quantityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productQuantityElement(expectedProduct.getId(), expectedProduct.getName()).getAttribute("value"),
                expectedProduct.getQuantity()
        );

        String unitPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productPriceElement("text-right", expectedProduct.getUnitPrice()).getText(),
                expectedProduct.getUnitPrice()
        );

        String totalPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION,
                elementsT().productTotalPriceElement("text-right", expectedProduct.getUnitPrice()).getText(),
                String.format("%.2f", expectedProduct.getTotal())
        );

        Assertions.assertEquals(expectedProduct.getName(), elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), nameMessage);
        Assertions.assertEquals(expectedProduct.getQuantity(), elementsT().productQuantityElement(expectedProduct.getId(), expectedProduct.getName()).getAttribute("value"), quantityMessage);
        Assertions.assertEquals(expectedProduct.getUnitPrice(), elementsT().productPriceElement("text-right", expectedProduct.getUnitPrice()).getText(), unitPriceMessage);
        Assertions.assertEquals(String.format("$%.2f", expectedProduct.getTotal()), elementsT().productTotalPriceElement("text-right", expectedProduct.getUnitPrice()).getText(), totalPriceMessage);
    }

    public void assertProductInformationConfirmOrder(ProductDetails expectedProductInfo) {
        String nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderProductName("text-left", expectedProductInfo.getName()).getText(),
                expectedProductInfo.getName()
        );

        String modelMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderInformation("text-left", expectedProductInfo.getModel()).getText(),
                expectedProductInfo.getModel()
        );

        String quantityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderQuantityElement(expectedProductInfo.getModel()).getText(), expectedProductInfo.getQuantity()
        );

        String priceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderPriceElement(expectedProductInfo.getQuantity()).getText(),
                expectedProductInfo.getUnitPrice()
        );

        Assertions.assertEquals(expectedProductInfo.getName(), elementsT().confirmOrderProductName("text-left", expectedProductInfo.getName()).getText(), nameMessage);
        Assertions.assertEquals(expectedProductInfo.getModel(), elementsT().confirmOrderInformation("text-left", expectedProductInfo.getModel()).getText(), modelMessage);
        Assertions.assertEquals(expectedProductInfo.getQuantity(), elementsT().confirmOrderQuantityElement(expectedProductInfo.getModel()).getText(), quantityMessage);
        Assertions.assertEquals(expectedProductInfo.getUnitPrice(), elementsT().confirmOrderPriceElement(expectedProductInfo.getQuantity()).getText(), priceMessage);
    }

    private void assertProductSubTotalPrice(CheckoutInformation... expectedProducts) {
        waitForAjax();
        elementsT().scrollToVisible(elementsT().searchButton());
        elementsT().updateButton().click();

        double expectedSubTotal = Arrays.stream(expectedProducts).mapToDouble(CheckoutInformation::getSubTotal).sum();

        NumberFormat currencyFormat = getNumberFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedSubTotal);
        String actualSubTotalText = elementsT().subTotal().getText();

        String subtotalPriceMessage = String.format("Expected subtotal: %s, but got: %s", expectedTotalFormatted, actualSubTotalText);
        Assertions.assertEquals(expectedTotalFormatted, actualSubTotalText, subtotalPriceMessage);
    }

    private void assertProductTotalPrice(CheckoutInformation... checkoutInformation) {
        waitForAjax();
        var billingDetails = CustomerFactory.GenerateBillingAddress();

        double expectedTotal;
        if ("United Kingdom".equals(billingDetails.getCountry())) {
            expectedTotal = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getTotal).sum();

        } else {
            double subTotalSum = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getSubTotal).sum();
            double shippingRateSum = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getFlatShippingRate).sum();
            expectedTotal = subTotalSum + shippingRateSum;
        }

        NumberFormat currencyFormat = getNumberFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedTotal);
        String actualTotalText = elementsT().total().getText();
        String totalMessage = String.format("Expected Result: %s \n Actual Result: %s", expectedTotalFormatted, actualTotalText);

        Assertions.assertEquals(expectedTotalFormatted, actualTotalText, totalMessage);
    }

    private void assertEcoTax(CheckoutInformation... checkoutInformation) {
        var billingDetails = CustomerFactory.GenerateBillingAddress();

        if ("United Kingdom".equals(billingDetails.getCountry())) {
            double expectedEcoTax = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getEcoTax).sum();
            NumberFormat currencyFormat = getNumberFormat();
            String expectedTotalFormatted = currencyFormat.format(expectedEcoTax);
            String actualEcoTaxText = elementsT().ecoTaxElement().getText();
            String ecoTaxMessage = String.format("Expected Result: %s \n Actual Result: %s", expectedTotalFormatted, actualEcoTaxText);

            Assertions.assertEquals(expectedTotalFormatted, actualEcoTaxText, ecoTaxMessage);
        }
    }

    public void assertCheckoutInformation(CheckoutInformation checkoutInformation) {
        assertProductSubTotalPrice(checkoutInformation);
        assertEcoTax(checkoutInformation);
        assertProductTotalPrice(checkoutInformation);
    }
}
