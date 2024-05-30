package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static websitedata.factories.ProductDetailsFactory.*;

public class WishlistPageTests extends BaseTest {

    PersonalInformation loginUser;

    @BeforeEach
    public void setup() {
        loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        webSite.loginPage.navigate();
    }

    @Test
    public void addProductToWishList_when_productAddedToWishlist_and_productSuccessfullyAddedToWishlist() {
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToWishList(HtcTouch());
        webSite.mainHeader.addProductToWishList(SamsungSyncMaster());
        webSite.mainHeader.addProductToWishList(iPodNano());
        webSite.wishlistPage.proceedToWishList();

        webSite.wishlistPage.assertUrlPage();
        webSite.wishlistPage.assertions().assertProductAddedToWishList(HtcTouch(), iPodNano(), SamsungSyncMaster());

    }

    @AfterEach
    public void cleanData() {
        webSite.wishlistPage.removeProductsById(HtcTouch(), iPodNano(), SamsungSyncMaster());
    }
}