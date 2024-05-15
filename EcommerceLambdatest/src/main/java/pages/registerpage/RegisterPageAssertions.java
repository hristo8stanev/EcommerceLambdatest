package pages.registerpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ErrorMessage;
import static constants.Constants.ErrorMessageLogoutButton;

public class RegisterPageAssertions extends BaseAssertions<RegisterPageMap> {

    public void assertLogoutButtonIsDisplayed() {
        var logoutButtonMessage = String.format("%s \n Actual Result: %s \n Expected Result: %s", ErrorMessageLogoutButton, !elementsT().logoutButton().isDisplayed(),
                elementsT().logoutButton().isDisplayed());

        Assertions.assertTrue(elementsT().logoutButton().isDisplayed(), ErrorMessageLogoutButton);
    }
}