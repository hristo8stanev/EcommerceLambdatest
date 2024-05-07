package pages.myaccountpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.ACCOUNT_PAGE;

public class MyAccountPage extends WebPage {
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver, ACCOUNT_PAGE);
    }

    @Override
    protected String Url() {
        return ACCOUNT_PAGE;
    }
}
