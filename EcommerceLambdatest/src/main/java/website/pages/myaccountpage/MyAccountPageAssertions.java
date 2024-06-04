package website.pages.myaccountpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import website.pages.cartpage.CheckoutInformation;
import website.pages.registerpage.PersonalInformation;

import java.text.NumberFormat;

import static utils.currency.Currency.*;
import static constants.Constants.*;

public class MyAccountPageAssertions extends BaseAssertions<MyAccountPageMap> {

    public void assertAccountInformationIsSuccessfullyUpdated() {
        var expectedResult = SUCCESSFULLY_ACCOUNT_INFORMATION_UPDATED_MESSAGE;
        var actualResult = elementsT().successfullyMessage().getText();
        var successfullyUpdatedAccountInfoMessage = formatMessage(ERROR_MESSAGE_PASSWORD, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, successfullyUpdatedAccountInfoMessage);
    }

    public void assertPasswordSuccessfullyChanged() {
        var expectedResult = SUCCESSFULLY_PASSWORD_MESSAGE;
        var actualResult = elementsT().successfullyMessage().getText();
        var successfullyChangePasswordMessage = formatMessage(ERROR_MESSAGE_PASSWORD, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, successfullyChangePasswordMessage);
    }

    public void assertSuccessfullyPurchaseGiftCertificate() {
        var expectedResult = elementsT().successfullyPurchaseCertificate().getText();
        var actualResult = SUCCESSFULLY_PURCHASE_VOUCHER_MESSAGE;
        var successfullyPurchaseGiftCertificateMessage = formatMessage(ERROR_MESSAGE_PASSWORD, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, successfullyPurchaseGiftCertificateMessage);
    }

    public void assertSuccessfullyAddedNewAddress() {
        var expectedResult = elementsT().successfullyMessage().getText();
        var actualResult = SUCCESSFULLY_ADDED_NEW_ADDRESS_MESSAGE;
        var successfullyChangePasswordMessage = formatMessage(ERROR_MESSAGE_ADDRESS, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, successfullyChangePasswordMessage);
    }

    public void assertCustomerNameCorrect(PersonalInformation user) {
        var expectedResult = user.getFirstName() + " " + user.getLastName();
        var actualResult = elementsT().customerElement(expectedResult).getText();
        var customerNameMessage = formatMessage(ERROR_MESSAGE_ADDRESS, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, customerNameMessage);
    }

    public void assertTotalPrice(CheckoutInformation checkoutInformation) {
        NumberFormat currencyFormat = getDollarFormat();
        var expectedTotalFormatted = currencyFormat.format(checkoutInformation.getTotal());
        var actualTotalFormatted = elementsT().totalPrice(String.valueOf(checkoutInformation.getTotal())).getText();
        Assertions.assertEquals(expectedTotalFormatted, actualTotalFormatted, ERROR_MESSAGE_PRICE);
    }

    public void assertGiftCertificateAddedToShoppingCart(PurchaseGiftCertificate purchaseGiftCertificate) {
        var actualResult = elementsT().giftPriceNameElement(purchaseGiftCertificate.getAmount(), purchaseGiftCertificate.getRecipientName()).getText();
        var expectedResult = String.format("$%s.00 Gift Certificate for %s", purchaseGiftCertificate.getAmount(), purchaseGiftCertificate.getRecipientName());
        var successfullyGiftCertificateAddedToShoppingCartMessage = formatMessage(ERROR_MESSAGE_ADDRESS, actualResult, expectedResult);
        Assertions.assertEquals(expectedResult, actualResult, successfullyGiftCertificateAddedToShoppingCartMessage);
    }

    public void assertGiftCertificateRemoved(PurchaseGiftCertificate giftName) {
        var errorMessageRemovedProduct = String.format("The gift for %s is still present in the Shopping Cart.", giftName.getRecipientName());
        var actualResult = YOUR_SHOPPING_CART_IS_EMPTY;
        var expectedResult = elementsT().removedProduct(actualResult);
        var giftCertificateMessage = formatMessage(errorMessageRemovedProduct, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(elementsT().removedProduct(actualResult).getText().contains(actualResult), giftCertificateMessage);
    }
}