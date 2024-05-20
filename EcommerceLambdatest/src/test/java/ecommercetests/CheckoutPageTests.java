package ecommercetests;

import core.BaseTest;
import factories.CheckoutInformationFactory;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductsFactory.*;

public class CheckoutPageTests extends BaseTest {

    //LOGIN USER
    @Test
    public void Checkout_When_LoginUserTypeSelected_And_1ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateLoginCheckout(EMAIL_ADDRESS, PASSWORD);
        var checkoutInformation = CheckoutInformationFactory.Build(HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(personalInformation);

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCorrect(HtcTouch());

        webSite.checkoutPage.fillUserDetails(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    @Test
    public void Checkout_When_LoginUserTypeSelected_And_2ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateLoginCheckout(EMAIL_ADDRESS, PASSWORD);
        var checkoutInformation = CheckoutInformationFactory.Build(IPodShuffleProduct(), HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(personalInformation);

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCorrect(IPodShuffleProduct());
        webSite.checkoutPage.assertions().assertProductInformationCorrect(HtcTouch());
        webSite.checkoutPage.fillUserDetails(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
       //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
       //Expected: "$150.00"
       //But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    //GUEST USER
    @Test
    public void Checkout_When_GuestUserTypeSelected_And_1ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateGuestCheckout();
        var checkoutInformation = CheckoutInformationFactory.Build(IPodShuffleProduct());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    @Test
    public void Checkout_When_GuestUserTypeSelected_And_2ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateGuestCheckout();
        var checkoutInformation = CheckoutInformationFactory.Build(IPodShuffleProduct(), iPodNano());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.mainHeader.addProductToCard(iPodNano());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);


        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(iPodNano());
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    //REGISTER USER
    @Test
    public void Checkout_When_RegisterUserTypeSelected_And_1ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateRegisterAccount();
        var checkoutInformation = CheckoutInformationFactory.Build(IPodShuffleProduct());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    @Test
    public void Checkout_When_RegisterUserTypeSelected_And_2ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateRegisterAccount();
        var checkoutInformation = CheckoutInformationFactory.Build(HtcTouch(), IPodShuffleProduct());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }
}