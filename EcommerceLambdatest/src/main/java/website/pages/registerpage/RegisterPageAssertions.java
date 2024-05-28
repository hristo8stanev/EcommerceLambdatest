package website.pages.registerpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class RegisterPageAssertions extends BaseAssertions<RegisterPageMap> {

    public void assertLogoutButtonIsDisplayed() {
        var logoutButtonMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ERROR_MESSAGE_LOGOUT_BUTTON, !elementsT().logoutButton().isDisplayed(), elementsT().logoutButton().isDisplayed());
        Assertions.assertTrue(elementsT().logoutButton().isDisplayed(), ERROR_MESSAGE_LOGOUT_BUTTON);
    }

    public void assertErrorMessageFirstName() {
        var errorMessagePassword = String.format("%s \n Actual Result: %s \n Expected Result: %s", SUCCESSFULLY_LOGIN, elementsT().errorMessageEmptyFirstNameField().getText(),
                ERROR_MESSAGE_EMPTY_FIRST_NAME);

        Assertions.assertEquals(elementsT().errorMessageEmptyFirstNameField().getText(), ERROR_MESSAGE_EMPTY_FIRST_NAME, errorMessagePassword);
    }

    public void assertErrorMessageMessageEmailAddress() {
        var errorMessageEmailAddress = String.format("%s \n Actual Result: %s \n Expected Result: %s", SUCCESSFULLY_LOGIN, elementsT().errorMessageEmptyEmailAddressField().getText(),
                ERROR_MESSAGE_EMPTY_EMAIL_ADDRESS);

        Assertions.assertEquals(elementsT().errorMessageEmptyEmailAddressField().getText(), ERROR_MESSAGE_EMPTY_EMAIL_ADDRESS, errorMessageEmailAddress);
    }

    public void assertErrorMessagePassword() {
        var errorMessagePassword = String.format("%s \n Actual Result: %s \n Expected Result: %s", SUCCESSFULLY_LOGIN, elementsT().errorMessageEmptyPasswordField().getText(),
                ERROR_MESSAGE_EMPTY_PASSWORD);

        Assertions.assertEquals(elementsT().errorMessageEmptyPasswordField().getText(), ERROR_MESSAGE_EMPTY_PASSWORD, errorMessagePassword);
    }
}