package ecommercetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.cartpage.BillingInformation;
import website.pages.myaccountpage.PurchaseGiftCertificate;
import website.pages.registerpage.PersonalInformation;
import websitedata.factories.CustomerFactory;
import websitedata.factories.GiftCertificateFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static websitedata.factories.ProductDetailsFactory.IPodShuffleProduct;

public class MyAccountPageTests extends BaseTest {

    PersonalInformation loginUser;
    PersonalInformation myAccountInformation;
    PurchaseGiftCertificate giftCertificate;
    PersonalInformation registerUser;
    BillingInformation billingDetails;

    @BeforeEach
    public void setup() {
        loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        myAccountInformation = CustomerFactory.GenerateRegisterAccount();
        giftCertificate = GiftCertificateFactory.generateGiftCertificate();
        registerUser = CustomerFactory.GenerateGuestCheckout();
        billingDetails = CustomerFactory.GenerateBillingAddress();
    }

    @Test
    public void editMyProfile_when_firstNameLastNameEmailAddressAndTelephoneEdited_and_continueButtonClicked() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.changeMyAccountInformation(myAccountInformation);

        webSite.myAccountPage.assertions().assertAccountInformationIsSuccessfullyUpdated();
        webSite.myAccountPage.assertUrlPage();
    }

    @Test
    public void changeMyPassword_when_newPasswordSet_and_continueButtonClicked() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.changeMyPassword();

        webSite.myAccountPage.assertions().assertPasswordSuccessfullyChanged();
        webSite.myAccountPage.assertUrlPage();
    }

    @Test
    public void purchaseGiftCertificate_when_authenticatedUser_verifyGiftInShoppingCart() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.proceedToMyVoucherSection();
        webSite.myAccountPage.purchaseGiftCertificate(giftCertificate);

        webSite.myAccountPage.assertions().assertSuccessfullyPurchaseGiftCertificate();
        webSite.successfulVoucherPage.assertUrlPage();

        webSite.cartPage.navigate();
        webSite.myAccountPage.assertions().assertGiftCertificateAddedToShoppingCart(giftCertificate);
    }

    @Test
    public void removeGiftCertificate_when_authenticatedUser_and_removedGiftFromShoppingCart() {
        webSite.registerPage.navigate();
        webSite.registerPage.createUser(registerUser);
        webSite.myAccountPage.proceedToMyVoucherSection();
        webSite.myAccountPage.purchaseGiftCertificate(giftCertificate);

        webSite.myAccountPage.assertions().assertSuccessfullyPurchaseGiftCertificate();
        webSite.successfulVoucherPage.assertUrlPage();

        webSite.cartPage.navigate();
        webSite.myAccountPage.assertions().assertGiftCertificateAddedToShoppingCart(giftCertificate);
        webSite.myAccountPage.removeProductFromCart();
        webSite.myAccountPage.assertions().assertGiftCertificateRemoved(giftCertificate);
    }

    @Test
    public void addNewAddress_addressAddedFromAddressBook_and_authenticatedUserProvidesDetails() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.proceedToAddressBookSection();

        webSite.newAddressPage.assertUrlPage();

        webSite.myAccountPage.addNewAddress(billingDetails);

        webSite.myAccountPage.assertions().assertSuccessfullyAddedNewAddress();
        webSite.newAddressBookPage.assertUrlPage();
    }

    @Test
    public void checkMyOrderHistory_when_authenticatedUserPurchasesProduct() {
        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(myAccountInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);
        webSite.checkoutPage.proceedToCheckout();
        webSite.checkoutPage.confirmOrder();

        webSite.checkoutPage.assertions().assertSuccessfullyCheckoutOrder();

        webSite.myAccountPage.proceedToOrderHistorySection();

        webSite.myAccountPage.assertions().assertCustomerNameCorrect(myAccountInformation);
        webSite.myAccountPage.assertions().assertThePurchaseDateToday();
    }
}