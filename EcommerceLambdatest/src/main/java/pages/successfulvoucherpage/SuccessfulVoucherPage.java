package pages.successfulvoucherpage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_VOUCHER_PAGE;

public class SuccessfulVoucherPage extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return SUCCESSFUL_VOUCHER_PAGE;
    }
}