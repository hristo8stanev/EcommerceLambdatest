package pages.checkoutpage;

import core.basepage.WebPage;
import enums.DifferentAccountType;
import pages.cartpage.BillingInformation;
import pages.registerpage.PersonalInformation;

import static urls.Urls.CHECKOUT_PAGE;

public class CheckoutPage extends WebPage<CheckoutPageMap, CheckoutPageAssertions> {

    @Override
    protected String Url() {
        return CHECKOUT_PAGE;
    }

    public void fillUserDetails(BillingInformation billingInformation) {
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
        elements().firstNameInput().sendKeys(user.firstName);
        elements().lastNameInput().sendKeys(user.lastName);
        elements().emailInput().sendKeys(user.email);
        elements().telephonePaymentInput().sendKeys(user.telephone);

        if (elements().passwordPaymentInput().isDisplayed()) {
            elements().passwordPaymentInput().sendKeys(user.password);
        }

        if (elements().passwordPaymentInput().isDisplayed()) {
            elements().confirmPasswordPaymentInput().sendKeys(user.confirmPassword);
        }

        if (elements().agreePrivacy().isDisplayed()) {
            elements().agreePrivacy().click();
        }
    }

    private void selectAccountType(DifferentAccountType accountType) {
        switch (accountType) {
            case LOGIN:
                elements().loginInput().click();
                break;

            case REGISTER:
                elements().registerAccountType().click();
                break;

            case GUEST:
                elements().guestAccountType().click();
                break;

            default:
                throw new IllegalArgumentException("Unsupported account type: " + accountType);
        }
    }

    public void selectLoginAccountType() {
        selectAccountType(DifferentAccountType.LOGIN);
    }

    public void selectRegisterAccountType() {
        selectAccountType(DifferentAccountType.REGISTER);
    }

    public void selectGuestAccountType() {
        selectAccountType(DifferentAccountType.GUEST);
    }

    public void loginUser(String email, String password) {
        elements().emailInput().sendKeys(email);
        elements().passwordInput().sendKeys(password);
        elements().loginButton().click();
    }

    public void proceedToCheckout() {
        elements().agreeTerms().click();
        elements().waitForAjax();
        elements().continueButton().click();
        elements().confirmOrderButton();
    }

    public void confirmOrder() {
        elements().confirmOrderButton().click();
    }
}