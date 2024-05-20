package ecommercetests;

import core.BaseTest;
import factories.CustomerFactory;
import factories.GiftCertificateFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static factories.ProductsFactory.IPodShuffleProduct;
import static factories.ProductsFactory.iPodNano;


public class MyAccountPageTests extends BaseTest {

    @Test
    public void editMyProfile_When_FirstNameLastNameEmailAddressAndTelephoneEdited_And_ContinueButtonClicked() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        var myAccountInformation = CustomerFactory.GenerateRegisterAccount();

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.changeMyAccountInformation(myAccountInformation);

        webSite.myAccountPage.assertions().assertAccountInformationIsSuccessfullyUpdated();
        webSite.myAccountPage.assertUrlPage();
    }

    @Test
    public void changeMyPassword_When_NewPasswordSet_And_ContinueButtonClicked() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.changeMyPassword();

        webSite.myAccountPage.assertions().assertPasswordSuccessfullyChanged();
        webSite.myAccountPage.assertUrlPage();
    }

    @Test
    public void purchaseGiftCertificate_When_AuthenticatedUser_VerifyGiftInShoppingCart() {
        var gift = GiftCertificateFactory.generateGiftCertificate();
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.proceedToMyVoucherSection();
        webSite.myAccountPage.purchaseGiftCertificate(gift);

        webSite.myAccountPage.assertions().assertSuccessfullyPurchaseGiftCertificate();
        webSite.successfulVoucherPage.assertUrlPage();

        webSite.cartPage.navigate();
        webSite.myAccountPage.assertions().assertGiftCertificateAddedToShoppingCart(gift);
    }

    @Test
    public void removeGiftCertificate_When_AuthenticatedUser_And_RemovedGiftFromShoppingCart() {
        var gift = GiftCertificateFactory.generateGiftCertificate();
        var registerUser = CustomerFactory.GenerateRegisterAccount();

        webSite.registerPage.navigate();
        webSite.registerPage.createUser(registerUser);
        webSite.myAccountPage.proceedToMyVoucherSection();
        webSite.myAccountPage.purchaseGiftCertificate(gift);

        webSite.myAccountPage.assertions().assertSuccessfullyPurchaseGiftCertificate();
        webSite.successfulVoucherPage.assertUrlPage();

        webSite.cartPage.navigate();
        webSite.myAccountPage.assertions().assertGiftCertificateAddedToShoppingCart(gift);
        webSite.myAccountPage.removeProductFromCart();
        webSite.myAccountPage.assertions().assertGiftCertificateRemoved(gift);
    }

    @Test
    public void addNewAddress_AddressAddedFromAddressBook_And_AuthenticatedUserProvidesDetails() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);
        var newAddress = CustomerFactory.GenerateBillingAddress();

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.proceedToAddressBookSection();

        webSite.newAddressPage.assertUrlPage();

        webSite.myAccountPage.addNewAddress(newAddress);

        webSite.myAccountPage.assertions().assertSuccessfullyAddedNewAddress();
        webSite.newAddressBookPage.assertUrlPage();
    }

    @Test
    public void checkMyOrderHistory_When_AuthenticatedUserPurchasesProduct() {
        var billingDetails = CustomerFactory.GenerateBillingAddress();
        var personalInformation = CustomerFactory.GenerateRegisterAccount();

        webSite.checkoutPage.navigate();
        webSite.mainHeader.addProductToCard(IPodShuffleProduct());
        webSite.checkoutPage.navigate();
        webSite.checkoutPage.fillBillingNewUserDetails(personalInformation);
        webSite.checkoutPage.fillBillingAddress(billingDetails);
        webSite.checkoutPage.proceedToCheckout();
        webSite.checkoutPage.confirmOrder();

        webSite.checkoutPage.assertions().assertSuccessfullyCheckoutOrder();

        webSite.myAccountPage.proceedToOrderHistorySection();

        webSite.myAccountPage.assertions().assertCustomerNameCorrect(personalInformation);
        webSite.myAccountPage.assertions().assertThePurchaseDateToday();
    }

    @Test
    public void returnProduct_When_AuthenticatedUser_FillsReturnForm() {
        var loginUser = CustomerFactory.loginUser(EMAIL_ADDRESS, PASSWORD);

        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);
        webSite.myAccountPage.proceedToReturnOrderSection();

        webSite.returnProductPage.assertUrlPage();

        webSite.myAccountPage.fillReturnProductForm(iPodNano());

        webSite.successfulReturnProductPage.assertUrlPage();
        webSite.myAccountPage.assertions().assertProductReturnsMessage(PRODUCT_RETURNS_MESSAGE);
    }
}