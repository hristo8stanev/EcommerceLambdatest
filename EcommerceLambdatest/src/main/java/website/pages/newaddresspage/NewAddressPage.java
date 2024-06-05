package website.pages.newaddresspage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static urls.Urls.NEW_ADDRESS_PAGE;

public class NewAddressPage extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return NEW_ADDRESS_PAGE;
    }
}