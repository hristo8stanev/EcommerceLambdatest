package pages.newaddressbookpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.ADDRESS_BOOK_PAGE;

public class NewAddressBookPage extends WebPage {

    public NewAddressBookPage(WebDriver driver) {
        super(driver, ADDRESS_BOOK_PAGE);
    }

    @Override
    protected String Url() {
        return ADDRESS_BOOK_PAGE;
    }
}
