package pages.successfulorderpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_ORDER_PAGE;

public class SuccessfulOrderPage extends WebPage {

    public SuccessfulOrderPage(WebDriver driver) {
        super(driver, SUCCESSFUL_ORDER_PAGE);
    }

    @Override
    protected String Url() {
        return SUCCESSFUL_ORDER_PAGE;
    }
}
