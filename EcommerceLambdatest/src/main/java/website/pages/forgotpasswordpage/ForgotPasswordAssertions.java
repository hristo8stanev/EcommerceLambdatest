package website.pages.forgotpasswordpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class ForgotPasswordAssertions extends BaseAssertions<ForgotPasswordPageMap> {

    public void assertSuccessfullySentEmail() {
        boolean isConfirmationMessageDisplayed = elementsT().confirmationMessage().isDisplayed();
        String sentEmailMessage = formatMessage(ERROR_MESSAGE_CONFIRMATION_EMAIL, String.valueOf(isConfirmationMessageDisplayed), String.valueOf(true));
        Assertions.assertTrue(isConfirmationMessageDisplayed, sentEmailMessage);
    }

    public void assertWarningMessageInvalidEmail() {
        boolean isWarningMessageDisplayed = elementsT().warningMessage().isDisplayed();
        String invalidEmailMessage = formatMessage(ERROR_MESSAGE_CONFIRMATION_EMAIL, String.valueOf(isWarningMessageDisplayed), String.valueOf(true));
        Assertions.assertTrue(isWarningMessageDisplayed, invalidEmailMessage);
    }
}