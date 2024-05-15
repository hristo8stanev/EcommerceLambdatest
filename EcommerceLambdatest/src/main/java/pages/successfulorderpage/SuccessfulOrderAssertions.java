package pages.successfulorderpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ErrorMessageLogoutButton;
import static constants.Constants.SuccessfullyPurchaseMessage;

public class SuccessfulOrderAssertions extends BaseAssertions<SuccessfulOrderPageMap> {

    public void assertSuccessfullyCheckoutOrder() {
        var successfullyCheckoutOrderMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ErrorMessageLogoutButton, elementsT().successfullyConfirmOrderText().getText(), SuccessfullyPurchaseMessage);
        Assertions.assertEquals(elementsT().successfullyConfirmOrderText().getText(), SuccessfullyPurchaseMessage, successfullyCheckoutOrderMessage);
    }
}
