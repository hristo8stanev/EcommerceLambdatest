package pages.wishlistpage;

import core.basepage.WebPage;

import static core.driver.Driver.*;
import static urls.Urls.WISHLIST_PAGE;

public class WishlistPage extends WebPage<WishlistPageMap, WishlistPageAssertions> {

    @Override
    protected String Url() {
        return WISHLIST_PAGE;
    }

    public void addProductToWishList() {
        elements().scrollToVisible(elements().wishListButton());
        elements().wishListButton().click();
        waitForAjax();
    }

    public void proceedToWishList() {
        elements().scrollToVisible(elements().searchField());
        waitForAjax();
        elements().wishListSection().click();
    }
}