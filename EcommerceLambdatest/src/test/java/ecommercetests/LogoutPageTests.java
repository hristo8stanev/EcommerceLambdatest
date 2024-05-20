package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.EMAIL_ADDRESS;
import static constants.Constants.PASSWORD;

public class LogoutPageTests extends BaseTest {

    @Test
    public void LogoutFromTheSystem_When_LogoutButtonClicked()
    {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.myAccountPage.assertUrlPage();

        webSite.logoutPage.logoutUser();
        webSite.logoutPage.assertUrlPage();
        webSite.logoutPage.assertions().assertAccountSuccessfullyLogout();
    }
}
