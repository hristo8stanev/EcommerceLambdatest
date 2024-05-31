package website.pages.returnproductpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ERROR_MESSAGE_RETURNS;
import static constants.Constants.PRODUCT_RETURNS_MESSAGE;

public class ReturnProductPageAssertions extends BaseAssertions<ReturnProductPageMap> {

    public void assertProductReturnsMessage(String expectedMessage) {
        var expectedResult = elementsT().successfullyProductReturn(expectedMessage).getText();
        var actualResult = PRODUCT_RETURNS_MESSAGE;
        var returnProductMessage = formatMessage(ERROR_MESSAGE_RETURNS, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, returnProductMessage);
    }
}