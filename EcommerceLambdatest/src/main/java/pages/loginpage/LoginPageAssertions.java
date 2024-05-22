package pages.loginpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.EXPECTED_MESSAGE_WRONG_CREDENTIALS;

public class LoginPageAssertions extends BaseAssertions<LoginPageMap> {

    public void assertErrorMessageWithWrongCredentials() {
        boolean isWarningMessageDisplayed = elementsT().warningMessage().isDisplayed();
        var wrongCredentialsMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", EXPECTED_MESSAGE_WRONG_CREDENTIALS, isWarningMessageDisplayed, true);
        Assertions.assertTrue(isWarningMessageDisplayed, wrongCredentialsMessage);
    }
}