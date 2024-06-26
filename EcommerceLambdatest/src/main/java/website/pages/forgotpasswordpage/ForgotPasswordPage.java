package website.pages.forgotpasswordpage;

import core.basepage.WebPage;

import static urls.Urls.FORGOTTEN_PASSWORD_PAGE;

public class ForgotPasswordPage extends WebPage<ForgotPasswordPageMap, ForgotPasswordAssertions> {

    @Override
    protected String Url() {
        return FORGOTTEN_PASSWORD_PAGE;
    }

    public void proceedToForgottenPasswordSection() {
        elements().forgotPasswordButton().click();
    }

    public void sentEmail(String email) {
        elements().typeText(elements().emailAddress(), email);
        elements().continueButton().click();
    }
}