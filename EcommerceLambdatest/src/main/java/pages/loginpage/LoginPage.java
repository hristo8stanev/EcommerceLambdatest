package pages.loginpage;

import core.basepage.WebPage;

import static urls.Urls.LOGIN_PAGE;

public class LoginPage extends WebPage<LoginPageMap,LoginPageAssertions>  {

    @Override
    protected String Url() {
        return LOGIN_PAGE;
    }

    public void loginUser(LoginInformation user){
        elements().emailAddress().sendKeys(user.emailAddress);
        elements().passwordInput().sendKeys(user.passwordField);
        elements().loginButton().click();
    }
}
