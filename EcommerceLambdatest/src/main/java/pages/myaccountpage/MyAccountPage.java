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
        //elements().firstNameInput().clear();
        //elements().firstNameInput().sendKeys(user.firstName);

        elements().typeText(elements().lastNameInput(), user.lastName);
        // elements().lastNameInput().clear();
        // elements().lastNameInput().sendKeys(user.lastName);

        elements().typeText(elements().emailAddressNameInput(), EMAIL_ADDRESS);
        // elements().emailAddressNameInput().clear();
        // elements().emailAddressNameInput().sendKeys(EMAIL_ADDRESS);

        elements().typeText(elements().telephoneInput(), user.telephone);
        //elements().telephoneInput().clear();
        //elements().telephoneInput().sendKeys(user.telephone);

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
        //elements().firstNameInput().sendKeys(billingInformation.firstName);
        elements().typeText(elements().lastNameInput(), billingInformation.lastName);
        //elements().lastNameInput().sendKeys(billingInformation.lastName);
        elements().typeText(elements().companyInput(), billingInformation.company);
        //elements().companyInput().sendKeys(billingInformation.company);
        elements().typeText(elements().addressInput1(), billingInformation.address1);
        //elements().addressInput1().sendKeys(billingInformation.address1);
        elements().typeText(elements().addressInput2(), billingInformation.address2);
        //elements().addressInput2().sendKeys(billingInformation.address2);
        elements().typeText(elements().cityInput(), billingInformation.city);
        //elements().cityInput().sendKeys(billingInformation.city);
        elements().typeText(elements().postCodeInput(), billingInformation.postCode);
        //elements().postCodeInput().sendKeys(billingInformation.postCode);
        elements().country(billingInformation.country);
        elements().waitForAjax();
        elements().findRegionOption(billingInformation.region).click();
        elements().continueButton().click();
    }

    public void changeMyPassword() {
        elements().changeMyPasswordButton().click();
        elements().typeText(elements().passwordInput(), PASSWORD);
        //elements().passwordInput().sendKeys(PASSWORD);
        elements().typeText(elements().confirmPasswordInput(), PASSWORD);
        //elements().confirmPasswordInput().sendKeys(PASSWORD);
        elements().continueButton().click();
    }

    public void purchaseGiftCertificate(PurchaseGiftCertificate gift) {
        elements().typeText(elements().recipientNameInput(), gift.recipientName);
       // elements().recipientNameInput().clear();
       // elements().recipientNameInput().sendKeys(gift.recipientName);
        elements().typeText(elements().recipientEmailInput(), gift.recipientEmail);
        //elements().recipientEmailInput().clear();
        //elements().recipientEmailInput().sendKeys(gift.recipientEmail);
        elements().typeText(elements().yourNameInput(), gift.yourName);
        //elements().yourNameInput().clear();
        //elements().yourNameInput().sendKeys(gift.yourName);
        elements().typeText(elements().yourEmailInput(), gift.yourEmail);
        //elements().yourEmailInput().clear();
        //elements().yourEmailInput().sendKeys(gift.yourEmail);
        selectGiftType(GiftCertificateType.BIRTHDAY);
        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
       // elements().amountCertificateInput().clear();
       // elements().amountCertificateInput().sendKeys(gift.getAmount());
        elements().agreeGiftCertificate().click();
        elements().continueButton().click();
    }

    public void fillReturnProductForm(ProductDetails product) {
        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
        //elements().orderIdInput().sendKeys(String.valueOf(product.getId()));

        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
       // elements().orderDateInput().sendKeys(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
        //elements().productNameInput().sendKeys(product.getName());

        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
        //elements().productCodeInput().sendKeys(product.getModel());

        elements().typeText(elements().amountCertificateInput(), gift.getAmount());
       //elements().productQuantityInput().clear();
       //elements().productQuantityInput().sendKeys(product.getQuantity());

        selectReasonType(ReasonType.DEAD_ON_ARRIVAL);
        selectIsProductOpened(ProductOpened.YES);
        elements().submitButton().click();
    }
}