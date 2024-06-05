package website.pages.homepage;

import core.basepage.WebPage;
import enums.ShopCategory;
import org.openqa.selenium.WebElement;


import static core.driver.Driver.waitForAjax;
import static urls.Urls.HOME_PAGE;

public class HomePage extends WebPage<HomePageMap, HomePageAssertions> {

    @Override
    protected String Url() {
        return HOME_PAGE;
    }

    public void proceedToSpecialOfferPage() {
        clickAndScroll(elements().specialOfferTitleField());
    }

    public void proceedToBlogArticlePage() {
        clickAndScroll(elements().blogArticleTitleField());
    }

    public void proceedToMyAccount() {
        clickAndScroll(elements().myAccountSection());
    }

    public void proceedToShopByCategory(ShopCategory category) {
        clickAndScroll(elements().shopByCategory());
        elements().category(category).click();
    }
}