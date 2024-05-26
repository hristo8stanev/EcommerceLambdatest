package pages.cartpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.productpage.ProductDetails;

import java.text.NumberFormat;

import static constants.Constants.*;

import static core.basepage.WebPage.*;
import static core.driver.Driver.waitForAjax;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CartPageAssertions extends BaseAssertions<CartPageMap> {

    private void assertProductName(ProductDetails expectedProduct) {
        var messageName = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productNameElement(expectedProduct).getText(), expectedProduct.getName());
        Assertions.assertEquals(elementsT().productNameElement(expectedProduct).getText(), expectedProduct.getName(), messageName);
    }

    private void assertProductModel(ProductDetails expectedProductInfo) {
        var messageModel = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productModel(expectedProductInfo).getText(), expectedProductInfo.getModel());
        Assertions.assertEquals(elementsT().productModel(expectedProductInfo).getText(), expectedProductInfo.getModel(), messageModel);
    }

    private void assertProductQuantity(ProductDetails expectedProductInfo) {
        var messageQuantity = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productQuantity("form-control").getAttribute("value"), expectedProductInfo.getQuantity());
        Assertions.assertEquals(elementsT().productQuantity("form-control").getAttribute("value"), expectedProductInfo.getQuantity(), messageQuantity);
    }

    private void assertProductUnitPrice(ProductDetails expectedProductInfo) {
        var messagePrice = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productPriceElement(expectedProductInfo.getUnitPrice()).getText(), expectedProductInfo.getUnitPrice());
        Assertions.assertEquals(elementsT().productPriceElement(expectedProductInfo.getUnitPrice()).getText(), expectedProductInfo.getUnitPrice(), messagePrice);
    }

    private void assertProductTotalPrice(ProductDetails expectedProductInfo) {
        var totalPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText(), expectedProductInfo.getTotal());

        NumberFormat currencyFormat = getNumberFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedProductInfo.getTotal());
        Assertions.assertEquals(elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText(), expectedTotalFormatted, totalPriceMessage);
    }

    public void assertProductsInformation(ProductDetails expectedProduct) {
        assertAll(
                () -> assertProductName(expectedProduct),
                () -> assertProductModel(expectedProduct),
                () -> assertProductQuantity(expectedProduct),
                () -> assertProductUnitPrice(expectedProduct),
                () -> assertProductTotalPrice(expectedProduct)
        );

        elementsT().removeButton().click();
        waitForAjax();
    }

    public void assertProductRemoved() {
        var expectedProductInfo = new ProductDetails();
        var errorMessageRemovedProduct = String.format("The product %s is still present in the Shopping Cart.", expectedProductInfo.getName());
        var expectedMessage = "Your shopping cart is empty!";

        var removedProductMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", errorMessageRemovedProduct,
                elementsT().removedProduct(expectedMessage).getText(), expectedMessage);

        Assertions.assertTrue(elementsT().removedProduct(expectedMessage).getText().contains(expectedMessage), removedProductMessage);
    }

    public void assertSuccessfullyUpdatedQuantity(String expectedQuantity) {
        var successfullyUpdateQuantityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().updateQuantityField().getAttribute("value"), expectedQuantity);

        Assertions.assertEquals(elementsT().updateQuantityField().getAttribute("value"), expectedQuantity, successfullyUpdateQuantityMessage);

        elementsT().removeButton().click();
        waitForAjax();
    }
}