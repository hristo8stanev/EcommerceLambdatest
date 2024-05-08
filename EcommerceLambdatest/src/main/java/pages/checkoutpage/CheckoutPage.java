package pages.checkoutpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.CHECKOUT_PAGE;

public class CheckoutPage extends WebPage {
    public CheckoutPage(WebDriver webDriver) {
        super(webDriver, CHECKOUT_PAGE);
    }


    @Override
    protected String Url() {
        return CHECKOUT_PAGE;
    }
}
