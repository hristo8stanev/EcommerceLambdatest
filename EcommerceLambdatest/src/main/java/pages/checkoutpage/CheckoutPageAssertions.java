package pages.checkoutpage;

import core.baseassertions.BaseAssertions;
import factories.CustomerFactory;
import org.junit.jupiter.api.Assertions;
import pages.cartpage.BillingInformation;
import pages.cartpage.CheckoutInformation;
import pages.productpage.ProductDetails;

import java.util.Arrays;

import static constants.Constants.*;

public class CheckoutPageAssertions extends BaseAssertions<CheckoutPageMap> {

    public void assertConfirmButtonDisplayed() {
        boolean isConfirmButtonDisplayed = elementsT().confirmOrderButton().isDisplayed();
        var confirmButtonMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ErrorMessageLogoutButton, isConfirmButtonDisplayed, true);
        Assertions.assertTrue(isConfirmButtonDisplayed, ErrorMessageLogoutButton);
    }

    public void assertSuccessfullyCheckoutOrder() {
        var successfullyCheckoutOrderMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ErrorMessageLogoutButton, elementsT().successfullyConfirmOrderText().getText(), SuccessfullyPurchaseMessage);
        Assertions.assertEquals(elementsT().successfullyConfirmOrderText().getText(), SuccessfullyPurchaseMessage, successfullyCheckoutOrderMessage);
    }

    public void assertProductInformationCorrect(ProductDetails expectedProduct) {

        String nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageProduct,
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(),
                expectedProduct.getName()
        );

        String quantityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageProduct,
                elementsT().productQuantityElement(expectedProduct.getId(), expectedProduct.getName()).getAttribute("value"),
                expectedProduct.getQuantity()
        );

        String unitPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageProduct,
                elementsT().productPriceElement("text-right", expectedProduct.getUnitPrice()).getText(),
                expectedProduct.getUnitPrice()
        );

        String totalPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessage,
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
                ErrorMessageProduct,
                elementsT().confirmOrderProductName("text-left", expectedProductInfo.getName()).getText(),
                expectedProductInfo.getName()
        );

        String modelMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageProduct,
                elementsT().confirmOrderInformation("text-left", expectedProductInfo.getModel()).getText(),
                expectedProductInfo.getModel()
        );

        String quantityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageProduct,
                elementsT().confirmOrderQuantityElement(expectedProductInfo.getModel()).getText(),
                expectedProductInfo.getQuantity()
        );

        String priceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageProduct,
                elementsT().confirmOrderPriceElement(expectedProductInfo.getQuantity()).getText(),
                expectedProductInfo.getUnitPrice()
        );

        // Perform assertions
        Assertions.assertEquals(expectedProductInfo.getName(), elementsT().confirmOrderProductName("text-left", expectedProductInfo.getName()).getText(), nameMessage);
        Assertions.assertEquals(expectedProductInfo.getModel(), elementsT().confirmOrderInformation("text-left", expectedProductInfo.getModel()).getText(), modelMessage);
        Assertions.assertEquals(expectedProductInfo.getQuantity(), elementsT().confirmOrderQuantityElement(expectedProductInfo.getModel()).getText(), quantityMessage);
        Assertions.assertEquals(expectedProductInfo.getUnitPrice(), elementsT().confirmOrderPriceElement(expectedProductInfo.getQuantity()).getText(), priceMessage);
    }

    private void assertProductSubTotalPrice(CheckoutInformation... expectedProducts) {
        elementsT().waitForAjax();
        elementsT().searchButton();
        // elementsT().updateButton().click(); // Uncomment if needed

        // Calculate expected subtotal
        double expectedSubTotal = Arrays.stream(expectedProducts)
                .mapToDouble(CheckoutInformation::getSubTotal)
                .sum();
        // Format expected subtotal to match currency format
        String expectedSubTotalFormatted = String.format("$%.2f", expectedSubTotal);

        // Get actual subtotal text from the web element
        String actualSubTotalText = elementsT().subTotal().getText();

        // Assertion with the message
        String subtotalPriceMessage = String.format("Expected subtotal: %s, but got: %s", expectedSubTotalFormatted, actualSubTotalText);
        Assertions.assertEquals(expectedSubTotalFormatted, actualSubTotalText, subtotalPriceMessage);
    }

    private void assertProductTotalPrice(CheckoutInformation... checkoutInformation) {
        elementsT().waitForAjax();
        BillingInformation billingDetails = new BillingInformation();

        double expectedTotal;

        if ("United Kingdom".equals(billingDetails.getCountry())) {
            expectedTotal = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getTotal).sum();


        } else {
            double subTotalSum = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getSubTotal).sum();
            double shippingRateSum = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getFlatShippingRate).sum();
            double vatTax = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getVatTax).sum();
            double ecoTax = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getEcoTax).sum();
            expectedTotal = subTotalSum + shippingRateSum + vatTax + ecoTax;
        }

        String expectedTotalFormatted = String.format("$%.2f", expectedTotal);
        String actualTotalText = elementsT().total().getText();

        String totalMessage = String.format("Expected Result: %s \n Actual Result: %s", expectedTotalFormatted, actualTotalText);
        Assertions.assertEquals(expectedTotalFormatted, actualTotalText, totalMessage);
    }

    private void assertEcoTax(CheckoutInformation... checkoutInformation) {
        var billingDetails = CustomerFactory.GenerateBillingAddress();

        if ("United Kingdom".equals(billingDetails.getCountry())) {
            double expectedEcoTax = Arrays.stream(checkoutInformation).mapToDouble(CheckoutInformation::getEcoTax).sum();
            String expectedEcoTaxFormatted = String.format("$%.2f", expectedEcoTax);
            String actualEcoTaxText = elementsT().ecoTaxElement().getText();
            String ecoTaxMessage = String.format("Expected Result: %s \n Actual Result: %s", expectedEcoTaxFormatted, actualEcoTaxText);
            Assertions.assertEquals(expectedEcoTaxFormatted, actualEcoTaxText, ecoTaxMessage);
        }
    }

    public void assertCheckoutInformation(CheckoutInformation checkoutInformation) {
        assertProductSubTotalPrice(checkoutInformation);
        assertEcoTax(checkoutInformation);
        assertProductTotalPrice(checkoutInformation);
    }
}
