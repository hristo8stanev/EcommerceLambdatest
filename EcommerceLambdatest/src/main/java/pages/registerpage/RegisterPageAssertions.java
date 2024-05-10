package pages.registerpage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageAssertions {

    private final RegisterPageMap registerPageMap;

    public RegisterPageAssertions(WebDriver driver) {
        this.registerPageMap = new RegisterPageMap(driver);
    }

    public void assertFirstNameInputIsVisible() {
        WebElement firstNameInput = registerPageMap.getElement("firstNameInput").get();
        Assertions.assertTrue(firstNameInput.isDisplayed(), "First name input should be visible.");
    }

    public void assertErrorMessageIsDisplayed(String elementName) {
        WebElement errorElement = registerPageMap.getElement(elementName).get();
        Assertions.assertTrue(errorElement.isDisplayed(), "Error message for " + elementName + " should be visible.");
    }
}

