package ecommercetests;

import core.BaseTest;
import core.driver.Driver;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

public class RegisterPageTests extends BaseTest {

    @Test
    public void RegisterUser_When_ValidCredentialsProvided_And_ContinueButtonClicked()
    {
        webSite.registerPage.navigate();

        var registerUser = CustomerFactory.GenerateUserDetails();
        webSite.registerPage.CreateUser(registerUser);

        webSite.successfulRegisterPage.assertUrlPage();
        webSite.registerPage.assertions().AssertLogoutButtonIsDisplayed();
    }
}