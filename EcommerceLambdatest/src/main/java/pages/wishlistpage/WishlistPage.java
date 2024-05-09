package pages.wishlistpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.WISHLIST_PAGE;

public class WishlistPage extends WebPage {

    public WishlistPage(WebDriver driver) {
        super(driver, WISHLIST_PAGE);
    }

    @Override
    protected String Url() {
        return WISHLIST_PAGE;
    }
}
