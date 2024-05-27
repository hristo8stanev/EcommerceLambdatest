package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductDetailsFactory.*;

public class CartPageTests extends BaseTest {

    @Test
    public void addTwoProductToCart_when_authenticatedUserAddsProductsToCart_and_productDetailsCorrect() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductsInformation(IPodShuffleProduct());
    }

    @Test
    public void updateTheQuantityTheProducts_when_authenticatedUserUpdatesProductQuantityInCart_and_quantityIsUpdatedCorrectly() {
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
    public void removeProductFromTheShoppingCart_when_authenticatedUserRemovesProductFromCart_and_productIsSuccessfullyRemoved() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.cartPage.navigate();
        webSite.cartPage.removeProductFromCart();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductRemoved(HtcTouch());
    }

    @Test
    public void addProductToTheShopping_nonAuthenticatedUserAddsProductToCart_and_productIsAddedSuccessfully() {
        webSite.cartPage.navigate();
        webSite.mainHeader.addProductToCard(SamsungSyncMaster());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductsInformation(SamsungSyncMaster());
    }

    @Test
    public void updateTheQuantityOfTheProducts_when_nonAuthenticatedUserUpdatesProductQuantityInCart_and_quantityIsUpdatedCorrectly() {
        webSite.cartPage.navigate();
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();

        webSite.cartPage.updateQuantity(UPDATE_QUANTITY);

        webSite.cartPage.assertions().assertSuccessfullyUpdatedQuantity(UPDATE_QUANTITY);

    }

    @Test
    public void removeProductTheShoppingCart_when_nonAuthenticatedUserRemovesProductFromCart_and_productIsSuccessfullyRemoved() {
        webSite.cartPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();

        webSite.cartPage.removeProductFromCart();

        webSite.cartPage.assertions().assertProductRemoved(HtcTouch());
    }

    @AfterEach
    public void cleanData() {
        webSite.cartPage.removeProductFromCart();
    }
}