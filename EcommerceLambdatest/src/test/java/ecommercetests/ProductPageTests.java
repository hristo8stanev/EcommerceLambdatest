package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.EMAIL_ADDRESS;
import static constants.Constants.PASSWORD;
import static factories.ProductDetailsFactory.AppleProduct;
import static factories.ProductDetailsFactory.HtcTouch;

public class ProductPageTests extends BaseTest {

    @Test
    public void selectDifferentSizeOfProduct_when_differentSizeOfProductsSelected() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(AppleProduct());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleProduct());
    }

    @Test
    public void selectDifferentSizeProduct_when_differentSizeProductSelectedAsNonAuthenticatedUser() {
        webSite.loginPage.navigate();
        webSite.mainHeader.addProductToCard(AppleProduct());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleProduct());
    }

    @Test
    public void writeReview_when_yourNameAndYourReviewTyped_and_nonAuthenticatedUserProvided() {
        var user = CustomerFactory.userReview();

        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByName(HtcTouch());
        webSite.searchPage.proceedToProduct(HtcTouch());
        webSite.productPage.writeReview(user);

        webSite.productPage.assertions().assertSubmittedReviewForApproval();
    }

    @Test
    public void writeReview_when_yourNameAndYourReviewTyped_and_authenticatedUserProvided() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        var user = CustomerFactory.userReview();

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByName(HtcTouch());
        webSite.searchPage.proceedToProduct(HtcTouch());
        webSite.productPage.writeReview(user);

        webSite.productPage.assertions().assertSubmittedReviewForApproval();
    }
}