package pages.comparisonpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.productpage.ProductDetails;

import static constants.Constants.*;

public class ComparisonPageAssertions extends BaseAssertions<ComparisonPageMap> {

    public void assertTheProductAddedToComparePage(ProductDetails expectedProduct) {
        var nameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getName(),
                elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText());

        var messagePrice = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getUnitPrice(),
                elementsT().productElementInformation(expectedProduct.getUnitPrice()).getText());

        var brandMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getBrand(),
                elementsT().productElementInformation(expectedProduct.getBrand()).getText());

        var availabilityMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getAvailability(),
                elementsT().productElementInformation(expectedProduct.getAvailability()).getText());

        var modelMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getModel(),
                elementsT().productElementInformation(expectedProduct.getModel()).getText());

        var weightMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessage, expectedProduct.getWeight(),
                elementsT().productWeightElement(expectedProduct.getWeight()).getText());

        Assertions.assertEquals(expectedProduct.getName(), elementsT().productNameElement(expectedProduct.getId(), expectedProduct.getName()).getText(), nameMessage);
        Assertions.assertEquals(expectedProduct.getUnitPrice(), elementsT().productElementInformation(expectedProduct.getUnitPrice()).getText(), messagePrice);
        Assertions.assertEquals(expectedProduct.getBrand(), elementsT().productElementInformation(expectedProduct.getBrand()).getText(), brandMessage);
        Assertions.assertEquals(expectedProduct.getAvailability(), elementsT().productElementInformation(expectedProduct.getAvailability()).getText(), availabilityMessage);
        Assertions.assertEquals(expectedProduct.getModel(), elementsT().productElementInformation(expectedProduct.getModel()).getText(), modelMessage);
        Assertions.assertEquals(expectedProduct.getWeight(), elementsT().productWeightElement(expectedProduct.getWeight()).getText(), weightMessage);

        elementsT().removeFromCompareList(expectedProduct.getId()).click();
    }
}
