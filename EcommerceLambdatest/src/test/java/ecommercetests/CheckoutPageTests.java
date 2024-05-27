package ecommercetests;

import core.BaseTest;
import factories.CheckoutInformationFactory;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;
import pages.cartpage.CheckoutInformation;

import static constants.Constants.*;
import static factories.ProductDetailsFactory.*;

public class CheckoutPageTests extends BaseTest {

    //LOGIN USER
    @Test
    public void checkout_when_loginUserTypeSelected_and_1productPurchased_and_paymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateLoginCheckout(EMAIL_ADDRESS, PASSWORD);
        var checkoutInformation = CheckoutInformationFactory.build(IPodShuffleProduct());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(personalInformation);

        webSite.checkoutPage.assertUrlPage();
        //webSite.checkoutPage.assertions().assertProductInformationCorrect(IPodShuffleProduct());

        webSite.checkoutPage.fillUserDetails(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    @Test
    public void checkout_when_loginUserTypeSelected_and_2productPurchased_and_paymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateLoginCheckout(EMAIL_ADDRESS, PASSWORD);
        var checkoutInformation = CheckoutInformationFactory.build(NikonProduct(), HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.mainHeader.addProductToCard(NikonProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(personalInformation);

        webSite.checkoutPage.assertUrlPage();
        //webSite.checkoutPage.assertions().assertProductInformationCorrect(NikonProduct());
        //webSite.checkoutPage.assertions().assertProductInformationCorrect(HtcTouch());
        webSite.checkoutPage.fillUserDetails(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(NikonProduct());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    //GUEST USER
    @Test
    public void checkout_When_GuestUserTypeSelected_And_1ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateGuestCheckout();
        var checkoutInformation = CheckoutInformationFactory.build(IPodShuffleProduct());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"
        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    @Test
    public void checkout_When_GuestUserTypeSelected_And_2ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateGuestCheckout();
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch(), IPodShuffleProduct());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$120.00
        //But was:  "$146.00
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    //REGISTER USER
    @Test
    public void checkout_When_RegisterUserTypeSelected_And_1ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateRegisterAccount();
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    @Test
    public void checkout_When_RegisterUserTypeSelected_And_2ProductPurchased_And_PaymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateRegisterAccount();
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch(), IPodShuffleProduct());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(IPodShuffleProduct());

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }
}