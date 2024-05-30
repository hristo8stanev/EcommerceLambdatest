package website.pages.loginpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.EXPECTED_MESSAGE_WRONG_CREDENTIALS;

public class LoginPageAssertions extends BaseAssertions<LoginPageMap> {

    public void assertErrorMessageWithWrongCredentials() {
        boolean isWarningMessageDisplayed = elementsT().warningMessage().isDisplayed();
        var wrongCredentialsMessage = formatMessage(EXPECTED_MESSAGE_WRONG_CREDENTIALS, String.valueOf(isWarningMessageDisplayed), String.valueOf(true));
        Assertions.assertTrue(isWarningMessageDisplayed, wrongCredentialsMessage);
    }
}