package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductsFactory.*;

public class ComparePageTests extends BaseTest {

    @Test
    public void compare3products_when_3ProductsSelected_and_authenticatedUserProvided() {
        var loginUser = CustomerFactory.loginUser(EmailAddress, Password);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.comparisonPage.compareProduct();
        webSite.mainHeader.addProductToCard(SamsungSyncMaster());
        webSite.comparisonPage.compareProduct();
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.comparisonPage.compareProduct();
        webSite.comparisonPage.navigate();

        webSite.comparisonPage.assertUrlPage();
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(iPodNano());
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(SamsungSyncMaster());
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(IPodShuffleProduct());
    }

    @Test
    public void compare3products_when_3ProductsSelected_and_nonAuthenticatedUserProvided() {
        webSite.comparisonPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.comparisonPage.compareProduct();
        webSite.mainHeader.addProductToCard(SamsungSyncMaster());
        webSite.comparisonPage.compareProduct();
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.comparisonPage.compareProduct();
        webSite.comparisonPage.navigate();

        webSite.comparisonPage.assertUrlPage();
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(iPodNano());
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(SamsungSyncMaster());
        webSite.comparisonPage.assertions().assertTheProductAddedToComparePage(IPodShuffleProduct());
    }
}