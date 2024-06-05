package website.pages.wishlistpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.util.Arrays;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WishlistPageAssertions extends BaseAssertions<WishlistPageMap> {

    private void assertProductName(ProductDetails expectedProduct) {
        var expectedResult = expectedProduct.getName();
        var actualResult = elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText();
        var nameMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, nameMessage);
    }

    private void assertProductModel(ProductDetails expectedProduct) {
        var expectedResult = expectedProduct.getModel();
        var actualResult = elementsT().productElementInformation(expectedProduct.getModel()).getText();
        var modelMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, modelMessage);
    }

    private void assertProductAvailability(ProductDetails expectedProduct) {
        var expectedResult = expectedProduct.getAvailability();
        var actualResult = elementsT().productElementInformation(expectedProduct.getAvailability()).getText();
        var messageAvailability = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, messageAvailability);
    }

    private void assertProductPrice(ProductDetails expectedProduct) {
        var expectedResult = expectedProduct.getUnitPrice();
        var actualResult = elementsT().productPriceWishListElement(expectedProduct.getUnitPrice()).getText();
        var messagePrice = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, messagePrice);
    }

    public void assertProductAddedToWishList(ProductDetails... expectedProducts) {

        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductName(expectedProduct),
                        () -> assertProductName(expectedProduct),
                        () -> assertProductModel(expectedProduct),
                        () -> assertProductAvailability(expectedProduct)
                        //() -> assertProductPrice(expectedProduct)
                ));
    }
}