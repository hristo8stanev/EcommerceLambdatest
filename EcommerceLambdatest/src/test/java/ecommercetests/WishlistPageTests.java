package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductDetailsFactory.*;

public class WishlistPageTests extends BaseTest {

    @Test
    public void addProductToWishList_When_ProductAddedToWishlist_And_ProductSuccessfullyAddedToWishlist()
    {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.wishlistPage.addProductToWishList();
        webSite.mainHeader.addProductToCard(SamsungSyncMaster());
        webSite.wishlistPage.addProductToWishList();
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.wishlistPage.addProductToWishList();
        webSite.wishlistPage.proceedToWishList();

        webSite.wishlistPage.assertUrlPage();
        webSite.wishlistPage.assertions().assertProductAddedToWishList(HtcTouch());
        webSite.wishlistPage.assertions().assertProductAddedToWishList(iPodNano());
        webSite.wishlistPage.assertions().assertProductAddedToWishList(SamsungSyncMaster());
    }
}