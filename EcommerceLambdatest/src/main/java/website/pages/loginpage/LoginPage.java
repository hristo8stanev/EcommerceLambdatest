package website.pages.loginpage;

import core.basepage.WebPage;
import website.pages.registerpage.PersonalInformation;

import static urls.Urls.LOGIN_PAGE;

public class LoginPage extends WebPage<LoginPageMap, LoginPageAssertions> {

    @Override
    protected String Url() {
        return LOGIN_PAGE;
    }

    public void loginUser(PersonalInformation user) {
        elements().typeText(elements().emailAddress(), user.email);
        elements().typeText(elements().passwordInput(), user.password);
        elements().loginButton().click();
    }
}