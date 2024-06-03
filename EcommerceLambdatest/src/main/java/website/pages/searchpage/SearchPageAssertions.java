package website.pages.searchpage;

import core.baseassertions.BaseAssertions;
import core.driver.Driver;
import enums.Manufacturer;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.util.Arrays;

import static constants.Constants.*;
import static core.driver.Driver.waitForAjax;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SearchPageAssertions extends BaseAssertions<SearchPageMap> {

    private void assertProductName(ProductDetails expectedProduct) {
        var expectedResult = elementsT().getProductName(expectedProduct.getId(), expectedProduct.getName()).getText();
        var actualResult = expectedProduct.getName();
        var nameMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, nameMessage);
    }

    private void assertProductPrice(ProductDetails expectedProduct) {
        var expectedResult = elementsT().getProductPrice().getText();
        var actualResult = expectedProduct.getUnitPrice();
        var priceMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, priceMessage);
    }

    public void assertProducts(ProductDetails... expectedProducts) {
        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductName(expectedProduct)
                        //() -> assertProductPrice(expectedProduct)
                ));
    }

    public void assertErrorMessageWhenNonExistingProductIsSearched() {
        var expectedResult = elementsT().errorMessageNonExistingProduct(EXPECTED_MESSAGE_NON_EXISTING_PRODUCT).getText();
        var actualResult = EXPECTED_MESSAGE_NON_EXISTING_PRODUCT;
        var errorMessageNonExistingProduct = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, errorMessageNonExistingProduct);
    }

    private void assertQuickViewProductName(ProductDetails expectedProduct) {
        var expectedResult = elementsT().quickViewProductName().getText();
        var actualResult = expectedProduct.getName();
        var quickViewProductName = formatMessage(ERROR_MESSAGE_PRODUCT_NAME, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, quickViewProductName);
    }

    private void assertQuickViewProductPrice(ProductDetails expectedProduct) {
        var expectedResult = elementsT().quickViewPrice().getText();
        var actualResult = expectedProduct.getUnitPrice();
        var quickViewProductPrice = formatMessage(ERROR_MESSAGE_PRODUCT_PRICE, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, quickViewProductPrice);
    }

    private void assertQuickViewProductBrand(ProductDetails expectedProduct) {
        var expectedResult = expectedProduct.getBrand();
        var actualResult = elementsT().quickViewBrand().getText();
        var quickViewProductBrand = formatMessage(ERROR_MESSAGE_PRODUCT_BRAND, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, quickViewProductBrand);
    }

    private void assertQuickViewProductModel(ProductDetails expectedProduct) {
        var expectedResult = expectedProduct.getModel();
        var actualResult = elementsT().quickViewModel().getText();
        var quickViewProductModel = formatMessage(ERROR_MESSAGE_PRODUCT_MODEL, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, quickViewProductModel);
    }

    private void assertQuickViewProductAvailability(ProductDetails expectedProduct) {
        var expectedResult = expectedProduct.getAvailability();
        var actualResult = elementsT().quickViewAvailability().getText();
        var quickViewProductAvailability = formatMessage(ERROR_MESSAGE_PRODUCT_AVAILABILITY, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, quickViewProductAvailability);
    }

    public void assertProductInformation(ProductDetails... expectedProducts) {
        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertQuickViewProductName(expectedProduct),
                        () -> assertQuickViewProductPrice(expectedProduct),
                        () -> assertQuickViewProductModel(expectedProduct),
                        () -> assertQuickViewProductBrand(expectedProduct),
                        () -> assertQuickViewProductAvailability(expectedProduct)));
    }

    public void assertFilterProductByManufacturer(Manufacturer manufacturer) {
        waitForAjax();
        elementsT().waitUntilPageLoadsCompletely();
        var isProductDisplayed = elementsT().titleNameByManufacturer(manufacturer).isDisplayed();
        Assertions.assertTrue(isProductDisplayed, ERROR_MESSAGE_PRODUCT);
    }
}