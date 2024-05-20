package pages.searchpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.productpage.ProductDetails;

import static constants.Constants.*;

public class SearchPageAssertions extends BaseAssertions<SearchPageMap> {

    public void assertTheProductNameAndPrice(ProductDetails expectedProduct) {

        var nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, elementsT().getProductName(expectedProduct.getId(),
                expectedProduct.getName()).getText(), expectedProduct.getName());
        var priceMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, elementsT().getProductPrice().getText(), expectedProduct.getUnitPrice());

        Assertions.assertEquals(elementsT().getProductName(expectedProduct.getId(), expectedProduct.getName()).getText(), expectedProduct.getName(), nameMessage);
        Assertions.assertEquals(elementsT().getProductPrice().getText(), expectedProduct.getUnitPrice(), priceMessage);
    }

    public void assertErrorMessageWhenNonExistingProductIsSearched() {
        var errorMessageNonExistingProduct = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION,
                elementsT().errorMessageNonExistingProduct(EXPECTED_MESSAGE_NON_EXISTING_PRODUCT).getText(), EXPECTED_MESSAGE_NON_EXISTING_PRODUCT);

        Assertions.assertEquals(elementsT().errorMessageNonExistingProduct(EXPECTED_MESSAGE_NON_EXISTING_PRODUCT).getText(), EXPECTED_MESSAGE_NON_EXISTING_PRODUCT, errorMessageNonExistingProduct);
    }
}