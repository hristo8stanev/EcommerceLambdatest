package website.pages.productpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class ProductPageAssertions extends BaseAssertions<ProductPageMap> {

    public void assertSizeProductIsCorrect(ProductDetails expectedProduct) {
        var expectedResult = elementsT().productSize(expectedProduct.getId()).getText();
        var actualResult = expectedProduct.getSize();
        var sizeMessage = formatMessage(ERROR_MESSAGE_PRODUCT_INFORMATION, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, sizeMessage);
    }

    public void assertSubmittedReviewForApproval() {
        var expectedResult = elementsT().reviewMessage().getText();
        var actualResult = REVIEW_MESSAGE_FOR_APPROVAL;
        var reviewApprovalMessage = formatMessage(ERROR_MESSAGE_REVIEW, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, reviewApprovalMessage);
    }
}