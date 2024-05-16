package pages.loginpage;

import core.basepage.WebPage;
import pages.registerpage.PersonalInformation;

import static urls.Urls.LOGIN_PAGE;

public class LoginPage extends WebPage<LoginPageMap,LoginPageAssertions>  {

    @Override
    protected String Url() {
        return LOGIN_PAGE;
    }

    public void loginUser(PersonalInformation user){
        elements().emailAddress().sendKeys(user.email);
        elements().passwordInput().sendKeys(user.password);
        elements().loginButton().click();
    }
}
