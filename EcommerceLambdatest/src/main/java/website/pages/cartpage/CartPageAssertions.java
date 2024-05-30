package website.pages.cartpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.text.NumberFormat;
import java.util.Arrays;

import static Utils.currency.Currency.*;
import static constants.Constants.*;

import static core.driver.Driver.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CartPageAssertions extends BaseAssertions<CartPageMap> {

    public void assertProductName(ProductDetails expectedProduct) {
        var messageName = formatMessage(ERROR_MESSAGE_PRODUCT, elementsT().productNameElement(expectedProduct).getText(), expectedProduct.getName());
        Assertions.assertEquals(elementsT().productNameElement(expectedProduct).getText(), expectedProduct.getName(), messageName);
    }

    private void assertProductModel(ProductDetails expectedProductInfo) {
        var messageModel = formatMessage(ERROR_MESSAGE_PRODUCT, elementsT().productModel(expectedProductInfo).getText(), expectedProductInfo.getModel());
        Assertions.assertEquals(elementsT().productModel(expectedProductInfo).getText(), expectedProductInfo.getModel(), messageModel);
    }

    private void assertProductQuantity(ProductDetails expectedProductInfo) {
        var messageQuantity = formatMessage(ERROR_MESSAGE_PRODUCT, elementsT().productQuantity(expectedProductInfo).getAttribute("value"), expectedProductInfo.getQuantity());
        Assertions.assertEquals(elementsT().productQuantity(expectedProductInfo).getAttribute("value"), expectedProductInfo.getQuantity(), messageQuantity);
    }

    private void assertProductUnitPrice(ProductDetails expectedProductInfo) {
        var messagePrice = formatMessage(ERROR_MESSAGE_PRODUCT, elementsT().productPriceElement(expectedProductInfo.getUnitPrice()).getText(), expectedProductInfo.getUnitPrice());
        Assertions.assertEquals(elementsT().productPriceElement(expectedProductInfo.getUnitPrice()).getText(), expectedProductInfo.getUnitPrice(), messagePrice);
    }

    private void assertProductTotalPrice(ProductDetails expectedProductInfo) {
        var totalPriceMessage = formatMessage(ERROR_MESSAGE_PRODUCT, elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText(), String.valueOf(expectedProductInfo.getTotal()));

        NumberFormat currencyFormat = getDollarFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedProductInfo.getTotal());
        Assertions.assertEquals(elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText(), expectedTotalFormatted, totalPriceMessage);
    }

    public void assertProductsInformation(ProductDetails... expectedProducts) {

        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductName(expectedProduct),
                        () -> assertProductModel(expectedProduct),
                        () -> assertProductQuantity(expectedProduct),
                        () -> assertProductUnitPrice(expectedProduct),
                        () -> assertProductTotalPrice(expectedProduct)
                ));
        waitForAjax();
    }

    public void assertProductRemoved(ProductDetails product) {
        var errorMessageRemovedProduct = String.format("The product %s is still present in the Shopping Cart.", product.getName());
        var expectedMessage = "Your shopping cart is empty!";
        var removedProductMessage = formatMessage(errorMessageRemovedProduct, elementsT().removedProduct(expectedMessage).getText(), expectedMessage);
        Assertions.assertTrue(elementsT().removedProduct(expectedMessage).getText().contains(expectedMessage), removedProductMessage);
    }

    public void assertSuccessfullyUpdatedQuantity(String expectedQuantity) {
        var successfullyUpdateQuantityMessage = formatMessage(ERROR_MESSAGE_PRODUCT, elementsT().updateQuantityField().getAttribute("value"), expectedQuantity);
        Assertions.assertEquals(elementsT().updateQuantityField().getAttribute("value"), expectedQuantity, successfullyUpdateQuantityMessage);
        waitForAjax();
    }
}