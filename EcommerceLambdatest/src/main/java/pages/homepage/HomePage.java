package pages.homepage;

import core.basepage.WebPage;

import static urls.Urls.HOME_PAGE;

public class HomePage extends WebPage<HomePageMap, HomePageAssertions> {

    @Override
    protected String Url() {
        return HOME_PAGE;
    }
}