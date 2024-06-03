package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;

public class LoginPageTests extends BaseTest {

    PersonalInformation loginUser;
    PersonalInformation invalidEmail;
    PersonalInformation invalidPassword;
    PersonalInformation emptyCredentials;
    PersonalInformation emptyEmail;
    PersonalInformation emptyPassword;

    @BeforeEach
    public void setup() {
        loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        invalidEmail = CustomerFactory.loginUser(INVALID_EMAIL, PASSWORD);
        invalidPassword = CustomerFactory.loginUser(EMAIL_ADDRESS, INVALID_PASSWORD);
        emptyCredentials = CustomerFactory.loginUser("", "");
        emptyEmail = CustomerFactory.loginUser(" ", PASSWORD);
        emptyPassword = CustomerFactory.loginUser(EMAIL_ADDRESS, " ");
    }

    @Test
    public void loginIntoSystem_when_validEmailAddressAndPasswordProvided_and_userSuccessfulAuthorized() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.myAccountPage.assertUrlPage();
        webSite.logoutPage.assertions().assertLogoutButtonDisplayed();

        webSite.logoutPage.logoutUser();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithInvalidEmailAddress_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(invalidEmail);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithInvalidPassword_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(invalidPassword);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithEmptyCredentials_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(emptyCredentials);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithEmptyEmailAddressField_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(emptyEmail);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithEmptyPasswordField_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(emptyPassword);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageWithWrongCredentials();
    }
}