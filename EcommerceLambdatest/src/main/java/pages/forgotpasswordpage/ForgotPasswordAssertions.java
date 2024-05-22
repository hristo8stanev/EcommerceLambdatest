package pages.forgotpasswordpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class ForgotPasswordAssertions extends BaseAssertions<ForgotPasswordPageMap> {

    public void assertSuccessfullySentEmail() {
        boolean isConfirmationMessageDisplayed = elementsT().confirmationMessage().isDisplayed();
        String sentEmailMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b",
                ERROR_MESSAGE_CONFIRMATION_EMAIL, isConfirmationMessageDisplayed, true);
        Assertions.assertTrue(isConfirmationMessageDisplayed, sentEmailMessage);
    }

    public void assertWarningMessageInvalidEmail() {
        boolean isWarningMessageDisplayed = elementsT().warningMessage().isDisplayed();
        String invalidEmailMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b",
                ERROR_MESSAGE_CONFIRMATION_EMAIL, isWarningMessageDisplayed, true);
        Assertions.assertTrue(isWarningMessageDisplayed, invalidEmailMessage);
    }
}