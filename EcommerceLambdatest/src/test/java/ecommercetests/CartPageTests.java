package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductsFactory.*;

public class CartPageTests extends BaseTest {

    @Test
    public void addTwoProductToCart_When_AuthenticatedUserAddsProductsToCart_And_ProductDetailsCorrect() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(SamsungSyncMaster());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductName(HtcTouch());
        webSite.cartPage.assertions().assertProductName(SamsungSyncMaster());
        webSite.cartPage.assertions().assertProductInformation(HtcTouch());
        webSite.cartPage.assertions().assertProductInformation(SamsungSyncMaster());
    }

    @Test
    public void updateTheQuantityTheProducts_When_AuthenticatedUserUpdatesProductQuantityInCart_And_QuantityIsUpdatedCorrectly() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductName(iPodNano());

        webSite.cartPage.updateQuantity(UPDATE_QUANTITY);

        webSite.cartPage.assertions().assertSuccessfullyUpdatedQuantity(UPDATE_QUANTITY);
    }

    @Test
    public void removeProductFromTheShoppingCart_When_AuthenticatedUserRemovesProductFromCart_And_ProductIsSuccessfullyRemoved() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.cartPage.navigate();
        webSite.cartPage.removeProductFromCart();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductRemoved();
    }

    @Test
    public void addProductToTheShopping_NonAuthenticatedUserAddsProductToCart_And_ProductIsAddedSuccessfully() {
        webSite.cartPage.navigate();
        webSite.mainHeader.addProductToCard(SamsungSyncMaster());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductName(SamsungSyncMaster());
        webSite.cartPage.assertions().assertProductInformation(SamsungSyncMaster());
    }

    @Test
    public void updateTheQuantityOfTheProducts_When_NonAuthenticatedUserUpdatesProductQuantityInCart_And_QuantityIsUpdatedCorrectly() {
        webSite.cartPage.navigate();
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();

        webSite.cartPage.updateQuantity(UPDATE_QUANTITY);
        webSite.cartPage.assertions().assertSuccessfullyUpdatedQuantity(UPDATE_QUANTITY);
    }

    @Test
    public void removeProductTheShoppingCart_When_NonAuthenticatedUserRemovesProductFromCart_And_ProductIsSuccessfullyRemoved() {
        webSite.cartPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();

        webSite.cartPage.removeProductFromCart();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductRemoved();
    }
}