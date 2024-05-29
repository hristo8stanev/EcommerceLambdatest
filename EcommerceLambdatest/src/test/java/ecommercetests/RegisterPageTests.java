package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

public class RegisterPageTests extends BaseTest {

   PersonalInformation guestUser;
   PersonalInformation emptyFirstNameUser;
   PersonalInformation emptyEmailUser;
   PersonalInformation emptyPasswordUser;

    @BeforeEach
    public void setup() {
        webSite.registerPage.navigate();
        guestUser = CustomerFactory.generateGuestCheckout();
        emptyFirstNameUser = CustomerFactory.generateRegisterAccountWithEmptyFirstName();
        emptyEmailUser = CustomerFactory.generateRegisterAccountWithEmptyEmail();
        emptyPasswordUser = CustomerFactory.generateRegisterAccountWithEmptyPassword();
    }

    @Test
    public void registerUser_when_validCredentialsProvided_and_continueButtonClicked() {
        webSite.registerPage.createUser(guestUser);

        webSite.successfulRegisterPage.assertUrlPage();
        webSite.registerPage.assertions().assertLogoutButtonIsDisplayed();
    }

    @Test
    public void registerUser_when_emptyFirstNameField_and_continueButtonIsClicked() {
        webSite.registerPage.createUser(emptyFirstNameUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageFirstName();
    }

    @Test
    public void registerUser_when_emptyEmailAddressField_and_continueButtonClicked() {
        webSite.registerPage.createUser(emptyEmailUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageMessageEmailAddress();
    }

    @Test
    public void registerUser_when_emptyPasswordField_and_continueButtonClicked() {
        webSite.registerPage.createUser(emptyPasswordUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessagePassword();
    }
}