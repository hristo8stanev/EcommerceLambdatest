package website.pages.newaddressbookpage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static urls.Urls.ADDRESS_BOOK_PAGE;

public class NewAddressBookPage extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return ADDRESS_BOOK_PAGE;
    }
}
