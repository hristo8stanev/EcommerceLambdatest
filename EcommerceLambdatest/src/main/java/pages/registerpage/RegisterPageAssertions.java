package pages.registerpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.ErrorMessageLogoutButton;

public class RegisterPageAssertions extends BaseAssertions<RegisterPageMap> {

    public void AssertLogoutButtonIsDisplayed()
    {
       // var message = $"{ErrorMessageLogoutButton} \n Actual Result:{!LogoutButton.Displayed} \n Expected Result:{LogoutButton.Displayed}";
        //Assert.That(LogoutButton.Displayed, Is.True, ErrorMessageLogoutButton, message);
        Assertions.assertTrue(elementsT().logoutButton().isDisplayed(), ErrorMessageLogoutButton);
    }
}

