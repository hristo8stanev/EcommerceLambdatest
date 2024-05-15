package pages.productpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ErrorMessage;

public class ProductPageAssertions extends BaseAssertions<ProductPageMap> {

    public void assertSizeProductIsCorrect(ProductDetails expectedProduct) {
        var sizeMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getId(), expectedProduct.getSize());
        Assertions.assertEquals(elementsT().productSize(expectedProduct.getId()).getText(), expectedProduct.getSize(), sizeMessage);
        elementsT().removeButton().click();
    }

    public void assertTheProductNameCorrect(ProductDetails expectedProduct) {
        var nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, elementsT().productNameElement(expectedProduct.id, expectedProduct.getName()).getText(), expectedProduct.getName());
        Assertions.assertEquals(elementsT().productNameElement(expectedProduct.id, expectedProduct.getName()).getText(), expectedProduct.getName(), nameMessage);
    }

}