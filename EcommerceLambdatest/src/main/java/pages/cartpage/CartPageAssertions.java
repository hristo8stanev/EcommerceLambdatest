package pages.cartpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.productpage.ProductDetails;
import static core.driver.Driver.*;

import java.text.NumberFormat;

import static constants.Constants.ERROR_MESSAGE_PRODUCT;
import static core.basepage.WebPage.getNumberFormat;

public class CartPageAssertions extends BaseAssertions<CartPageMap> {

    public void assertProductName(ProductDetails expectedProduct) {
        var messageName = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), expectedProduct.getName());

        Assertions.assertEquals(elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), expectedProduct.getName(), messageName);
        waitForAjax();
    }

    public void assertProductInformation(ProductDetails expectedProductInfo) {
        var messageModel = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productModel(expectedProductInfo.getModel()).getText(), expectedProductInfo.getModel());
        var messageQuantity = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productQuantity("form-control").getAttribute("value"), expectedProductInfo.getQuantity());
        var messagePrice = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productPriceElement(expectedProductInfo.getUnitPrice()).getText(), expectedProductInfo.getUnitPrice());
        var totalPriceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT,
                elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText(), expectedProductInfo.getTotal());

        Assertions.assertEquals(elementsT().productModel(expectedProductInfo.getModel()).getText(), expectedProductInfo.getModel(), messageModel);
        Assertions.assertEquals(elementsT().productQuantity("form-control").getAttribute("value"), expectedProductInfo.getQuantity(), messageQuantity);
        Assertions.assertEquals(elementsT().productPriceElement(expectedProductInfo.getUnitPrice()).getText(), expectedProductInfo.getUnitPrice(), messagePrice);

        NumberFormat currencyFormat = getNumberFormat();
        String expectedTotalFormatted = currencyFormat.format(expectedProductInfo.getTotal());
        Assertions.assertEquals(elementsT().productTotalPriceElement(String.valueOf(expectedProductInfo.getTotal())).getText(), expectedTotalFormatted, totalPriceMessage);

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