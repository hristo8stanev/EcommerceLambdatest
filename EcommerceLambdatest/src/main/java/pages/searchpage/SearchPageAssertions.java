package pages.searchpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.productpage.ProductDetails;

import static constants.Constants.*;

public class SearchPageAssertions extends BaseAssertions<SearchPageMap> {

    public void assertTheProductNameAndPrice(ProductDetails expectedProduct) {

        var nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, elementsT().getProductName(expectedProduct.getId(),
                expectedProduct.getName()).getText(), expectedProduct.getName());
        var priceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, elementsT().getProductPrice().getText(), expectedProduct.getUnitPrice());

        Assertions.assertEquals(elementsT().getProductName(expectedProduct.getId(), expectedProduct.getName()).getText(), expectedProduct.getName(), nameMessage);
        Assertions.assertEquals(elementsT().getProductPrice().getText(), expectedProduct.getUnitPrice(), priceMessage);
    }

    public void assertErrorMessageWhenNonExistingProductIsSearched() {
        var errorMessageNonExistingProduct = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage,
                elementsT().errorMessageNonExistingProduct(ExpectedMessageNonExistingProduct).getText(), ExpectedMessageNonExistingProduct);

        Assertions.assertEquals(elementsT().errorMessageNonExistingProduct(ExpectedMessageNonExistingProduct).getText(), ExpectedMessageNonExistingProduct, errorMessageNonExistingProduct);
    }
}