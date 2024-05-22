package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static constants.Constants.EMAIL_ADDRESS;
import static constants.Constants.INVALID_EMAIL;

public class ForgotPasswordPageTests extends BaseTest {

    @Test
    public void forgotPassword_When_ValidEmailAddressProvided_And_ContinueButtonClicked() {
        webSite.loginPage.navigate();
        webSite.forgotPasswordPage.proceedToForgottenPasswordSection();

        webSite.forgotPasswordPage.assertUrlPage();

        webSite.forgotPasswordPage.sentEmail(EMAIL_ADDRESS);

        webSite.forgotPasswordPage.assertions().assertSuccessfullySentEmail();
        webSite.loginPage.assertUrlPage();
    }

    @Test
    public void forgotPassword_When_InvalidEmailAddressProvided_And_ContinueButtonIsClicked() {
        webSite.loginPage.navigate();
        webSite.forgotPasswordPage.proceedToForgottenPasswordSection();

        webSite.forgotPasswordPage.assertUrlPage();

        webSite.forgotPasswordPage.sentEmail(INVALID_EMAIL);

        webSite.forgotPasswordPage.assertions().assertWarningMessageInvalidEmail();
        webSite.forgotPasswordPage.assertUrlPage();
    }
}