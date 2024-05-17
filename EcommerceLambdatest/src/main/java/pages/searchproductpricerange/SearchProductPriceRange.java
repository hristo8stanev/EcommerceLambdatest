package pages.searchproductpricerange;

import core.basepage.WebPage;

import static constants.Constants.MaxPrice;
import static constants.Constants.MinPrice;
import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE;

public class SearchProductPriceRange extends WebPage<SearchProductPriceRangeMap, SearchProductPriceRangeAssertions> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE(MinPrice, MaxPrice);
    }
}
