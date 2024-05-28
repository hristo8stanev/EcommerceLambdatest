package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductDetailsFactory.*;

public class ComparePageTests extends BaseTest {
    //AUTHENTICATED USER
    @Test
    public void compare3products_when_3ProductsSelected_and_authenticatedUserProvided() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        webSite.loginPage.navigate();

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
        webSite.comparisonPage.navigate();

        webSite.mainHeader.addProductToCompareList(IPodShuffleProduct());
        webSite.mainHeader.addProductToCompareList(SamsungSyncMaster());
        webSite.mainHeader.addProductToCompareList(iPodNano());
        webSite.comparisonPage.navigate();

        webSite.comparisonPage.assertUrlPage();
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(iPodNano(), SamsungSyncMaster(), IPodShuffleProduct());

        webSite.comparisonPage.removeProductsById(iPodNano(), SamsungSyncMaster(), IPodShuffleProduct());
    }
}