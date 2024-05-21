package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Test;
import pages.productpage.ProductDetails;
import pages.registerpage.PersonalInformation;

import static constants.Constants.*;
import static factories.CustomerFactory.faker;

public class RegisterPageTests extends BaseTest {

    @Test
    public void registerUser_When_ValidCredentialsProvided_And_ContinueButtonClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccount();
        webSite.registerPage.createUser(registerUser);

        webSite.successfulRegisterPage.assertUrlPage();
        webSite.registerPage.assertions().assertLogoutButtonIsDisplayed();
    }

    @Test
    public void registerUser_When_EmptyFirstNameField_And_ContinueButtonIsClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccount("", emailAddress, password);
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageFirstName();
    }

    @Test
    public void registerUser_When_EmptyEmailAddressField_And_ContinueButtonClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccount(firstName, "", password);
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageMessageEmailAddress();
    }

    @Test
    public void registerUser_When_EmptyPasswordField_And_ContinueButtonClicked() {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccount("");
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessagePassword();
    }
}