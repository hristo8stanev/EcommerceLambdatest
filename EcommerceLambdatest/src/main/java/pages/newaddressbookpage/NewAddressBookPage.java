package pages.newaddressbookpage;

import core.basepage.WebPage;

import static urls.Urls.ADDRESS_BOOK_PAGE;

public class NewAddressBookPage extends WebPage<NewAddressBookPageMap,NewAddressBookPageAssertions> {

    @Override
    protected String Url() {
        return ADDRESS_BOOK_PAGE;
    }
}
