package website.pages.wishlistpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.util.Arrays;

import static constants.Constants.ERROR_MESSAGE_PRODUCT_INFORMATION;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WishlistPageAssertions extends BaseAssertions<WishlistPageMap> {


    private void assertProductName(ProductDetails expectedProduct) {
        var nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getName(),
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText());
        Assertions.assertEquals(expectedProduct.getName(), elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), nameMessage);
    }

    private void assertProductModel(ProductDetails expectedProduct) {
        var modelMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getModel(),
                elementsT().productElementInformation(expectedProduct.getModel()).getText());

        Assertions.assertEquals(expectedProduct.getModel(), elementsT().productElementInformation(expectedProduct.getModel()).getText(), modelMessage);
    }

    private void assertProductAvailability(ProductDetails expectedProduct) {
        var messageAvailability = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION,
                elementsT().productElementInformation(expectedProduct.getAvailability()).getText(), expectedProduct.getAvailability());
        Assertions.assertEquals(expectedProduct.getAvailability(), elementsT().productElementInformation(expectedProduct.getAvailability()).getText(), messageAvailability);
    }

    private void assertProductPrice(ProductDetails expectedProduct) {
        var messagePrice = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getUnitPrice(),
                elementsT().productPriceWishListElement(expectedProduct.getUnitPrice()).getText());
        Assertions.assertEquals(expectedProduct.getUnitPrice(), elementsT().productPriceWishListElement(expectedProduct.getUnitPrice()).getText(), messagePrice);
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