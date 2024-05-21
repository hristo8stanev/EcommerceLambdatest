package pages.checkoutpage;

import core.basepage.WebPage;
import enums.AccountType;
import pages.cartpage.BillingInformation;
import pages.registerpage.PersonalInformation;

import static urls.Urls.CHECKOUT_PAGE;

public class CheckoutPage extends WebPage<CheckoutPageMap, CheckoutPageAssertions> {

    @Override
    protected String Url() {
        return CHECKOUT_PAGE;
    }

    public void fillUserDetails(BillingInformation billingInformation) {
        if (elements().newAddressLabel().isDisplayed()) {
            elements().newAddressLabel().click();
        }
        elements().firstNameInput().sendKeys(billingInformation.firstName);
        elements().lastNameInput().sendKeys(billingInformation.lastName);
        elements().companyInput().sendKeys(billingInformation.company);
        elements().addressField1().sendKeys(billingInformation.address1);
        elements().addressField2().sendKeys(billingInformation.address2);
        elements().cityInput().sendKeys(billingInformation.city);
        elements().postCodeInput().sendKeys(billingInformation.postCode);
        elements().country(billingInformation.country).click();
        elements().waitForAjax();
        elements().region(billingInformation.region).click();
    }

    public void fillBillingAddress(BillingInformation billingInformation) {
        elements().scrollToVisible(elements().companyInput());
        elements().companyInput().sendKeys(billingInformation.company);
        elements().addressField1().sendKeys(billingInformation.address1);
        elements().addressField2().sendKeys(billingInformation.address2);
        elements().cityInput().sendKeys(billingInformation.city);
        elements().postCodeInput().sendKeys(billingInformation.postCode);
        elements().country(billingInformation.country).click();
        elements().waitForAjax();
        elements().region(billingInformation.region).click();
    }

    public void fillBillingNewUserDetails(PersonalInformation user) {
        selectAccount(user.getAccountType());
        elements().typeText(elements().firstNameInput(), user.firstName);
        elements().typeText(elements().lastNameInput(), user.lastName);
        elements().typeText(elements().emailPaymentInput(), user.email);
        elements().typeText(elements().telephonePaymentInput(), user.telephone);

        if (!(user.password == null || user.password.isEmpty())) {

            elements().typeText(elements().passwordPaymentInput(), user.password);
            elements().typeText(elements().confirmPasswordPaymentInput(), user.password);
        }

        if (user.getAccountType() == AccountType.REGISTER) {
            agreePrivacyTerms();
        }
    }

    public void selectAccount(AccountType accountType) {
        elements().waitForAjax();
        elements().accountType(accountType).click();
    }

    public void loginUser(PersonalInformation user) {
        selectAccount(user.getAccountType());
        elements().typeText(elements().emailInput(), user.email);
        elements().typeText(elements().passwordInput(), user.password);
        elements().loginButton().click();
        elements().waitForAjax();
    }

    public void proceedToCheckout() {
        elements().scrollToVisible(elements().agreeTerms());
        elements().agreeTerms().click();
        elements().waitForAjax();
        elements().continueButton().click();
        elements().confirmOrderButton();
    }

    public void confirmOrder() {
        elements().confirmOrderButton().click();
    }

    private void agreePrivacyTerms() {
        elements().waitForAjax();
        elements().scrollToVisible(elements().privacyPolicy());
        elements().privacyPolicy().click();
    }
}