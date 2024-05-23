package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;

public class RegisterPageTests extends BaseTest {

    @Test
    public void registerUser_when_validCredentialsProvided_and_continueButtonClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateGuestCheckout();
        webSite.registerPage.createUser(registerUser);

        webSite.successfulRegisterPage.assertUrlPage();
        webSite.registerPage.assertions().assertLogoutButtonIsDisplayed();
    }

    @Test
    public void registerUser_when_emptyFirstNameField_and_continueButtonIsClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccountWithEmptyFirstName();
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageFirstName();
    }

    @Test
    public void registerUser_when_emptyEmailAddressField_and_continueButtonClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccountWithEmptyEmail();
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageMessageEmailAddress();
    }

    @Test
    public void registerUser_when_emptyPasswordField_and_continueButtonClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccountWithEmptyPassword();
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessagePassword();
    }
}