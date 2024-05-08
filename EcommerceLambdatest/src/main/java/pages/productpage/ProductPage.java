package pages.productpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;

public class ProductPage extends WebPage
{
    public ProductPage(WebDriver driver) {
        super(driver, SEARCH_SHOP_PRODUCTS_PAGE);
    }

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }
}
