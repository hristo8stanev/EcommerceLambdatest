package pages.searchpage;

import core.basepage.WebPage;
import org.openqa.selenium.Keys;
import pages.productpage.ProductDetails;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;


public class SearchPage extends WebPage<SearchPageMap, SearchPageAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }

    public void searchProductByName(ProductDetails product) {
        elements().searchInput().sendKeys(product.getName());
        elements().searchButton().click();
    }

    public void typeRangePrices(String min, String max) {
        elements().minPriceField().clear();
        elements().minPriceField().sendKeys(min);
        elements().maxPriceField().clear();
        elements().maxPriceField().sendKeys(max);
        elements().maxPriceField().sendKeys(Keys.ENTER);
        elements().waitForAjax();
    }
}