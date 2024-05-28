package website.pages.successfulreturnproductpage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_RETURN_PRODUCT_PAGE;

public class SuccessfulReturnProductPage extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return SUCCESSFUL_RETURN_PRODUCT_PAGE;
    }
}