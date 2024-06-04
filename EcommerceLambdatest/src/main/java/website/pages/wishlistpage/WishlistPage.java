package website.pages.wishlistpage;

import core.basepage.WebPage;
import website.pages.productpage.ProductDetails;

import static core.driver.Driver.*;
import static urls.Urls.WISHLIST_PAGE;

public class WishlistPage extends WebPage<WishlistPageMap, WishlistPageAssertions> {

    @Override
    protected String Url() {
        return WISHLIST_PAGE;
    }

    public void removeProductsById(ProductDetails... productIds) {
        for (ProductDetails productId : productIds) {
            elements().scrollToVisible(elements().removeFromWishList(productId));
            elements().removeFromWishList(productId).click();
            waitForAjax();
        }
    }

    public void proceedToWishList() {
        elements().scrollToVisible(elements().searchField());
        waitForAjax();
        elements().wishListSection().click();
    }

    public void removeProduct(ProductDetails productDetails) {
        elements().scrollToVisible(elements().removeButton(productDetails));
        elements().removeButton(productDetails).click();
    }
}