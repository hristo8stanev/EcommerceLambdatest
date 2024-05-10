package pages.logoutpage;

import core.basepage.WebPage;

import static urls.Urls.LOGOUT_USER_PAGE;

public class LogoutPage extends WebPage {

    @Override
    protected String Url() {
        return LOGOUT_USER_PAGE;
    }
}
