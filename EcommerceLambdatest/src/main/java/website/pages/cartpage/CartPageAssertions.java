package website.pages.cartpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.text.NumberFormat;
import java.util.Arrays;

import static utils.currency.Currency.*;
import static constants.Constants.*;

import static core.driver.Driver.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CartPageAssertions extends BaseAssertions<CartPageMap> {

    public void assertProductName(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productNameElement(expectedProduct).getText();
        var actualResult = expectedProduct.getName();
        var messageName = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, messageName);
    }

    private void assertProductModel(ProductDetails expectedProductInfo) {
        var expectedResult = elementsT().productModel(expectedProductInfo).getText();
        var actualResult = expectedProductInfo.getModel();
        var messageModel = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, messageModel);
    }

    private void assertProductQuantity(ProductDetails expectedProductInfo) {
        var expectedResult = elementsT().productQuantity(expectedProductInfo).getAttribute("value");
        var actualResult = expectedProductInfo.getQuantity();
        var messageQuantity = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, messageQuantity);
    }

    private void assertProductUnitPrice(ProductDetails expectedProductInfo) {
        var expectedResult = elementsT().productPriceElement(expectedProductInfo.getUnitPrice()).getText();
        var actualResult = expectedProductInfo.getUnitPrice();
        var messagePrice = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, messagePrice);
    }

    private void assertProductTotalPrice(ProductDetails expectedProductInfo) {
        var expectedResult = elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText();
        var actualResult = String.valueOf(expectedProductInfo.getTotal());
        var totalPriceMessage = formatMessage(ERROR_MESSAGE_PRODUCT, expectedResult, actualResult);

        NumberFormat currencyFormat = getDollarFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedProductInfo.getTotal());
        Assertions.assertEquals(elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText(), expectedTotalFormatted, totalPriceMessage);
    }

    public void assertProductsInformation(ProductDetails... expectedProducts) {
        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductName(expectedProduct),
                        () -> assertProductModel(expectedProduct),
                        //() -> assertProductQuantity(expectedProduct),
                        () -> assertProductUnitPrice(expectedProduct),
                        () -> assertProductTotalPrice(expectedProduct)
                ));
        waitForAjax();
    }

    public void assertProductRemoved(ProductDetails product) {
        var errorMessageRemovedProduct = String.format("The product %s is still present in the Shopping Cart.", product.getName());
        var expectedResult = elementsT().removedProduct(YOUR_SHOPPING_CART_IS_EMPTY).getText();
        var removedProductMessage = formatMessage(errorMessageRemovedProduct, expectedResult, YOUR_SHOPPING_CART_IS_EMPTY);
        Assertions.assertTrue(expectedResult.contains(YOUR_SHOPPING_CART_IS_EMPTY), removedProductMessage);
    }

    public void assertSuccessfullyUpdatedQuantity(String expectedQuantity) {
        var actualResult = elementsT().updateQuantityField().getAttribute("value");
        var successfullyUpdateQuantityMessage = formatMessage(ERROR_MESSAGE_PRODUCT, actualResult, expectedQuantity);
        Assertions.assertEquals(actualResult, expectedQuantity, successfullyUpdateQuantityMessage);
        waitForAjax();
    }

    public void assertErrorMessageMinimumOrderAmount() {
        String actualMessage = elementsT().errorMessageMinimumAmount().getText().trim();
        String expectedMessage = ERROR_MESSAGE_MINIMUM_AMOUNT;
        String message = String.format("Actual Result: %s  Expected Result: %s ", actualMessage, expectedMessage);
        Assertions.assertEquals(expectedMessage, actualMessage, message);
    }
}