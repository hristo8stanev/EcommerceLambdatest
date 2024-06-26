package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.cartpage.BillingInformation;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CheckoutInformationFactory;
import websitedata.factories.CustomerFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static websitedata.factories.ProductDetailsFactory.*;

public class CheckoutPageTests extends BaseTest {

    BillingInformation billingDetails;
    PersonalInformation loginUser;
    PersonalInformation guestUser;
    PersonalInformation registerUser;

    @BeforeEach
    public void setup() {
        billingDetails = CustomerFactory.generateBillingAddress();
        loginUser = CustomerFactory.generateLoginCheckout(EMAIL_ADDRESS, PASSWORD);
        guestUser = CustomerFactory.generateGuestCheckout();
        registerUser = CustomerFactory.generateRegisterAccount();
        webSite.checkoutPage.navigate();
    }

    //LOGIN USER
    @Test
    public void checkout_when_loginUserTypeSelected_and_1productPurchased_and_paymentConfirmed() {
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch());

        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(loginUser);

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
        var checkoutInformation = CheckoutInformationFactory.build(NikonProduct(), HtcTouch());

        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.mainHeader.addProductToCard(NikonProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(loginUser);

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
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch());

        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(HtcTouch());

        webSite.checkoutPage.fillBillingNewUserDetails(guestUser);
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
        var checkoutInformation = CheckoutInformationFactory.build(NikonProduct(), HtcTouch());

        webSite.mainHeader.addProductToCard(NikonProduct());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(NikonProduct(), HtcTouch());

        webSite.checkoutPage.fillBillingNewUserDetails(guestUser);
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
        var checkoutInformation = CheckoutInformationFactory.build(HtcTouch());

        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(HtcTouch());

        webSite.checkoutPage.fillBillingNewUserDetails(registerUser);
        webSite.checkoutPage.fillBillingAddress(billingDetails);

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
    public void checkout_when_registerUserTypeSelected_and_2productPurchased_and_paymentConfirmed() {
        var checkoutInformation = CheckoutInformationFactory.build(NikonProduct(), HtcTouch());

        webSite.mainHeader.addProductToCard(NikonProduct());
        webSite.mainHeader.addProductToCard(HtcTouch());
        webSite.checkoutPage.navigate();

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(NikonProduct(), HtcTouch());

        webSite.checkoutPage.fillBillingNewUserDetails(registerUser);
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

    @Test
    public void errorMessageIsDisplayed_when_tryingToCheckoutWithoutAgreeingToTerms() {
        webSite.mainHeader.addProductToCard(NikonProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.loginUser(loginUser);

        webSite.checkoutPage.assertUrlPage();
        webSite.checkoutPage.assertions().assertProductInformationCheckoutPage(NikonProduct());
        webSite.checkoutPage.fillUserDetails(billingDetails);
        webSite.checkoutPage.continueOrderWithoutAgreeTerms();

        webSite.checkoutPage.assertions().assertErrorMessageWithoutAgreeterms();

        webSite.checkoutPage.removeProduct();
    }
}