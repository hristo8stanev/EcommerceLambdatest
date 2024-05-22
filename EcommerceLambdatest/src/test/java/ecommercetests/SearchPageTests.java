package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductsFactory.*;

public class SearchPageTests extends BaseTest {

    @Test
    public void searchExistingProductByName_When_NonAuthenticatedUserSearchesProducts()
    {
        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();

        webSite.mainHeader.searchProductByName(HtcTouch());

        webSite.searchPage.assertions().assertTheProductNameAndPrice(HtcTouch());
    }

    @Test
    public void searchNonExistingProductByName_When_NonAuthenticatedUserSearchedProduct()
    {
        webSite.homePage.navigate();
        webSite.homePage.assertUrlPage();

        webSite.mainHeader.searchProductByName(BoschProduct());
        webSite.searchPage.assertions().assertErrorMessageWhenNonExistingProductIsSearched();
    }

    @Test
    public void filterProductByPrice_When_NonAuthenticatedUserFiltersProductsByPrice_And_ProductsAreFilteredCorrectly()
    {
        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();
        webSite.searchPage.typeRangePrices(MIN_PRICE, MAX_PRICE);

        webSite.searchProductPriceRange.assertUrlPage();
    }

    @Test
    public void filterProductByName_When_AuthenticatedUserFiltersProductsByName_And_ProductsAreSortedCorrectly()
    {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByName(HtcTouch());

        webSite.searchPage.assertions().assertTheProductNameAndPrice(HtcTouch());
    }

    @Test
    public void filterProductByName_When_NonAuthenticatedUserFiltersProductsByName_And_ProductsAreSortedCorrectly()
    {
       webSite.searchPage.navigate();

       webSite.searchPage.assertUrlPage();

       webSite.searchPage.searchProductByName(HtcTouch());

       webSite.searchPage.assertions().assertTheProductNameAndPrice(HtcTouch());
    }
}