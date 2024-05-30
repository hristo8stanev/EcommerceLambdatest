package website.pages.logoutpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ERROR_MESSAGE_CONFIRMATION_EMAIL;
import static constants.Constants.ERROR_MESSAGE_LOGOUT_BUTTON;


public class LogoutPageAssertions extends BaseAssertions<LogoutPageMap> {

    public void assertLogoutButtonDisplayed() {
        boolean isLogoutButtonDisplayed = elementsT().logoutButton().isDisplayed();
        var successfullyLogoutMessage = formatMessage(ERROR_MESSAGE_LOGOUT_BUTTON, String.valueOf(isLogoutButtonDisplayed), String.valueOf(true));
        Assertions.assertTrue(isLogoutButtonDisplayed, successfullyLogoutMessage);
    }

    public void assertAccountSuccessfullyLogout() {
        boolean isLogoutButtonDisplayed = elementsT().accountLogout().isDisplayed();
        var successfullyLogoutMessage = formatMessage(ERROR_MESSAGE_CONFIRMATION_EMAIL, String.valueOf(isLogoutButtonDisplayed), String.valueOf(true));
        Assertions.assertTrue(isLogoutButtonDisplayed, successfullyLogoutMessage);
    }
}