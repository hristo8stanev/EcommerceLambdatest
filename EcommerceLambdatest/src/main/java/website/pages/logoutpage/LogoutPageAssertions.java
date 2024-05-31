package website.pages.logoutpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ERROR_MESSAGE_CONFIRMATION_EMAIL;
import static constants.Constants.ERROR_MESSAGE_LOGOUT_BUTTON;


public class LogoutPageAssertions extends BaseAssertions<LogoutPageMap> {

    public void assertLogoutButtonDisplayed() {
        boolean expectedResult = elementsT().logoutButton().isDisplayed();
        var actualResult = String.valueOf(true);
        var successfullyLogoutMessage = formatMessage(ERROR_MESSAGE_LOGOUT_BUTTON, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(expectedResult, successfullyLogoutMessage);
    }

    public void assertAccountSuccessfullyLogout() {
        boolean expectedResult = elementsT().accountLogout().isDisplayed();
        var actualResult = String.valueOf(true);
        var successfullyLogoutMessage = formatMessage(ERROR_MESSAGE_CONFIRMATION_EMAIL, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(expectedResult, successfullyLogoutMessage);
    }
}