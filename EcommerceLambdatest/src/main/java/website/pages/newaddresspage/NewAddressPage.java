package website.pages.newaddresspage;

import core.basepage.WebPage;

import static urls.Urls.NEW_ADDRESS_PAGE;

public class NewAddressPage extends WebPage<NewAddressPageMap, NewAddressPageAssertions> {

    @Override
    protected String Url() {
        return NEW_ADDRESS_PAGE;
    }
}
