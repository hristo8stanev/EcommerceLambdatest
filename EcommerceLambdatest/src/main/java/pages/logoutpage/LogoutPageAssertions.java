package pages.logoutpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ERROR_MESSAGE_CONFIRMATION_EMAIL;
import static constants.Constants.ERROR_MESSAGE_LOGOUT_BUTTON;


public class LogoutPageAssertions extends BaseAssertions<LogoutPageMap> {

    public void assertLogoutButtonDisplayed() {
        Assertions.assertTrue(elementsT().logoutButton().isDisplayed(), ERROR_MESSAGE_LOGOUT_BUTTON);
        elementsT().logoutButton();
    }

    public void assertAccountSuccessfullyLogout() {
        boolean isLogoutButtonDisplayed = elementsT().accountLogout().isDisplayed();
        var successfullyLogoutMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ERROR_MESSAGE_CONFIRMATION_EMAIL, isLogoutButtonDisplayed, true);
        Assertions.assertTrue(isLogoutButtonDisplayed, successfullyLogoutMessage);
    }
}