package website.pages.forgotpasswordpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class ForgotPasswordAssertions extends BaseAssertions<ForgotPasswordPageMap> {

    public void assertSuccessfullySentEmail() {
        boolean expectedResult = elementsT().confirmationMessage().isDisplayed();
        var actualResult = String.valueOf(true);
        var sentEmailMessage = formatMessage(ERROR_MESSAGE_CONFIRMATION_EMAIL, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(expectedResult, sentEmailMessage);
    }

    public void assertWarningMessageInvalidEmail() {
        boolean expectedResult = elementsT().warningMessage().isDisplayed();
        var actualResult = String.valueOf(true);
        var invalidEmailMessage = formatMessage(ERROR_MESSAGE_CONFIRMATION_EMAIL, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(expectedResult, invalidEmailMessage);
    }
}