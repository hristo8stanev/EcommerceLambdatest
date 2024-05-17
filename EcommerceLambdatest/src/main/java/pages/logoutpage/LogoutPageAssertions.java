package pages.logoutpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.logoutpage.LogoutPage;

import static constants.Constants.ErrorMessageConfirmationEmail;
import static constants.Constants.ErrorMessageLogoutButton;


public class LogoutPageAssertions extends BaseAssertions<LogoutPageMap> {

    public void assertLogoutButtonDisplayed() {
        //var logoutMessage = $"{ErrorMessageLogoutButton} \n Actual Result:{!LogoutButton.Displayed} \n Expected Result:{LogoutButton.Displayed}";
        Assertions.assertTrue(elementsT().logoutButton().isDisplayed(), ErrorMessageLogoutButton);
        elementsT().logoutButton();
    }

    public void assertAccountSuccessfullyLogout() {
        boolean isLogoutButtonDisplayed = elementsT().accountLogout().isDisplayed();
        var successfullyLogoutMessage = String.format("%s \n Actual Result: %b \n Expected Result: %b", ErrorMessageConfirmationEmail, isLogoutButtonDisplayed, true);
        Assertions.assertTrue(isLogoutButtonDisplayed, successfullyLogoutMessage);
    }
}
