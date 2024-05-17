package pages.returnproductpage;

import core.basepage.WebPage;

import static urls.Urls.RETURN_PRODUCT_PAGE;

public class ReturnProductPage extends WebPage<ReturnProductPageMap, ReturnProductPageAssertions> {

    @Override
    protected String Url() {
        return RETURN_PRODUCT_PAGE;
    }
}
