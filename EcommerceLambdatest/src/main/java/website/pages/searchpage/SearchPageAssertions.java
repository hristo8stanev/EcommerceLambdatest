package website.pages.searchpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.util.Arrays;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SearchPageAssertions extends BaseAssertions<SearchPageMap> {

    private void assertProductName(ProductDetails expectedProduct) {
        var nameMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, elementsT().getProductName(expectedProduct.getId(), expectedProduct.getName()).getText(), expectedProduct.getName());
        Assertions.assertEquals(elementsT().getProductName(expectedProduct.getId(), expectedProduct.getName()).getText(), expectedProduct.getName(), nameMessage);
    }

    private void assertProductPrice(ProductDetails expectedProduct) {
        var priceMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, elementsT().getProductPrice().getText(), expectedProduct.getUnitPrice());
        Assertions.assertEquals(elementsT().getProductPrice().getText(), expectedProduct.getUnitPrice(), priceMessage);
    }

    public void assertProducts(ProductDetails... expectedProducts) {
        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductName(expectedProduct)
                        //() -> assertProductPrice(expectedProduct)
                ));
    }

    public void assertErrorMessageWhenNonExistingProductIsSearched() {
        var errorMessageNonExistingProduct = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, elementsT().errorMessageNonExistingProduct(EXPECTED_MESSAGE_NON_EXISTING_PRODUCT).getText(), EXPECTED_MESSAGE_NON_EXISTING_PRODUCT);
        Assertions.assertEquals(elementsT().errorMessageNonExistingProduct(EXPECTED_MESSAGE_NON_EXISTING_PRODUCT).getText(), EXPECTED_MESSAGE_NON_EXISTING_PRODUCT, errorMessageNonExistingProduct);
    }
}