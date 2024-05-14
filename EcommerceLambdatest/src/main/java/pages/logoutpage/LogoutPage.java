package pages.logoutpage;

import core.basepage.WebPage;
import pages.myaccountpage.MyAccountPageAssertions;
import pages.myaccountpage.MyAccountPageMap;

import static urls.Urls.LOGOUT_USER_PAGE;

public class LogoutPage extends WebPage <LogoutPageMap, LogoutPageAssertions> {

    @Override
    protected String Url() {
        return LOGOUT_USER_PAGE;
    }

    public void logoutUser()
    {
        elements().myAccountNavigationBarElement();
        elements().logoutButton().click();
    }
}
