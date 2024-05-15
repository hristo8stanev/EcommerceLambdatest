package pages.loginpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.logoutpage.LogoutPageMap;

import static constants.Constants.ErrorMessageConfirmationEmail;
import static constants.Constants.ExpectedMessageWrongCredentials;

public class LoginPageAssertions extends BaseAssertions<LoginPageMap> {

    public void assertErrorMessageWithWrongCredentials() {
        boolean isWarningMessageDisplayed = elementsT().warningMessage().isDisplayed();
        var wrongCredentialsMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ExpectedMessageWrongCredentials, isWarningMessageDisplayed, true);
        Assertions.assertTrue(isWarningMessageDisplayed, wrongCredentialsMessage);
    }
}
