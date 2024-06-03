package website.pages.specialproductpage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static urls.Urls.SPECIAL_PRODUCT_PAGE;
import static urls.Urls.SUCCESSFUL_RETURN_PRODUCT_PAGE;

public class SpecialProductPage extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return SPECIAL_PRODUCT_PAGE;
    }
}
