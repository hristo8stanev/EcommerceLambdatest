package website.pages.returnproductpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ERROR_MESSAGE_RETURNS;
import static constants.Constants.PRODUCT_RETURNS_MESSAGE;

public class ReturnProductPageAssertions extends BaseAssertions<ReturnProductPageMap> {

    public void assertProductReturnsMessage(String expectedMessage) {
        var returnProductMessage = formatMessage(ERROR_MESSAGE_RETURNS, PRODUCT_RETURNS_MESSAGE, elementsT().successfullyProductReturn(expectedMessage).getText());
        Assertions.assertEquals(elementsT().successfullyProductReturn(expectedMessage).getText(), PRODUCT_RETURNS_MESSAGE, returnProductMessage);
    }
}