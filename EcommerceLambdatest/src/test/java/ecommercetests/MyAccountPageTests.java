package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;


public class MyAccountPageTests extends BaseTest {

    @Test
    public void editMyProfile_When_FirstNameLastNameEmailAddressAndTelephoneEdited_And_ContinueButtonClicked()
    {

        //To Do
        var loginUser = CustomerFactory.loginUser(EmailAddress, Password);
        var myAccountInformation = CustomerFactory.GenerateRegisterAccount();

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.changeMyAccountInformation(myAccountInformation);

        webSite.myAccountPage.assertions().assertAccountInformationIsSuccessfullyUpdated();
        webSite.myAccountPage.assertUrlPage();
    }
}
