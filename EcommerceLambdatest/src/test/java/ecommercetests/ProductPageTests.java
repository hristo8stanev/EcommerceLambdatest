package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.EMAIL_ADDRESS;
import static constants.Constants.PASSWORD;
import static websitedata.factories.ProductDetailsFactory.AppleProduct;
import static websitedata.factories.ProductDetailsFactory.HtcTouch;

public class ProductPageTests extends BaseTest {

    PersonalInformation loginUser;
    PersonalInformation user;

    @BeforeEach
    public void setup() {
        loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        user = CustomerFactory.userReview();
        webSite.loginPage.navigate();
    }

    @Test
    public void selectDifferentSizeOfProduct_when_differentSizeOfProductsSelected() {
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.searchProductByName(AppleProduct());
        webSite.searchPage.proceedToProduct(AppleProduct());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleProduct());

        webSite.cartPage.removeProductFromCart();
    }

    @Test
    public void selectDifferentSizeProduct_when_differentSizeProductSelectedAsNonAuthenticatedUser() {
        webSite.mainHeader.searchProductByName(AppleProduct());
        webSite.searchPage.proceedToProduct(AppleProduct());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleProduct());

        webSite.cartPage.removeProductFromCart();
    }

    @Test
    public void writeReview_when_yourNameAndYourReviewTyped_and_nonAuthenticatedUserProvided() {
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByName(HtcTouch());
        webSite.searchPage.proceedToProduct(HtcTouch());
        webSite.productPage.writeReview(user);

        webSite.productPage.assertions().assertSubmittedReviewForApproval();
    }

    @Test
    public void writeReview_when_yourNameAndYourReviewTyped_and_authenticatedUserProvided() {
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByName(HtcTouch());
        webSite.searchPage.proceedToProduct(HtcTouch());
        webSite.productPage.writeReview(user);

        webSite.productPage.assertions().assertSubmittedReviewForApproval();
    }
}