package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.EmailAddress;
import static constants.Constants.InvalidEmail;

public class ForgotPasswordPageTests extends BaseTest {

    @Test
    public void ForgotPassword_When_ValidEmailAddressProvided_And_ContinueButtonClicked() {
        webSite.loginPage.navigate();
        webSite.forgotPasswordPage.proceedToForgottenPasswordSection();

        webSite.forgotPasswordPage.assertUrlPage();

        webSite.forgotPasswordPage.sentEmail(EmailAddress);

        webSite.forgotPasswordPage.assertions().assertSuccessfullySentEmail();
        webSite.loginPage.assertUrlPage();
    }

    @Test
    public void ForgotPassword_When_InvalidEmailAddressProvided_And_ContinueButtonIsClicked() {
        webSite.loginPage.navigate();
        webSite.forgotPasswordPage.proceedToForgottenPasswordSection();

        webSite.forgotPasswordPage.assertUrlPage();

        webSite.forgotPasswordPage.sentEmail(InvalidEmail);

        webSite.forgotPasswordPage.assertions().assertWarningMessageInvalidEmail();
        webSite.forgotPasswordPage.assertUrlPage();
    }
}