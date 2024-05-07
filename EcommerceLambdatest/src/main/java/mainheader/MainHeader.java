package mainheader;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.HOME_PAGE;

public class MainHeader extends WebPage {
    public MainHeader(WebDriver webDriver) {
        super(webDriver, HOME_PAGE);
    }

    @Override
    protected String Url() {
        return HOME_PAGE;
    }
}
