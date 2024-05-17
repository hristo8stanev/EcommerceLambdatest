package pages.successfulreturnproductpage;

import core.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_RETURN_PRODUCT_PAGE;

public class SuccessfulReturnProductPage extends WebPage<SuccessfulReturnProductPageMap,SuccessfulReturnProductPageAssertions> {

    @Override
    protected String Url() {
        return SUCCESSFUL_RETURN_PRODUCT_PAGE;
    }
}