package pages.logoutpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.LOGOUT_USER_PAGE;

public class LogoutPage extends WebPage {
    public LogoutPage(WebDriver webDriver) {
        super(webDriver, LOGOUT_USER_PAGE);
    }

    @Override
    protected String Url() {
        return LOGOUT_USER_PAGE;
    }
}
