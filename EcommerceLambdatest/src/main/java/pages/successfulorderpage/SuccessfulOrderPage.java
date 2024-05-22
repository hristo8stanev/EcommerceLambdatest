package pages.successfulorderpage;

import core.basepage.WebPage;
import pages.searchpage.SearchPageAssertions;
import pages.searchpage.SearchPageMap;

import static urls.Urls.SUCCESSFUL_ORDER_PAGE;

public class SuccessfulOrderPage extends WebPage<SuccessfulOrderPageMap, SuccessfulOrderAssertions>{

    @Override
    protected String Url() {
        return SUCCESSFUL_ORDER_PAGE;
    }
}