package pages.cartpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.CART_PAGE;

public class CartPage extends WebPage {
    public CartPage(WebDriver webDriver) {
        super(webDriver, CART_PAGE);
    }

    @Override
    protected String Url() {
        return CART_PAGE;
    }
}