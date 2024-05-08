package pages.searchproductpricerange;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static constants.Constants.*;
import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE;

public class SearchProductPriceRange extends WebPage {

    public SearchProductPriceRange(WebDriver driver) {
        super(driver, SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE(MinPrice, MaxPrice));
    }

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE(MinPrice, MaxPrice);
    }
}
