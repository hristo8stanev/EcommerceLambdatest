package pages.successfulregisterpage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static urls.Urls.SUCCESSFUL_REGISTRATION_PAGE;

public class SuccessfulRegisterPage extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return SUCCESSFUL_REGISTRATION_PAGE;
    }
}
