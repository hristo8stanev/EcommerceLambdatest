package pages.loginpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.LOGIN_PAGE;

public class LoginPage extends WebPage  {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, LOGIN_PAGE);
    }


    @Override
    protected String Url() {
        return LOGIN_PAGE;
    }
}
