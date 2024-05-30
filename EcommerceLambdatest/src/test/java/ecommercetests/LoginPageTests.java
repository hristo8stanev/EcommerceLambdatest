package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;

public class LoginPageTests extends BaseTest {
    @Test
    public void loginIntoSystem_When_ValidEmailAddressAndPasswordProvided_And_LoginButtonClicked() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.myAccountPage.assertUrlPage();
        webSite.logoutPage.assertions().assertLogoutButtonDisplayed();

        webSite.logoutPage.logoutUser();
    }

    @Test
    public void loginIntoSystem_When_InvalidEmailAddress_And_LoginButtonClicked() {
        var loginUser = CustomerFactory.loginUser(INVALID_EMAIL, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }

    @Test
    public void loginIntoSystem_When_InvalidPassword_And_LoginButtonClicked() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, INVALID_PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();

    }

    @Test
    public void loginIntoSystem_When_EmptyCredentials_And_LoginButtonClicked() {
        var loginUser = CustomerFactory.loginUser("", "");

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }
}