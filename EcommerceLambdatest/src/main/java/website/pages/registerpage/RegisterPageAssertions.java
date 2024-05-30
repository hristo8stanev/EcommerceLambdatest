package website.pages.registerpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class RegisterPageAssertions extends BaseAssertions<RegisterPageMap> {

    public void assertLogoutButtonIsDisplayed() {
        boolean isLogoutButtonDisplayed = elementsT().logoutButton().isDisplayed();
        var logoutButtonMessage = formatMessage(ERROR_MESSAGE_LOGOUT_BUTTON, String.valueOf(!elementsT().logoutButton().isDisplayed()), String.valueOf(isLogoutButtonDisplayed));
        Assertions.assertTrue(elementsT().logoutButton().isDisplayed(), ERROR_MESSAGE_LOGOUT_BUTTON);
    }

    public void assertErrorMessageFirstName() {
        var errorMessagePassword = formatMessage(SUCCESSFULLY_LOGIN, elementsT().errorMessageEmptyFirstNameField().getText(), ERROR_MESSAGE_EMPTY_FIRST_NAME);
        Assertions.assertEquals(elementsT().errorMessageEmptyFirstNameField().getText(), ERROR_MESSAGE_EMPTY_FIRST_NAME, errorMessagePassword);
    }

    public void assertErrorMessageMessageEmailAddress() {
        var errorMessageEmailAddress = formatMessage(SUCCESSFULLY_LOGIN, elementsT().errorMessageEmptyEmailAddressField().getText(), ERROR_MESSAGE_EMPTY_EMAIL_ADDRESS);
        Assertions.assertEquals(elementsT().errorMessageEmptyEmailAddressField().getText(), ERROR_MESSAGE_EMPTY_EMAIL_ADDRESS, errorMessageEmailAddress);
    }

    public void assertErrorMessagePassword() {
        var errorMessagePassword = formatMessage(SUCCESSFULLY_LOGIN, elementsT().errorMessageEmptyPasswordField().getText(), ERROR_MESSAGE_EMPTY_PASSWORD);
        Assertions.assertEquals(elementsT().errorMessageEmptyPasswordField().getText(), ERROR_MESSAGE_EMPTY_PASSWORD, errorMessagePassword);
    }
}