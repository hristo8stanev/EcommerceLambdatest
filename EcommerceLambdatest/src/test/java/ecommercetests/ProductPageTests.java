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
        webSite.mainHeader.searchProductByName(AppleCinema());
        webSite.searchPage.proceedToProduct(AppleCinema());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleCinema());

        webSite.cartPage.removeProductFromCart();
    }

    @Test
    public void selectDifferentSizeProduct_when_differentSizeProductSelected_as_nonAuthenticatedUser() {
        webSite.mainHeader.searchProductByName(AppleCinema());
        webSite.searchPage.proceedToProduct(AppleCinema());
        webSite.productPage.selectMediumSizeType();
        webSite.cartPage.navigate();

        webSite.cartPage.assertUrlPage();
        webSite.productPage.assertions().assertSizeProductIsCorrect(AppleCinema());

        webSite.cartPage.removeProductFromCart();
    }

    @Test
    public void writeReview_when_yourNameAndYourReviewTyped_and_nonAuthenticatedUserProvided() {
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByFullName(HtcTouch());
        webSite.searchPage.proceedToProduct(HtcTouch());
        webSite.productPage.writeReview(user);

        webSite.productPage.assertions().assertSubmittedReviewForApproval();
    }

    @Test
    public void writeReview_when_yourNameAndYourReviewTyped_and_authenticatedUserProvided() {
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByFullName(HtcTouch());
        webSite.searchPage.proceedToProduct(HtcTouch());
        webSite.productPage.writeReview(user);

        webSite.productPage.assertions().assertSubmittedReviewForApproval();
    }

    @Test
    public void quickViewProductInformation_when_clickOnQuickViewButton_and_allInformationIsDisplayed_as_nonAuthenticatedUser() {
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByFullName(IPodShuffleProduct());
        webSite.searchPage.proceedToQuickView(IPodShuffleProduct());

        webSite.searchPage.assertions().assertProductInformation(IPodShuffleProduct());
    }

    @Test
    public void addProductToCart_when_clickOnAddOnCartButton_when_productActionDisplayed_and_productIsAddedToShoppingCart_as_nonAuthenticatedUser() {
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByFullName(IPodShuffleProduct());
        webSite.searchPage.addToCart(IPodShuffleProduct());
        webSite.cartPage.navigate();

        webSite.cartPage.assertions().assertProductsInformation(IPodShuffleProduct());
    }

    @Test
    public void addProductToWishlist_when_clickOnAddToWishlistButton_when_productActionDisplayed_and_productIsAddedToWishlist_as_authenticatedUser() {
        webSite.loginPage.loginUser(loginUser);

        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByFullName(IPodShuffleProduct());
        webSite.searchPage.addToWishlist(IPodShuffleProduct());
        webSite.wishlistPage.navigate();

        webSite.wishlistPage.assertions().assertProductAddedToWishList(IPodShuffleProduct());
    }

    @Test
    public void compareTwoProduct_when_clickOnCompareProductButton_when_productActionDisplayed_and_productIsAddedToProductComparison_as_nonAuthenticatedUser() {
        webSite.searchPage.navigate();
        webSite.searchPage.searchProductByFullName(IPodShuffleProduct());
        webSite.searchPage.compareProducts(IPodShuffleProduct());
        webSite.searchPage.searchProductByFullName(iPodNano());
        webSite.searchPage.compareProducts(iPodNano());
        webSite.comparisonPage.navigate();

        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(IPodShuffleProduct(),iPodNano());
    }
}