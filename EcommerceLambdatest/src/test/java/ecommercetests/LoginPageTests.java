package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;

public class LoginPageTests extends BaseTest {
    @Test
    public void loginIntoSystem_When_ValidEmailAddressAndPasswordProvided_And_LoginButtonClicked() {
        var loginUser = CustomerFactory.loginUser(EmailAddress,Password);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.myAccountPage.assertUrlPage();
        webSite.logoutPage.assertions().assertLogoutButtonDisplayed();
    }

    @Test
    public void LoginIntoSystem_When_InvalidEmailAddress_And_LoginButtonClicked() {
        var loginUser = CustomerFactory.loginUser(InvalidEmail, Password);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }

    @Test
    public void LoginIntoSystem_When_EmptyCredentials_And_LoginButtonClicked() {
        var loginUser = CustomerFactory.loginUser("", "");

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }
}
