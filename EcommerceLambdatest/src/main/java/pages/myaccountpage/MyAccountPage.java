package pages.myaccountpage;

import core.basepage.WebPage;
import enums.GiftCertificateType;
import enums.ProductOpened;
import enums.ReasonType;
import pages.cartpage.BillingInformation;
import pages.productpage.ProductDetails;
import pages.registerpage.PersonalInformation;

import static constants.Constants.*;
import static urls.Urls.ACCOUNT_PAGE;

public class MyAccountPage extends WebPage<MyAccountPageMap, MyAccountPageAssertions> {

    @Override
    protected String Url() {
        return ACCOUNT_PAGE;
    }

    public void selectGiftType(GiftCertificateType giftCertificateType) {
        switch (giftCertificateType) {
            case GiftCertificateType.GENERAL:
                elements().generalCertificate().click();
                break;

            case GiftCertificateType.BIRTHDAY:
                elements().birthdayCertificate().click();
                break;

            case GiftCertificateType.CHRISTMAS:
                elements().christmasCertificate().click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported gift certificate type " + giftCertificateType);
        }
    }

    public void selectReasonType(ReasonType reasonType) {
        switch (reasonType) {
            case ReasonType.DEAD_ON_ARRIVAL:
                elements().returnReasonInput(1).click();
                break;

            case ReasonType.FAULTY_PLEASE_SUPPLY_DETAILS:
                elements().returnReasonInput(2).click();
                break;

            case ReasonType.ORDER_ERROR:
                elements().returnReasonInput(3).click();
                break;

            case ReasonType.OTHER_PLEASE_SUPPLY_DETAILS:
                elements().returnReasonInput(4).click();
                break;

            case ReasonType.RECEIVED_WRONG_ITEM:
                elements().returnReasonInput(5).click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported reason type: " + reasonType);
        }
    }


    public void selectIsProductOpened(ProductOpened productOpened) {
        switch (productOpened) {
            case ProductOpened.YES:
                elements().productOpenedInput(1).click();
                break;

            case ProductOpened.NO:
                elements().productOpenedInput(0).click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + productOpened);
        }
    }

    public void changeMyAccountInformation(PersonalInformation user) {
        elements().editMyAccountButton().click();
        elements().firstNameInput().sendKeys(user.firstName);
        elements().lastNameInput().sendKeys(user.lastName);
        elements().emailAddressNameInput().sendKeys(user.email);
        elements().telephoneInput().sendKeys(user.telephone);
        elements().continueButton().click();
    }

    public void proceedToAddressBookSection() {
        elements().addressBookButton().click();
        elements().newAddressButton().click();
        elements().waitForAjax();
    }

    public void proceedToMyVoucherSection() {
        elements().scrollToVisible(elements().myAccountMenuSection());
        elements().myVoucherButton().click();
        elements().waitForAjax();
    }

    public void proceedToOrderHistorySection() {
        elements().myAccountMenuSection().click();
        elements().myOrderHistoryButton().click();
        elements().waitForAjax();
    }

    public void proceedToReturnOrderSection() {
        elements().scrollToVisible(elements().myAccountMenuSection());
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
        elements().passwordInput().sendKeys(Password);
        elements().confirmPasswordInput().sendKeys(Password);
        elements().continueButton().click();
    }

    public void purchaseGiftCertificate(PurchaseGiftCertificate gift) {
        elements().recipientNameInput().sendKeys(gift.recipientName);
        elements().recipientEmailInput().sendKeys(gift.recipientEmail);
        elements().yourNameInput().sendKeys(gift.yourName);
        elements().yourEmailInput().sendKeys(gift.yourEmail);
        selectGiftType(GiftCertificateType.BIRTHDAY);
        elements().amountCertificateInput().click();
        elements().agreeGiftCertificate().click();
        elements().continueButton().click();
    }

    public void fillReturnProductForm(ProductDetails product) {
        selectReasonType(ReasonType.DEAD_ON_ARRIVAL);
        elements().orderDateInput().sendKeys(product.id).toString();
        elements().orderDateInput().sendKeys(DateTime.Now.ToString("dd/MM/yyyy"));
        elements().productNameInput().sendKeys(product.name);
        elements().productCodeInput().sendKeys(product.quantity);
        elements().productQuantityInput().sendKeys(product.quantity);
        selectIsProductOpened(ProductOpened.YES);
        elements().submitButton().click();
    }
}
