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
        elements().firstNameInput().clear();
        elements().firstNameInput().sendKeys(user.firstName);
        elements().lastNameInput().clear();
        elements().lastNameInput().sendKeys(user.lastName);
        elements().emailAddressNameInput().clear();
        elements().emailAddressNameInput().sendKeys(EMAIL_ADDRESS);
        elements().telephoneInput().clear();
        elements().telephoneInput().sendKeys(user.telephone);
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
        elements().firstNameInput().sendKeys(billingInformation.firstName);
        elements().lastNameInput().sendKeys(billingInformation.lastName);
        elements().companyInput().sendKeys(billingInformation.company);
        elements().addressInput1().sendKeys(billingInformation.address1);
        elements().addressInput2().sendKeys(billingInformation.address2);
        elements().cityInput().sendKeys(billingInformation.city);
        elements().postCodeInput().sendKeys(billingInformation.postCode);
        elements().country(billingInformation.country);
        elements().waitForAjax();
        elements().findRegionOption(billingInformation.region).click();
        elements().continueButton().click();
    }

    public void changeMyPassword() {
        elements().changeMyPasswordButton().click();
        elements().passwordInput().sendKeys(PASSWORD);
        elements().confirmPasswordInput().sendKeys(PASSWORD);
        elements().continueButton().click();
    }

    public void purchaseGiftCertificate(PurchaseGiftCertificate gift) {
        elements().recipientNameInput().clear();
        elements().recipientNameInput().sendKeys(gift.recipientName);
        elements().recipientEmailInput().clear();
        elements().recipientEmailInput().sendKeys(gift.recipientEmail);
        elements().yourNameInput().clear();
        elements().yourNameInput().sendKeys(gift.yourName);
        elements().yourEmailInput().clear();
        elements().yourEmailInput().sendKeys(gift.yourEmail);
        selectGiftType(GiftCertificateType.BIRTHDAY);
        elements().amountCertificateInput().clear();
        elements().amountCertificateInput().sendKeys(gift.getAmount());
        elements().agreeGiftCertificate().click();
        elements().continueButton().click();
    }

    public void fillReturnProductForm(ProductDetails product) {
        elements().orderIdInput().sendKeys(String.valueOf(product.getId()));
        elements().orderDateInput().sendKeys(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        elements().productNameInput().sendKeys(product.getName());
        elements().productCodeInput().sendKeys(product.getModel());
        elements().productQuantityInput().clear();
        elements().productQuantityInput().sendKeys(product.getQuantity());
        selectReasonType(ReasonType.DEAD_ON_ARRIVAL);
        selectIsProductOpened(ProductOpened.YES);
        elements().submitButton().click();
    }
}




