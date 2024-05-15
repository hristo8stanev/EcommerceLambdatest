package pages.wishlistpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.productpage.ProductDetails;

import static constants.Constants.ErrorMessage;

public class WishlistPageAssertions extends BaseAssertions<WishlistPageMap> {


    public void assertProductAddedToWishList(ProductDetails expectedProduct) {
        var nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getName(),
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText());

        var modelMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getModel(),
                elementsT().productElementInformation(expectedProduct.getModel()).getText(), expectedProduct.getModel());

        var messageAvailability = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage,
                elementsT().productElementInformation(expectedProduct.getAvailability()).getText(), expectedProduct.getAvailability());

        var messagePrice = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getUnitPrice(),
                elementsT().productPriceWishListElement(expectedProduct.getUnitPrice()).getText());

        Assertions.assertEquals(expectedProduct.getName(), elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), nameMessage);
        Assertions.assertEquals(expectedProduct.getModel(), elementsT().productElementInformation(expectedProduct.getModel()).getText(), modelMessage);
        Assertions.assertEquals(expectedProduct.getAvailability(), elementsT().productElementInformation(expectedProduct.getAvailability()).getText(), messageAvailability);
        Assertions.assertEquals(expectedProduct.getUnitPrice(), elementsT().productPriceWishListElement(expectedProduct.getUnitPrice()).getText(), messagePrice);

        elementsT().removeFromWishList().click();
    }

}
