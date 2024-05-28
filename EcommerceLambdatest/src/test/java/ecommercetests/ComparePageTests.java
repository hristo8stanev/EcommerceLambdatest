package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static websitedata.factories.ProductDetailsFactory.*;


public class ComparePageTests extends BaseTest {

    PersonalInformation loginUser;

    @BeforeEach
    public void setup() {
        loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        webSite.loginPage.navigate();
    }

    //AUTHENTICATED USER
    @Test
    public void compare3products_when_3ProductsSelected_and_authenticatedUserProvided() {
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCompareList(IPodShuffleProduct());
        webSite.mainHeader.addProductToCompareList(SamsungSyncMaster());
        webSite.mainHeader.addProductToCompareList(iPodNano());
        webSite.comparisonPage.navigate();

        webSite.comparisonPage.assertUrlPage();
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(iPodNano(), SamsungSyncMaster(), IPodShuffleProduct());

        webSite.comparisonPage.removeProductsById(iPodNano(), SamsungSyncMaster(), IPodShuffleProduct());
    }

    //NON-AUTHENTICATED USER
    @Test
    public void compare3products_when_3ProductsSelected_and_nonAuthenticatedUserProvided() {
        webSite.mainHeader.addProductToCompareList(IPodShuffleProduct());
        webSite.mainHeader.addProductToCompareList(SamsungSyncMaster());
        webSite.mainHeader.addProductToCompareList(iPodNano());
        webSite.comparisonPage.navigate();

        webSite.comparisonPage.assertUrlPage();
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(iPodNano(), SamsungSyncMaster(), IPodShuffleProduct());

        webSite.comparisonPage.removeProductsById(iPodNano(), SamsungSyncMaster(), IPodShuffleProduct());
    }
}