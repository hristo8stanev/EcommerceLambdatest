package website.pages.checkoutpage;

import core.baseassertions.BaseAssertions;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Assertions;
import website.pages.cartpage.CheckoutInformation;
import website.pages.productpage.ProductDetails;

import static utils.currency.Currency.*;
import static core.driver.Driver.*;

import java.text.NumberFormat;
import java.util.Arrays;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CheckoutPageAssertions extends BaseAssertions<CheckoutPageMap> {

    public void assertErrorMessageWithoutAgreeterms() {
        var expectedResult = ERROR_MESSAGE_AGREE_TERMS;
        var actualResult = elementsT().errorMessageAgreeTerms().getText();
        var errorMessageAgreeTerms = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, errorMessageAgreeTerms);
    }

    public void assertConfirmButtonDisplayed() {
        boolean isConfirmButtonDisplayed = elementsT().confirmOrderButton().isDisplayed();
        var expectedResult = String.valueOf(true);
        var confirmButtonMessage = formatMessage(ERROR_MESSAGE_LOGOUT_BUTTON, String.valueOf(isConfirmButtonDisplayed), expectedResult);
        Assertions.assertTrue(isConfirmButtonDisplayed, ERROR_MESSAGE_LOGOUT_BUTTON);
    }

    public void assertSuccessfullyCheckoutOrder() {
        var expectedMessage = SUCCESSFULLY_PURCHASE_MESSAGE;
        var actualResult = elementsT().successfullyConfirmOrderText().getText();
        var successfullyCheckoutOrderMessage = formatMessage(ERROR_MESSAGE_LOGOUT_BUTTON, actualResult, expectedMessage);
        Assertions.assertEquals(actualResult, expectedMessage, successfullyCheckoutOrderMessage);
    }

    private void assertProductNameCheckoutPage(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText();
        var actualResult = expectedProduct.getName();
        var nameMessage = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, nameMessage);
    }

    private void assertProductQuantityCheckoutPage(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productQuantityElement(expectedProduct.getId(), expectedProduct.getName()).getAttribute("value");
        var actualResult = expectedProduct.getQuantity();
        var quantityMessage = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, quantityMessage);
    }

    private void assertProductUnitPriceCheckoutPage(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productPriceElement("text-right", expectedProduct.getUnitPrice()).getText();
        var actualResult = expectedProduct.getUnitPrice();
        var unitPriceMessage = formatMessage(ERROR_MESSAGE_PRODUCT, actualResult, expectedResult);
        Assertions.assertEquals(expectedResult, actualResult, unitPriceMessage);
    }

    private void assertProductTotalPriceCheckoutPage(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productTotalPriceElement("text-right", expectedProduct.getUnitPrice()).getText();
        var actualResult = expectedProduct.getTotal();
        var totalPriceMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, String.format("%.2f", actualResult));
        Assertions.assertEquals(String.format("$%.2f", actualResult), expectedResult, totalPriceMessage);
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
        var expectedResult = elementsT().confirmOrderProductName("text-left", expectedProductInfo.getName()).getText();
        var actualResult = expectedProductInfo.getName();
        var nameMessage = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(actualResult, expectedResult, nameMessage);
    }

    private void assertProductModelConfirmPage(ProductDetails expectedProductInfo) {
        var expectedResult = elementsT().confirmOrderInformation("text-left", expectedProductInfo.getModel()).getText();
        var actualResult = expectedProductInfo.getModel();
        var modelMessage = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, modelMessage);
    }

    private void assertProductQuantityConfirmPage(ProductDetails expectedProductInfo) {
        var expectedResult = elementsT().confirmOrderQuantityElement(expectedProductInfo.getModel()).getText();
        var actualResult = expectedProductInfo.getQuantity();
        var quantityMessage = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, quantityMessage);
    }

    private void assertProductPriceConfirmPage(ProductDetails expectedProductInfo) {
        var expectedResult = elementsT().confirmOrderPriceElement(expectedProductInfo.getQuantity()).getText();
        var actualResult = expectedProductInfo.getUnitPrice();
        String priceMessage = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, priceMessage);
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

    private void updateProduct() {
        waitForAjax();
        elementsT().scrollToVisible(elementsT().searchButton());
        elementsT().updateButton().click();
    }

    private void assertProductSubTotalPrice(CheckoutInformation... expectedProducts) {
        updateProduct();
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