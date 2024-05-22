package pages.myaccountpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.registerpage.PersonalInformation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static constants.Constants.*;

public class MyAccountPageAssertions extends BaseAssertions<MyAccountPageMap> {

    public void assertAccountInformationIsSuccessfullyUpdated() {
        var successfullyUpdatedAccountInfoMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PASSWORD,
                SUCCESSFULLY_ACCOUNT_INFORMATION_UPDATED_MESSAGE, elementsT().successfullyMessage().getText());
        Assertions.assertEquals(SUCCESSFULLY_ACCOUNT_INFORMATION_UPDATED_MESSAGE, elementsT().successfullyMessage().getText(), successfullyUpdatedAccountInfoMessage);
    }

    public void assertPasswordSuccessfullyChanged() {
        var successfullyChangePasswordMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PASSWORD,
                SUCCESSFULLY_PASSWORD_MESSAGE, elementsT().successfullyMessage().getText());
        Assertions.assertEquals(SUCCESSFULLY_PASSWORD_MESSAGE, elementsT().successfullyMessage().getText(), successfullyChangePasswordMessage);
    }

    public void assertSuccessfullyPurchaseGiftCertificate() {
        var successfullyPurchaseGiftCertificateMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_PASSWORD,
                elementsT().successfullyPurchaseCertificate().getText(), SUCCESSFULLY_PURCHASE_VOUCHER_MESSAGE);
        Assertions.assertEquals(elementsT().successfullyPurchaseCertificate().getText(), SUCCESSFULLY_PURCHASE_VOUCHER_MESSAGE, successfullyPurchaseGiftCertificateMessage);
    }

    public void assertSuccessfullyAddedNewAddress() {
        var successfullyChangePasswordMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_ADDRESS, SUCCESSFULLY_ADDED_NEW_ADDRESS_MESSAGE,
                elementsT().successfullyMessage().getText());
        Assertions.assertEquals(SUCCESSFULLY_ADDED_NEW_ADDRESS_MESSAGE, elementsT().successfullyMessage().getText(), successfullyChangePasswordMessage);
    }

    public void assertCustomerNameCorrect(PersonalInformation user) {

        var expectedFullName = user.getFirstName() + " " + user.getLastName();
        var actualFullName = elementsT().customerElement(expectedFullName).getText();
        var customerNameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_ADDRESS, actualFullName, expectedFullName);
        Assertions.assertEquals(actualFullName, expectedFullName, customerNameMessage);
    }

    public void assertThePurchaseDateToday() {
        var currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var actualDate = elementsT().dateTimeElement(currentDate).getText();
        var dateMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_DATE, actualDate, currentDate);
        Assertions.assertEquals(actualDate, currentDate, dateMessage);
    }

    public void assertGiftCertificateAddedToShoppingCart(PurchaseGiftCertificate purchaseGiftCertificate) {
        var actualResult = elementsT().giftPriceNameElement(purchaseGiftCertificate.getAmount(), purchaseGiftCertificate.getRecipientName()).getText();
        String expectedResult = String.format("$%s.00 Gift Certificate for %s", purchaseGiftCertificate.getAmount(), purchaseGiftCertificate.getRecipientName());
        var successfullyGiftCertificateAddedToShoppingCartMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_ADDRESS, actualResult, expectedResult);
        Assertions.assertEquals(expectedResult, actualResult, successfullyGiftCertificateAddedToShoppingCartMessage);
    }

    public void assertGiftCertificateRemoved(PurchaseGiftCertificate giftName) {
        var errorMessageRemovedProduct = String.format("The gift for %s is still present in the Shopping Cart.", giftName.getRecipientName());
        var expectedMessage = "Your shopping cart is empty!";
        var giftCertificateMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", errorMessageRemovedProduct, elementsT().removedProduct(expectedMessage), expectedMessage);
        Assertions.assertTrue(elementsT().removedProduct(expectedMessage).getText().contains(expectedMessage), giftCertificateMessage);
    }
}