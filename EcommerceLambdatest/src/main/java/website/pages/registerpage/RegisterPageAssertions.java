package website.pages.registerpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class RegisterPageAssertions extends BaseAssertions<RegisterPageMap> {

    public void assertLogoutButtonIsDisplayed() {
        boolean expectedResult = elementsT().logoutButton().isDisplayed();
        Assertions.assertTrue(expectedResult, ERROR_MESSAGE_LOGOUT_BUTTON);
    }

    public void assertErrorMessageFirstName() {
        var expectedResult = elementsT().errorMessageEmptyFirstNameField().getText();
        var actualResult = ERROR_MESSAGE_EMPTY_FIRST_NAME;
        var errorMessagePassword = formatMessage(SUCCESSFULLY_LOGIN, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, errorMessagePassword);
    }

    public void assertErrorMessageMessageEmailAddress() {
        var expectedResult = elementsT().errorMessageEmptyEmailAddressField().getText();
        var actualResult = ERROR_MESSAGE_EMPTY_EMAIL_ADDRESS;
        var errorMessageEmailAddress = formatMessage(SUCCESSFULLY_LOGIN, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, errorMessageEmailAddress);
    }

    public void assertErrorMessagePassword() {
        var expectedResult = elementsT().errorMessageEmptyPasswordField().getText();
        var actualResult = ERROR_MESSAGE_EMPTY_PASSWORD;
        var errorMessagePassword = formatMessage(SUCCESSFULLY_LOGIN, expectedResult, actualResult);
        Assertions.assertEquals(expectedResult, actualResult, errorMessagePassword);
    }
}