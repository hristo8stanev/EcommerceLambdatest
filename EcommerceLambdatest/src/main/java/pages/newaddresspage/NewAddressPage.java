package pages.newaddresspage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.NEW_ADDRESS_PAGE;

public class NewAddressPage extends WebPage {

    public NewAddressPage(WebDriver driver) {
        super(driver, NEW_ADDRESS_PAGE);
    }

    @Override
    protected String Url() {
        return NEW_ADDRESS_PAGE;
    }
}
