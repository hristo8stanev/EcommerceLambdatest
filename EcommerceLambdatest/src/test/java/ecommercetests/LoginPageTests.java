package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;

public class LoginPageTests extends BaseTest {

    @Test
    public void loginIntoSystem_When_ValidEmailAddressAndPasswordProvided_And_LoginButtonClicked()
    {
        var loginUser = CustomerFactory.loginUser(EmailAddress, Password);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.myAccountPage.assertUrlPage();
        //webSite.loginPage.AssertLogoutButtonDisplayed();
    }
}
