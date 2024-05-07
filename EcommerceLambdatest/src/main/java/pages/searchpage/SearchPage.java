package pages.searchpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;


public class SearchPage extends WebPage {
    public SearchPage(WebDriver webDriver) {
        super(webDriver, SEARCH_SHOP_PRODUCTS_PAGE);
    }

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }
}
