package website.pages.comparisonpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.productpage.ProductDetails;

import java.util.Arrays;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ComparisonPageAssertions extends BaseAssertions<ComparisonPageMap> {

    private void assertProductName(ProductDetails expectedProduct) {
        var nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getName(),
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText());
        Assertions.assertEquals(expectedProduct.getName(), elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), nameMessage);
    }

    private void assertProductPrice(ProductDetails expectedProduct) {
        var messagePrice = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getUnitPrice(),
                elementsT().productElementInformation(expectedProduct.getUnitPrice()).getText());
        Assertions.assertEquals(expectedProduct.getUnitPrice(), elementsT().productElementInformation(expectedProduct.getUnitPrice()).getText(), messagePrice);
    }

    private void assertProductBrand(ProductDetails expectedProduct) {
        var brandMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getBrand(),
                elementsT().productElementInformation(expectedProduct.getBrand()).getText());
        Assertions.assertEquals(expectedProduct.getBrand(), elementsT().productElementInformation(expectedProduct.getBrand()).getText(), brandMessage);
    }

    private void assertProductAvailability(ProductDetails expectedProduct) {
        var availabilityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getAvailability(),
                elementsT().productElementInformation(expectedProduct.getAvailability()).getText());
        Assertions.assertEquals(expectedProduct.getAvailability(), elementsT().productElementInformation(expectedProduct.getAvailability()).getText(), availabilityMessage);
    }

    private void assertProductModel(ProductDetails expectedProduct) {
        var modelMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getModel(),
                elementsT().productElementInformation(expectedProduct.getModel()).getText());
        Assertions.assertEquals(expectedProduct.getModel(), elementsT().productElementInformation(expectedProduct.getModel()).getText(), modelMessage);
    }

    private void assertProductWeight(ProductDetails expectedProduct) {
        var weightMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PRODUCT_INFORMATION, expectedProduct.getWeight(),
                elementsT().productWeightElement(expectedProduct.getWeight()).getText());
        Assertions.assertEquals(expectedProduct.getWeight(), elementsT().productWeightElement(expectedProduct.getWeight()).getText(), weightMessage);
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