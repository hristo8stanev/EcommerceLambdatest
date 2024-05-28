package website.pages.successfulorderpage;

import core.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_ORDER_PAGE;

public class SuccessfulOrderPage extends WebPage<SuccessfulOrderPageMap, SuccessfulOrderAssertions>{

    @Override
    protected String Url() {
        return SUCCESSFUL_ORDER_PAGE;
    }
}