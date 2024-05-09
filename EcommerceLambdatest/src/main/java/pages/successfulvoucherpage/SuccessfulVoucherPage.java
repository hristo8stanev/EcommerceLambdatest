package pages.successfulvoucherpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_VOUCHER_PAGE;

public class SuccessfulVoucherPage extends WebPage {

    public SuccessfulVoucherPage(WebDriver driver) {
        super(driver, SUCCESSFUL_VOUCHER_PAGE);
    }

    @Override
    protected String Url() {
        return SUCCESSFUL_VOUCHER_PAGE;
    }
}
