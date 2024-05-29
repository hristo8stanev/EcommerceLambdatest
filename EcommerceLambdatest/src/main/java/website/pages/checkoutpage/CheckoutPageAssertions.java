package website.pages.checkoutpage;

import core.baseassertions.BaseAssertions;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Assertions;
import website.pages.cartpage.CheckoutInformation;
import website.pages.productpage.ProductDetails;

import static Utils.Currency.Currency.*;
import static core.driver.Driver.*;

import java.text.NumberFormat;
import java.util.Arrays;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    private void assertProductNameCheckoutPage(ProductDetails expectedProduct) {
        String nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(),
                expectedProduct.getName()
        );
        Assertions.assertEquals(expectedProduct.getName(), elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), nameMessage);
    }

    private void assertProductQuantityCheckoutPage(ProductDetails expectedProduct) {
        String quantityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productQuantityElement(expectedProduct.getId(), expectedProduct.getName()).getAttribute("value"),
                expectedProduct.getQuantity()
        );
        Assertions.assertEquals(expectedProduct.getQuantity(), elementsT().productQuantityElement(expectedProduct.getId(), expectedProduct.getName()).getAttribute("value"), quantityMessage);
    }

    private void assertProductUnitPriceCheckoutPage(ProductDetails expectedProduct) {
        String unitPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productPriceElement("text-right", expectedProduct.getUnitPrice()).getText(),
                expectedProduct.getUnitPrice()
        );
        Assertions.assertEquals(expectedProduct.getUnitPrice(), elementsT().productPriceElement("text-right", expectedProduct.getUnitPrice()).getText(), unitPriceMessage);
    }

    private void assertProductTotalPriceCheckoutPage(ProductDetails expectedProduct) {
        String totalPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION,
                elementsT().productTotalPriceElement("text-right", expectedProduct.getUnitPrice()).getText(),
                String.format("%.2f", expectedProduct.getTotal())
        );
        Assertions.assertEquals(String.format("$%.2f", expectedProduct.getTotal()), elementsT().productTotalPriceElement("text-right", expectedProduct.getUnitPrice()).getText(), totalPriceMessage);
    }

    public void assertProductInformationCheckoutPage(ProductDetails... expectedProducts) {
        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductNameCheckoutPage(expectedProduct),
                        () -> assertProductQuantityCheckoutPage(expectedProduct)
                       // () -> assertProductUnitPriceCheckoutPage(expectedProduct)
                        //() -> assertProductTotalPriceCheckoutPage(expectedProduct)
                ));
    }

    private void assertProductNameConfirmPage(ProductDetails expectedProductInfo) {
        String nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderProductName("text-left", expectedProductInfo.getName()).getText(),
                expectedProductInfo.getName()
        );

        Assertions.assertEquals(expectedProductInfo.getName(), elementsT().confirmOrderProductName("text-left", expectedProductInfo.getName()).getText(), nameMessage);
    }

    private void assertProductModelConfirmPage(ProductDetails expectedProductInfo) {
        String modelMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderInformation("text-left", expectedProductInfo.getModel()).getText(),
                expectedProductInfo.getModel()
        );

        Assertions.assertEquals(expectedProductInfo.getModel(), elementsT().confirmOrderInformation("text-left", expectedProductInfo.getModel()).getText(), modelMessage);
    }

    private void assertProductQuantityConfirmPage(ProductDetails expectedProductInfo) {
        String quantityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderQuantityElement(expectedProductInfo.getModel()).getText(), expectedProductInfo.getQuantity()
        );

        Assertions.assertEquals(expectedProductInfo.getQuantity(), elementsT().confirmOrderQuantityElement(expectedProductInfo.getModel()).getText(), quantityMessage);
    }

    private void assertProductPriceConfirmPage(ProductDetails expectedProductInfo) {
        String priceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ERROR_MESSAGE_PRODUCT,
                elementsT().confirmOrderPriceElement(expectedProductInfo.getQuantity()).getText(),
                expectedProductInfo.getUnitPrice()
        );

        Assertions.assertEquals(expectedProductInfo.getUnitPrice(), elementsT().confirmOrderPriceElement(expectedProductInfo.getQuantity()).getText(), priceMessage);
    }

    public void assertProductInformationConfirmOrder(ProductDetails... expectedProducts) {
        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductNameConfirmPage(expectedProduct),
                        () -> assertProductModelConfirmPage(expectedProduct),
                        () -> assertProductQuantityConfirmPage(expectedProduct)
                        //() -> assertProductPriceConfirmPage(expectedProduct)
                ));
    }

    private void assertProductSubTotalPrice(CheckoutInformation... expectedProducts) {
        waitForAjax();
        elementsT().scrollToVisible(elementsT().searchButton());
        elementsT().updateButton().click();

        double expectedSubTotal = Arrays.stream(expectedProducts).mapToDouble(CheckoutInformation::getSubTotal).sum();

        NumberFormat currencyFormat = getDollarFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedSubTotal);
        String actualSubTotalText = elementsT().subTotal().getText();

        String subtotalPriceMessage = String.format("Expected subtotal: %s, but got: %s", expectedTotalFormatted, actualSubTotalText);
        Assertions.assertEquals(expectedTotalFormatted, actualSubTotalText, subtotalPriceMessage);
    }

    private void assertProductTotalPrice(CheckoutInformation... checkoutInformation) {
        waitForAjax();
        var billingDetails = CustomerFactory.generateBillingAddress();

        double expectedTotal;
        if ("United Kingdom".equals(billingDetails.getCountry())) {
            expectedTotal = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getTotal).sum();

        } else {
            double subTotalSum = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getSubTotal).sum();
            double shippingRateSum = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getFlatShippingRate).sum();
            expectedTotal = subTotalSum + shippingRateSum;
        }

        NumberFormat currencyFormat = getDollarFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedTotal);
        String actualTotalText = elementsT().total().getText();
        String totalMessage = String.format("Expected Result: %s \n Actual Result: %s", expectedTotalFormatted, actualTotalText);

        Assertions.assertEquals(expectedTotalFormatted, actualTotalText, totalMessage);
    }

    private void assertEcoTax(CheckoutInformation... checkoutInformation) {
        var billingDetails = CustomerFactory.generateBillingAddress();

        if ("United Kingdom".equals(billingDetails.getCountry())) {
            double expectedEcoTax = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getEcoTax).sum();
            NumberFormat currencyFormat = getDollarFormat();
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