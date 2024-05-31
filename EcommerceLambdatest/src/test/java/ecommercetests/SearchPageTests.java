package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static enums.Manufacturer.*;
import static websitedata.factories.ProductDetailsFactory.*;

public class SearchPageTests extends BaseTest {

    PersonalInformation loginUser;

    @BeforeEach
    public void setup() {
        loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
    }

    @Test
    public void searchExistingProductByFullName_when_nonAuthenticatedUserSearchesProducts() {
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.mainHeader.searchProductByName(HtcTouch());

        webSite.searchPage.assertions().assertProducts(HtcTouch());
    }

    @Test
    public void searchNonExistingProductByFullName_When_NonAuthenticatedUserSearchedProduct() {
        webSite.homePage.navigate();

        webSite.homePage.assertUrlPage();

        webSite.mainHeader.searchProductByName(BoschProduct());
        webSite.searchPage.assertions().assertErrorMessageWhenNonExistingProductIsSearched();
    }

    @Test
    public void filterProductByPrice_when_nonAuthenticatedUserFiltersProductsByPrice_and_productsAreFilteredCorrectly() {
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.typeRangePrices(MIN_PRICE, MAX_PRICE);

        webSite.searchProductPriceRange.assertUrlPage();
    }

    @Test
    public void filterProductByFullName_when_authenticatedUserFiltersProductsByName_and_productsAreSortedCorrectly() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByFullName(HtcTouch());

        webSite.searchPage.assertions().assertProducts(HtcTouch());
    }

    @Test
    public void productWasFound_when_searchingByPartialName_and_nonAuthenticatedUserProvided() {
        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByPartialName(IPodShuffleProduct());

        webSite.searchPage.assertions().assertProducts(IPodShuffleProduct());

    }

    @Test
    public void productWasFound_when_searchingByPartialName_and_authenticatedUserProvided() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByPartialName(SamsungSyncMaster());

        webSite.searchPage.assertions().assertProducts(SamsungSyncMaster());
    }

    @Test
    public void productWasFound_when_searchingByLowerCaseOnly_and_authenticatedUserProvided() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByLowerCaseOnlyName(SamsungSyncMaster());

        webSite.searchPage.assertions().assertProducts(SamsungSyncMaster());
    }

    @Test
    public void productWasFound_when_searchingByLowerCaseOnly_and_nonAuthenticatedUserProvided() {
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByLowerCaseOnlyName(SamsungSyncMaster());

        webSite.searchPage.assertions().assertProducts(SamsungSyncMaster());
    }

    @Test
    public void productWasFound_when_searchingByUpperCaseOnly_and_authenticatedUserProvided() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByUpperCaseOnlyName(SamsungSyncMaster());

        webSite.searchPage.assertions().assertProducts(SamsungSyncMaster());
    }

    @Test
    public void productWasFound_when_searchingByUpperCaseOnly_and_nonAuthenticatedUserProvided() {
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByUpperCaseOnlyName(SamsungSyncMaster());

        webSite.searchPage.assertions().assertProducts(SamsungSyncMaster());
    }

    @Test
    public void filterProductByManufacturer_when_authenticatedUserFiltersProductsByManufacturer_and_productsAreSortedCorrectly() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();

        webSite.searchPage.sortedByManufacturer(CANON);
        //ADD ASSERT BY MANUFACTURE
    }

    @Test
    public void filterProductByManufacturer_when_nonAuthenticatedUserFiltersProductsByManufacturer_and_productsAreSortedCorrectly() {
        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();

        webSite.searchPage.sortedByManufacturer(APPLE);
        //ADD ASSERT BY MANUFACTURE
    }
}