package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

public class RegisterPageTests extends BaseTest {

    @Test
    public void registerUser_When_ValidCredentialsProvided_And_ContinueButtonClicked()
    {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateRegisterAccount();
        webSite.registerPage.createUser(registerUser);

        webSite.successfulRegisterPage.assertUrlPage();
        webSite.registerPage.assertions().assertLogoutButtonIsDisplayed();
    }

    @Test
    public void RegisterUser_When_EmptyFirstNameField_And_ContinueButtonIsClicked()
    {
        webSite.registerPage.navigate();

        //To Do
        var registerUser = CustomerFactory.GenerateRegisterAccount(firstName: string.Empty);
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageForErrorMessageFirstName();
    }

    @Test
    public void RegisterUser_When_EmptyEmailAddressField_And_ContinueButtonClicked()
    {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateUserDetails(email: string.Empty);
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageForErrorMessageEmailAddress();
    }

    @Test
    public void RegisterUser_When_EmptyPasswordField_And_ContinueButtonClicked()
    {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateUserDetails(password: string.Empty);
        webSite.registerPage.createUser(registerUser);

        webSite.registerPage.assertUrlPage();
        webSite.registerPage.assertions().assertErrorMessageForErrorMessagePassword();
    }
}