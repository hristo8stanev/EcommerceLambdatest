package pages.myaccountpage;

import core.basepage.WebPage;
import enums.GiftCertificateType;
import enums.ProductOpened;
import enums.ReasonType;
import pages.cartpage.BillingInformation;
import pages.productpage.ProductDetails;
import pages.registerpage.PersonalInformation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static constants.Constants.*;
import static urls.Urls.ACCOUNT_PAGE;

public class MyAccountPage extends WebPage<MyAccountPageMap, MyAccountPageAssertions> {

    @Override
    protected String Url() {
        return ACCOUNT_PAGE;
    }

    public void selectGiftType(GiftCertificateType giftCertificateType) {
        elements().waitForAjax();
        elements().giftCertificateTheme(giftCertificateType).click();
    }

    public void selectReasonType(ReasonType reasonType) {
        elements().waitForAjax();
        elements().returnReasonInput(reasonType).click();
    }

    public void selectIsProductOpened(ProductOpened reasonId) {
        elements().waitForAjax();
        elements().productOpenedInput(reasonId).click();
    }

    public void changeMyAccountInformation(PersonalInformation user) {
        elements().editMyAccountButton().click();
        elements().typeText(elements().firstNameInput(), user.firstName);
        elements().typeText(elements().lastNameInput(), user.lastName);
        elements().typeText(elements().emailAddressNameInput(), EMAIL_ADDRESS);
        elements().typeText(elements().telephoneInput(), user.telephone);
        elements().continueButton().click();
    }

    public void proceedToAddressBookSection() {
        elements().addressBookButton().click();
        elements().newAddressButton().click();
        elements().waitForAjax();
    }

    public void proceedToMyVoucherSection() {
        elements().hover(elements().myAccountMenuSection());
        elements().myVoucherButton().click();
        elements().waitForAjax();
    }

    public void proceedToOrderHistorySection() {
        elements().myAccountMenuSection().click();
        elements().myOrderHistoryButton().click();
        elements().waitForAjax();
    }

    public void proceedToReturnOrderSection() {
        elements().hover(elements().myAccountMenuSection());
        elements().returnOrderButton().click();
        elements().waitForAjax();
    }

    public void removeProductFromCart() {
        elements().waitForAjax();
        elements().removeButton().click();
    }

    public void addNewAddress(BillingInformation billingInformation) {
        elements().typeText(elements().firstNameInput(), billingInformation.firstName);
        elements().typeText(elements().lastNameInput(), billingInformation.lastName);
        elements().typeText(elements().companyInput(), billingInformation.company);
        elements().typeText(elements().addressInput1(), billingInformation.address1);
        elements().typeText(elements().addressInput2(), billingInformation.address2);
        elements().typeText(elements().cityInput(), billingInformation.city);
        elements().typeText(elements().postCodeInput(), billingInformation.postCode);
        elements().country(billingInformation.country);
        elements().waitForAjax();
        elements().findRegionOption(billingInformation.region).click();
        elements().continueButton().click();
    }

    public void changeMyPassword() {
        elements().changeMyPasswordButton().click();
        elements().typeText(elements().passwordInput(), PASSWORD);
        elements().typeText(elements().confirmPasswordInput(), PASSWORD);
        elements().continueButton().click();
    }

    public void purchaseGiftCertificate(PurchaseGiftCertificate gift) {
        elements().typeText(elements().recipientNameInput(), gift.recipientName);
        elements().typeText(elements().recipientEmailInput(), gift.recipientEmail);
        elements().typeText(elements().yourNameInput(), gift.yourName);
        elements().typeText(elements().yourEmailInput(), gift.yourEmail);
        selectGiftType(GiftCertificateType.BIRTHDAY);
        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
        elements().agreeGiftCertificate().click();
        elements().continueButton().click();
    }

    public void fillReturnProductForm(ProductDetails product) {
        elements().typeText(elements().orderIdInput(), String.valueOf(product.getId()));
        elements().typeText(elements().orderDateInput(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        elements().typeText(elements().productNameInput(), product.getName());
        elements().typeText(elements().productCodeInput(), product.getModel());
        elements().typeText(elements().productQuantityInput(), product.getQuantity());
        selectReasonType(ReasonType.DEAD_ON_ARRIVAL);
        selectIsProductOpened(ProductOpened.YES);
        elements().submitButton().click();
    }
}