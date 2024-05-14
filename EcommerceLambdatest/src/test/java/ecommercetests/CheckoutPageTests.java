package ecommercetests;

import core.BaseTest;
import factories.CheckoutInformationFactory;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductsFactory.*;

public class CheckoutPageTests extends BaseTest {

    @Test
    public void Checkout_When_LoginUserTypeSelected_And_3ProductsPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var checkoutInformation = CheckoutInformationFactory.Build(iPodNano());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.selectLoginAccountType();
        webSite.checkoutPage.loginUser(EmailAddress, Password);

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCorrect(iPodNano());
        webSite.checkoutPage.fillUserDetails(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        // The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        // Expected: "$150.00"
        // But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(iPodNano());

        webSite.checkoutPage.confirmOrder();

        webSite.checkoutPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }
}
