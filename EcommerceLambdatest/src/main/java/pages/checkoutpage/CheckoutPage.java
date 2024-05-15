package pages.checkoutpage;

import core.basepage.WebPage;
import enums.DifferentAccountType;
import org.openqa.selenium.By;
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
        elements().firstNameInput().sendKeys(user.firstName);
        elements().lastNameInput().sendKeys(user.lastName);
        elements().emailPaymentInput().sendKeys(user.email);
        elements().telephonePaymentInput().sendKeys(user.telephone);
        if (elements().passwordPaymentInput().isDisplayed()) {
            elements().passwordPaymentInput().sendKeys(user.password);
            elements().confirmPasswordPaymentInput().sendKeys(user.confirmPassword);
        }
        if (elements().agreePrivacy().isDisplayed()) {
            elements().scrollToVisible(elements().agreePrivacy());
            elements().agreePrivacy().click();
        }
    }

    private void selectAccountType(DifferentAccountType accountType) {
        switch (accountType) {
            case LOGIN:
                elements().loginAccountType().click();
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
}