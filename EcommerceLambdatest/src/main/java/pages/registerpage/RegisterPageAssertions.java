package pages.registerpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class RegisterPageAssertions extends BaseAssertions<RegisterPageMap> {

    public void assertLogoutButtonIsDisplayed() {
        var logoutButtonMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessageLogoutButton, !elementsT().logoutButton().isDisplayed(), elementsT().logoutButton().isDisplayed());
        Assertions.assertTrue(elementsT().logoutButton().isDisplayed(), ErrorMessageLogoutButton);
    }

    public void assertErrorMessageFirstName() {
        var errorMessagePassword = String.format("%s \n Actual Result: %s \n Expected Result: %s", SuccessfullyLogin, elementsT().errorMessageEmptyFirstNameField().getText(),
                ErrorMessageEmptyFirstName);

        Assertions.assertEquals(elementsT().errorMessageEmptyFirstNameField().getText(), ErrorMessageEmptyFirstName, errorMessagePassword);
    }

    public void assertErrorMessageMessageEmailAddress() {
        var errorMessageEmailAddress = String.format("%s \n Actual Result: %s \n Expected Result: %s", SuccessfullyLogin, elementsT().errorMessageEmptyEmailAddressField().getText(),
                ErrorMessageEmptyEmailAddress);

        Assertions.assertEquals(elementsT().errorMessageEmptyEmailAddressField().getText(), ErrorMessageEmptyEmailAddress, errorMessageEmailAddress);
    }

    public void assertErrorMessagePassword() {
        var errorMessagePassword = String.format("%s \n Actual Result: %s \n Expected Result: %s", SuccessfullyLogin, elementsT().errorMessageEmptyPasswordField().getText(),
                ErrorMessageEmptyPassword);

        Assertions.assertEquals(elementsT().errorMessageEmptyPasswordField().getText(), ErrorMessageEmptyPassword, errorMessagePassword);
    }
}