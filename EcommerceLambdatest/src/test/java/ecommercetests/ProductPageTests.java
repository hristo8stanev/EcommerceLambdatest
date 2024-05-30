package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.productpage.CommentDetails;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CommentFactory;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static enums.ReviewStars.*;
import static websitedata.factories.ProductDetailsFactory.*;

public class ProductPageTests extends BaseTest {

    PersonalInformation loginUser;
    CommentDetails user;

    @BeforeEach
    public void setup() {
        loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        user = CommentFactory.userReview(FIVE_STAR);
        webSite.loginPage.navigate();
    }

    @Test
    public void selectDifferentSizeOfProduct_when_differentSizeOfProductsSelected_as_authenticatedUser() {
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
    public void selectDifferentSizeProduct_when_differentSizeProductSelected_as_nonAuthenticatedUser() {
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