package website.pages.successfulorderpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ERROR_MESSAGE_LOGOUT_BUTTON;
import static constants.Constants.SUCCESSFULLY_PURCHASE_MESSAGE;

public class SuccessfulOrderAssertions extends BaseAssertions<SuccessfulOrderPageMap> {

    public void assertSuccessfullyCheckoutOrder() {
        var successfullyCheckoutOrderMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ERROR_MESSAGE_LOGOUT_BUTTON, elementsT().successfullyConfirmOrderText().getText(), SUCCESSFULLY_PURCHASE_MESSAGE);
        Assertions.assertEquals(elementsT().successfullyConfirmOrderText().getText(), SUCCESSFULLY_PURCHASE_MESSAGE, successfullyCheckoutOrderMessage);
    }
}