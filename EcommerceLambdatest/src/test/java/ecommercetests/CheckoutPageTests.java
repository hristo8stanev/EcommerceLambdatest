package ecommercetests;

import core.BaseTest;
import factories.CheckoutInformationFactory;
import factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductDetailsFactory.*;

public class CheckoutPageTests extends BaseTest {

    //LOGIN USER
    @Test
    public void checkout_when_loginUserTypeSelected_and_1productPurchased_and_paymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateLoginCheckout(EMAIL_ADDRESS, PASSWORD);
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(personalInformation);

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(HtcTouch());

        webSite.checkoutPage.fillUserDetails(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());
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
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(NikonProduct(), HtcTouch());
        webSite.checkoutPage.fillUserDetails(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch(), NikonProduct());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$150.00"
        //But was:  "$182.00"

        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    //GUEST USER
    @Test
    public void checkout_when_guestUserTypeSelected_and_1productPurchased_and_paymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateGuestCheckout();
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(HtcTouch());

        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$146.00"
        //But was:  "$120.00"
        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    @Test
    public void checkout_when_guestUserTypeSelected_and_2productPurchased_and_paymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateGuestCheckout();
        var checkoutInformation = CheckoutInformationFactory.build(NikonProduct(), HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(NikonProduct());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(NikonProduct(), HtcTouch());

        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch(), NikonProduct());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$80.00
        //But was:  "$98.00
        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }

    //REGISTER USER
    @Test
    public void checkout_when_registerUserTypeSelected_And_1productPurchased_and_paymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateRegisterAccount();
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(HtcTouch());

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
    public void checkout_when_registerUserTypeSelected_and_2productPurchased_and_paymentConfirmed() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateRegisterAccount();
        var checkoutInformation = CheckoutInformationFactory.build(NikonProduct(), HtcTouch());

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(NikonProduct());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(NikonProduct(), HtcTouch());

        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

        webSite.checkoutPage.assertions().assertCheckoutInformation(checkoutInformation);

        webSite.checkoutPage.proceedToCheckout();

        webSite.checkoutPage.assertions().assertConfirmButtonDisplayed();
        webSite.checkoutPage.assertions().assertProductInformationConfirmOrder(HtcTouch(), NikonProduct());
        //The assertion failed because there is a bug in this step. On the checkout/checkout page and checkout/confirm page, the prices are different.
        //Expected: "$120.00"
        //But was:  "$146.00"
        webSite.checkoutPage.confirmOrder();

        webSite.successfulOrderPage.assertions().assertSuccessfullyCheckoutOrder();
        webSite.successfulOrderPage.assertUrlPage();
    }
}