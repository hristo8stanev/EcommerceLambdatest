package website.pages.myaccountpage;

import core.basepage.WebPage;
import enums.GiftCertificate;
import website.pages.cartpage.BillingInformation;
import website.pages.registerpage.PersonalInformation;

import static core.driver.Driver.*;

import static constants.Constants.*;
import static urls.Urls.ACCOUNT_PAGE;

public class MyAccountPage extends WebPage<MyAccountPageMap, MyAccountPageAssertions> {

    @Override
    protected String Url() {
        return ACCOUNT_PAGE;
    }

    public void selectGiftType(GiftCertificate giftCertificateType) {
        waitForAjax();
        elements().giftCertificateTheme(giftCertificateType).click();
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
        waitForAjax();
    }

    public void proceedToMyVoucherSection() {
        elements().hover(elements().myAccountMenuSection());
        elements().myVoucherButton().click();
        waitForAjax();
    }

    public void proceedToOrderHistorySection() {
        elements().myAccountMenuSection().click();
        elements().myOrderHistoryButton().click();
        waitForAjax();
    }

    public void proceedToReturnOrderSection() {
        elements().hover(elements().myAccountMenuSection());
        elements().returnOrderButton().click();
        waitForAjax();
    }

    public void removeProductFromCart() {
        waitForAjax();
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
        waitForAjax();
        elements().findRegionOption(billingInformation.region).click();
        elements().continueButton().click();
    }

    public void changeMyPassword() {
        elements().changeMyPasswordButton().click();
        elements().typeText(elements().passwordInput(), PASSWORD);
        elements().typeText(elements().confirmPasswordInput(), PASSWORD);
        elements().continueButton().click();
    }

    public void purchaseGiftCertificate(PurchaseGiftCertificate gift,GiftCertificate giftCertificate) {
        elements().typeText(elements().recipientNameInput(), gift.recipientName);
        elements().typeText(elements().recipientEmailInput(), gift.recipientEmail);
        elements().typeText(elements().yourNameInput(), gift.yourName);
        elements().typeText(elements().yourEmailInput(), gift.yourEmail);
        selectGiftType(giftCertificate);
        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
        elements().agreeGiftCertificate().click();
        elements().continueButton().click();
    }

}