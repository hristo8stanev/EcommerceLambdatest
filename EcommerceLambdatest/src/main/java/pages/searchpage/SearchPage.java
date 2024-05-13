package pages.searchpage;

import core.basepage.WebPage;

import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE;


public class SearchPage extends WebPage<SearchPageMap, SearchPageAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE;
    }

    public void method() {
        elements().searchButton().sendKeys();
        elements().maxPriceField().sendKeys("100");
        elements().searchInput().click();
    }
}