package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductsFactory.*;

public class SearchPageTests extends BaseTest {

    @Test
    public void SearchExistingProductByName_When_NonAuthenticatedUserSearchesProducts()
    {
        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();

        webSite.mainHeader.searchProductByName(iPodNano());

        webSite.searchPage.assertions().assertTheProductNameAndPrice(iPodNano());
        //The assertion failed because there is a bug in this step. On the search/page page and default product price, the prices are different.
        //Expected: "$100.00"
        //But was:  "$122.00"
    }

    @Test
    public void SearchNonExistingProductByName_When_NonAuthenticatedUserSearchedProduct()
    {
        webSite.homePage.navigate();
        webSite.homePage.assertUrlPage();

        webSite.mainHeader.searchProductByName(BoschProduct());
        webSite.searchPage.assertions().assertErrorMessageWhenNonExistingProductIsSearched();
    }

    @Test
    public void FilterProductByPrice_When_NonAuthenticatedUserFiltersProductsByPrice_And_ProductsAreFilteredCorrectly()
    {
        webSite.searchPage.navigate();
        webSite.searchPage.assertUrlPage();
        webSite.searchPage.typeRangePrices(MinPrice, MaxPrice);

        webSite.searchProductPriceRange.assertUrlPage();
    }

    @Test
    public void FilterProductByName_When_AuthenticatedUserFiltersProductsByName_And_ProductsAreSortedCorrectly()
    {
        var loginUser = CustomerFactory.loginUser(EmailAddress,Password);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.searchPage.navigate();

        webSite.searchPage.assertUrlPage();

        webSite.searchPage.searchProductByName(HtcTouch());

        webSite.searchPage.assertions().assertTheProductNameAndPrice(HtcTouch());
    }

    @Test
    public void FilterProductByName_When_NonAuthenticatedUserFiltersProductsByName_And_ProductsAreSortedCorrectly()
    {
       webSite.searchPage.navigate();

       webSite.searchPage.assertUrlPage();

       webSite.searchPage.searchProductByName(iPodNano());

       webSite.searchPage.assertions().assertTheProductNameAndPrice(iPodNano());
        //The assertion failed because there is a bug in this step. On the search/page page and default product price, the prices are different.
        //Expected: "$100.00"
        //But was: "$122.00"
    }
}
