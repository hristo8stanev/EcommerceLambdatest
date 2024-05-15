package pages.wishlistpage;

import core.basepage.WebPage;

import static urls.Urls.WISHLIST_PAGE;

public class WishlistPage extends WebPage<WishlistPageMap,WishlistPageAssertions> {

    @Override
    protected String Url() {
        return WISHLIST_PAGE;
    }

    public void addProductToWishList(){
        elements().scrollToVisible(elements().wishListButton());
        elements().wishListButton().click();
        elements().waitForAjax();
    }

    public void proceedToWishList(){
        elements().scrollToVisible(elements().searchField());
        elements().waitForAjax();
        elements().wishListSection().click();
    }
}
