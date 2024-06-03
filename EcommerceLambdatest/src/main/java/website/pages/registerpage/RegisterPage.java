package website.pages.registerpage;

import core.basepage.WebPage;
import core.driver.Driver;

import static core.driver.Driver.waitForAjax;
import static urls.Urls.REGISTER_PAGE;

public class RegisterPage extends WebPage<RegisterPageMap, RegisterPageAssertions> {

    @Override
    protected String Url() {
        return REGISTER_PAGE;
    }

    public void createUser(PersonalInformation user) {
        elements().typeText(elements().firstNameInput(), user.firstName);
        elements().typeText(elements().lastNameInput(), user.lastName);
        elements().typeText(elements().emailAddressInput(), user.email);
        elements().typeText(elements().telephoneInput(), user.telephone);
        elements().typeText(elements().passwordInput(), user.password);
        elements().typeText(elements().confirmPasswordInput(), user.password);
    }

    public void proceedToCreatedAccount(){
        agreePrivacyTerms();
        continueButton();
    }

    public void agreePrivacyTerms() {
        waitForAjax();
        elements().scrollToVisible(elements().agreePrivacy());
        elements().agreePrivacy().click();
    }

    public void continueButton() {
        waitForAjax();
        elements().scrollToVisible(elements().continueButton());
        elements().continueButton().click();
    }
}