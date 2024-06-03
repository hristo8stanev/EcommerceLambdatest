package website.pages.homepage;

import core.basepage.WebPage;
import enums.ShopCategory;


import static core.driver.Driver.waitForAjax;
import static urls.Urls.HOME_PAGE;

public class HomePage extends WebPage<HomePageMap, HomePageAssertions> {

    @Override
    protected String Url() {
        return HOME_PAGE;
    }

    public void proceedToSpecialOfferPage() {
        elements().scrollToVisible(elements().specialOfferTitleField());
        elements().specialOfferTitleField().click();
        waitForAjax();
    }

    public void proceedToBlogArticlePage() {
        elements().scrollToVisible(elements().blogArticleTitleField());
        elements().blogArticleTitleField().click();
        waitForAjax();
    }

    public void proceedToMyAccount() {
        elements().scrollToVisible(elements().myAccountSection());
        elements().myAccountSection().click();
        waitForAjax();
    }

    public void proceedToShopByCategory(ShopCategory category) {
        elements().scrollToVisible(elements().shopByCategory());
        elements().shopByCategory().click();
        elements().category(category).click();
        waitForAjax();
    }
}