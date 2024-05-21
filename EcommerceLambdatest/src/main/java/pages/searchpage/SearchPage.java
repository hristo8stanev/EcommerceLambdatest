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
        elements().typeText(elements().searchInput(), product.getName());
        elements().searchButton().click();
    }

    public void proceedToProduct(ProductDetails product) {
        elements().waitForAjax();
        elements().scrollToVisible(elements().getProduct(product.getId()));
        elements().getProduct(product.getId()).click();
    }

    public void typeRangePrices(String min, String max) {
        elements().typeText(elements().minPriceField(), min);
        elements().typeText(elements().maxPriceField(), max);
        elements().maxPriceField().sendKeys(Keys.ENTER);
        elements().waitForAjax();
    }
}