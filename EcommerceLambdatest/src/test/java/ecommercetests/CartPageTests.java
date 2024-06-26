package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static websitedata.factories.ProductDetailsFactory.*;

public class CartPageTests extends BaseTest {

    PersonalInformation personalInformation;

    @BeforeEach
    public void setup() {
        personalInformation = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        webSite.loginPage.navigate();
    }

    @AfterEach
    public void cleanData() {
        webSite.cartPage.removeProductFromCart();
    }

    @Test
    public void addTwoProductToCart_when_authenticatedUserAddsProductsToCart_and_productDetailsCorrect() {
        webSite.loginPage.loginUser(personalInformation);
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductsInformation(IPodShuffleProduct(), iPodNano());
    }

    @Test
    public void updateTheQuantityTheProducts_when_authenticatedUserUpdatesProductQuantityInCart_and_quantityIsUpdatedCorrectly() {
        webSite.loginPage.loginUser(personalInformation);
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductName(iPodNano());

        webSite.cartPage.updateQuantity(UPDATE_QUANTITY);

        webSite.cartPage.assertions().assertSuccessfullyUpdatedQuantity(UPDATE_QUANTITY);
    }

    @Test
    public void errorMessageDisplayed_when_settingQuantityOfAppleProductToLessThanMinimum() {
        webSite.loginPage.loginUser(personalInformation);
        webSite.mainHeader.searchProductByName(AppleCinema());
        webSite.searchPage.proceedToProduct(AppleCinema());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();
        webSite.cartPage.updateQuantity(UNDER_THE_MINIMUM);
        webSite.cartPage.assertions().assertErrorMessageMinimumOrderAmount();
    }

    @Test
    public void removeProductFromTheShoppingCart_when_authenticatedUserRemovesProductFromCart_and_cartWasEmpty() {
        webSite.loginPage.loginUser(personalInformation);
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.cartPage.navigate();
        webSite.cartPage.removeProductFromCart();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductRemoved(HtcTouch());
    }

    @Test
    public void addProductToTheShopping_nonAuthenticatedUserAddsProductToCart_and_productIsAddedSuccessfully() {
        webSite.mainHeader.addProductToCard(SamsungSyncMaster());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.cartPage.assertions().assertProductsInformation(SamsungSyncMaster());
    }

    @Test
    public void updateTheQuantityOfTheProducts_when_nonAuthenticatedUserUpdatesProductQuantityInCart_and_quantityIsUpdatedCorrectly() {
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();

        webSite.cartPage.updateQuantity(UPDATE_QUANTITY);

        webSite.cartPage.assertions().assertSuccessfullyUpdatedQuantity(UPDATE_QUANTITY);
    }

    @Test
    public void removeProductTheShoppingCart_when_nonAuthenticatedUserRemovesProductFromCart_and_cartWasEmpty() {
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();

        webSite.cartPage.removeProductFromCart();

        webSite.cartPage.assertions().assertProductRemoved(HtcTouch());
    }
}