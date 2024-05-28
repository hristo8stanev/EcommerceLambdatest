package website.pages.searchproductpricerange;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static constants.Constants.MAX_PRICE;
import static constants.Constants.MIN_PRICE;
import static urls.Urls.SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE;

public class SearchProductPriceRange extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return SEARCH_SHOP_PRODUCTS_PAGE_PRICE_RANGE(MIN_PRICE, MAX_PRICE);
    }
}