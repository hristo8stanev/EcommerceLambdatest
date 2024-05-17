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
        elements().firstNameInput().sendKeys(user.firstName);
        elements().lastNameInput().sendKeys(user.lastName);
        elements().emailAddressInput().sendKeys(user.email);
        elements().telephoneInput().sendKeys(user.telephone);
        elements().passwordInput().sendKeys(user.password);
        elements().confirmPasswordInput().sendKeys(user.password);
        elements().agreePrivacy().click();
        elements().continueButton().click();
    }
}