package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductDetailsFactory.*;

public class WishlistPageTests extends BaseTest {

    @Test
    public void addProductToWishList_when_productAddedToWishlist_and_productSuccessfullyAddedToWishlist() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToWishList(HtcTouch());
        webSite.mainHeader.addProductToWishList(SamsungSyncMaster());
        webSite.mainHeader.addProductToWishList(iPodNano());
        webSite.wishlistPage.proceedToWishList();

        webSite.wishlistPage.assertUrlPage();
        webSite.wishlistPage.assertions().assertProductAddedToWishList(HtcTouch(),iPodNano(),SamsungSyncMaster());
        webSite.wishlistPage.removeProductsById(HtcTouch(),iPodNano(),SamsungSyncMaster());
    }
}