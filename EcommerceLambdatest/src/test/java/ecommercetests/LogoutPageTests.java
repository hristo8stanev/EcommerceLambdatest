package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.EmailAddress;
import static constants.Constants.Password;

public class LogoutPageTests extends BaseTest {

    @Test
    public void LogoutFromTheSystem_When_LogoutButtonClicked()
    {
        var loginUser = CustomerFactory.loginUser(EmailAddress, Password);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.myAccountPage.assertUrlPage();

        webSite.logoutPage.logoutUser();
        webSite.logoutPage.assertUrlPage();
        webSite.logoutPage.assertions().assertAccountSuccessfullyLogout();
    }
}
