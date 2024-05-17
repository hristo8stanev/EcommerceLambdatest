package pages.successfulvoucherpage;

import core.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_VOUCHER_PAGE;

public class SuccessfulVoucherPage extends WebPage<SuccessfulVoucherPageMap,SuccessfulVoucherPageAssertions> {

    @Override
    protected String Url() {
        return SUCCESSFUL_VOUCHER_PAGE;
    }
}