package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static enums.ShopCategory.SOFTWARE;

public class HomePageTests extends BaseTest {

    @Test
    public void redirectToSpecialOfferPage_when_nonAuthorizeUserClickOnSpecialOfferTitle_and_siteSuccessfulRedirect() {
        webSite.homePage.navigate();

        webSite.homePage.proceedToSpecialOfferPage();

        webSite.homePage.assertions().assertSuccessfulRedirectToSpecialOfferPage();
        webSite.specialProductPage.assertUrlPage();
    }

    @Test
    public void redirectToBlogArticlePage_when_nonAuthorizedUserClickOnBlogTitleOnHomePage_and_siteSuccessfulRedirect() {
        webSite.homePage.navigate();

        webSite.homePage.proceedToBlogArticlePage();

        webSite.homePage.assertions().assertSuccessfulRedirectToBlogArticlePage();
        webSite.blogArticlePage.assertUrlPage();
    }

    @Test
    public void redirectToMyAccountPage_when_nonAuthorizedUserClickOnMyAccountTitle_and_siteSuccessfulRedirectAndLoginFormDisplayed() {
        webSite.homePage.navigate();
        webSite.homePage.proceedToMyAccount();

        webSite.homePage.assertions().assertSuccessfulLoginFormDisplayed();
        webSite.loginPage.assertUrlPage();
    }

    @Test
    public void redirectToShopByCategoryPage_when_nonAuthorizedUserClickOnShopCategory_and_chooseOneRandomCategory() {
        webSite.homePage.navigate();
        webSite.homePage.proceedToShopByCategory(SOFTWARE);

        webSite.homePage.assertions().assertCorrectCategoryDisplayed(SOFTWARE);

        //ToDo
        //INTEGRATE ALLURE REPORT
        //CHECK ALL CLASSES AND FOLDERS IF SOMEBODY IS EMPTY

    }
}