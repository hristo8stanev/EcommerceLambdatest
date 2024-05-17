package pages.myaccountpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import pages.registerpage.PersonalInformation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static constants.Constants.*;

public class MyAccountPageAssertions extends BaseAssertions<MyAccountPageMap> {

    public void assertAccountInformationIsSuccessfullyUpdated() {
        var successfullyUpdatedAccountInfoMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessagePassword,
                SuccessfullyAccountInformationUpdatedMessage, elementsT().successfullyMessage().getText());

        Assertions.assertEquals(SuccessfullyAccountInformationUpdatedMessage, elementsT().successfullyMessage().getText(), successfullyUpdatedAccountInfoMessage);
    }

    public void assertPasswordSuccessfullyChanged() {
        var successfullyChangePasswordMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessagePassword,
                SuccessfullyPasswordMessage, elementsT().successfullyMessage().getText());

        Assertions.assertEquals(SuccessfullyPasswordMessage, elementsT().successfullyMessage().getText(), successfullyChangePasswordMessage);
    }

    public void assertSuccessfullyPurchaseGiftCertificate() {
        var successfullyPurchaseGiftCertificateMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessagePassword,
                elementsT().successfullyPurchaseCertificate().getText(), SuccessfullyPurchaseVoucherMessage);
        Assertions.assertEquals(elementsT().successfullyPurchaseCertificate().getText(), SuccessfullyPurchaseVoucherMessage, successfullyPurchaseGiftCertificateMessage);
    }

    public void assertSuccessfullyAddedNewAddress() {
        var successfullyChangePasswordMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessageAddress, SuccessfullyAddedNewAddressMessage,
                elementsT().successfullyMessage().getText());
        Assertions.assertEquals(SuccessfullyAddedNewAddressMessage, elementsT().successfullyMessage().getText(), successfullyChangePasswordMessage);
    }

    public void assertCustomerNameCorrect(PersonalInformation user) {

        var expectedFullName = user.getFirstName() + " " + user.getLastName();
        var actualFullName = elementsT().customerElement(expectedFullName).getText();
        var customerNameMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageAddress, actualFullName, expectedFullName);
        Assertions.assertEquals(actualFullName, expectedFullName, customerNameMessage);
    }

    public void assertThePurchaseDateToday() {
        var currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var actualDate = elementsT().dateTimeElement(currentDate).getText();
        var dateMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s",
                ErrorMessageDate, actualDate, currentDate);
        Assertions.assertEquals(actualDate, currentDate, dateMessage);
}

public void assertGiftCertificateAddedToShoppingCart(PurchaseGiftCertificate purchaseGiftCertificate) {
    var actualResult = elementsT().giftPriceNameElement(purchaseGiftCertificate.getAmount(), purchaseGiftCertificate.getRecipientName()).getText();
    String expectedResult = String.format("$%s.00 Gift Certificate for %s", purchaseGiftCertificate.getAmount(), purchaseGiftCertificate.getRecipientName());
    var successfullyGiftCertificateAddedToShoppingCartMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessageAddress, actualResult, expectedResult);
    Assertions.assertEquals(expectedResult, actualResult, successfullyGiftCertificateAddedToShoppingCartMessage);
}

public void assertGiftCertificateRemoved(PurchaseGiftCertificate giftName) {
    var errorMessageRemovedProduct = String.format("The gift for %s is still present in the Shopping Cart.", giftName.getRecipientName());
    var expectedMessage = "Your shopping cart is empty!";
    var giftCertificateMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", errorMessageRemovedProduct, elementsT().removedProduct(expectedMessage), expectedMessage);

    Assertions.assertTrue(elementsT().removedProduct(expectedMessage).getText().contains(expectedMessage), giftCertificateMessage);
}

public void assertProductReturnsMessage(String expectedMessage) {
    var returnProductMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessageReturns, ProductReturnsMessage, elementsT().successfullyProductReturn(expectedMessage).getText());
    Assertions.assertEquals(elementsT().successfullyProductReturn(expectedMessage).getText(), ProductReturnsMessage, returnProductMessage);
}
}
