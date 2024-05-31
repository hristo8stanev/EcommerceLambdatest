package website.pages.comparisonpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.util.Arrays;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ComparisonPageAssertions extends BaseAssertions<ComparisonPageMap> {

    private void assertProductName(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText();
        var actualResult = expectedProduct.getName();
        var nameMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, nameMessage);
    }

    private void assertProductPrice(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productElementInformation(expectedProduct.getUnitPrice()).getText();
        var actualResult = expectedProduct.getUnitPrice();
        var messagePrice = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, messagePrice);
    }

    private void assertProductBrand(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productElementInformation(expectedProduct.getBrand()).getText();
        var actualResult = expectedProduct.getBrand();
        var brandMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, brandMessage);
    }

    private void assertProductAvailability(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productElementInformation(expectedProduct.getAvailability()).getText();
        var actualResult = expectedProduct.getAvailability();
        var availabilityMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, availabilityMessage);
    }

    private void assertProductModel(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productElementInformation(expectedProduct.getModel()).getText();
        var actualResult = expectedProduct.getModel();
        var modelMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, modelMessage);
    }

    private void assertProductWeight(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productWeightElement(expectedProduct.getWeight()).getText();
        var actualResult = expectedProduct.getWeight();
        var weightMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, weightMessage);
    }

    public void assertTheProductAddedToComparePage(ProductDetails... expectedProducts) {
        Arrays.stream(expectedProducts).toList()
                .forEach(expectedProduct -> assertAll(
                        () -> assertProductName(expectedProduct),
                        () -> assertProductPrice(expectedProduct),
                        () -> assertProductBrand(expectedProduct),
                        () -> assertProductAvailability(expectedProduct),
                        () -> assertProductModel(expectedProduct),
                        () -> assertProductWeight(expectedProduct)
                ));
    }
}