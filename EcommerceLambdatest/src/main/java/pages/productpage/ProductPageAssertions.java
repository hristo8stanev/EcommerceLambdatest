package pages.productpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ERROR_MESSAGE_PRODUCT_INFORMATION;

public class ProductPageAssertions extends BaseAssertions<ProductPageMap> {

    public void assertSizeProductIsCorrect(ProductDetails expectedProduct) {
        var sizeMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getId(), expectedProduct.getSize());
        Assertions.assertEquals(elementsT().productSize(expectedProduct.getId()).getText(), expectedProduct.getSize(), sizeMessage);
        elementsT().removeButton().click();
    }
}