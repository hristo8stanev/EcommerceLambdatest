package ecommercetests;

import core.BaseTest;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static enums.ProductOpened.*;
import static enums.ReasonType.*;
import static websitedata.factories.ProductDetailsFactory.iPodNano;

public class ReturnProductPageTests extends BaseTest {
    @Test
    public void returnProduct_when_authenticatedUser_fillsReturnForm_and_submit() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.proceedToReturnOrderSection();

        webSite.returnProductPage.assertUrlPage();

        webSite.returnProductPage.fillReturnProductForm(iPodNano(), DEAD_ON_ARRIVAL, YES);

        webSite.successfulReturnProductPage.assertUrlPage();
        webSite.returnProductPage.assertions().assertProductReturnsMessage(PRODUCT_RETURNS_MESSAGE);
    }
}