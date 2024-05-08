package pages.homepage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.HOME_PAGE;

public class HomePage extends WebPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver, HOME_PAGE);
    }


    @Override
    protected String Url() {
        return HOME_PAGE;
    }
}
