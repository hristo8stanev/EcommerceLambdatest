package pages.registerpage;

import core.basepage.WebPage;

import static urls.Urls.REGISTER_PAGE;

public class RegisterPage extends WebPage<RegisterPageMap, RegisterPageAssertions> {

    @Override
    protected String Url() {
        return REGISTER_PAGE;
    }

    public void createUser(PersonalInformation user)
    {
        elements().typeText(elements().firstNameInput(), user.firstName);
        elements().typeText(elements().lastNameInput(), user.lastName);
        elements().typeText(elements().emailAddressInput(), user.email);
        elements().typeText(elements().telephoneInput(), user.telephone);
        elements().typeText(elements().passwordInput(), user.password);
        elements().typeText(elements().confirmPasswordInput(), user.password);
        elements().agreePrivacy().click();
        elements().continueButton().click();
    }
}