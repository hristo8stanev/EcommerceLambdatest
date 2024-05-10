package pages.registerpage;

import org.openqa.selenium.WebDriver;
import pages.basepage.WebPage;

import static urls.Urls.REGISTER_PAGE;

public class RegisterPage extends WebPage {

    private final RegisterPageMap registerPageMap;
    private final RegisterPageAssertions registerPageAssertions;

    public RegisterPage(WebDriver driver) {
        super(driver, REGISTER_PAGE);
        this.registerPageMap = new RegisterPageMap(driver);
        this.registerPageAssertions = new RegisterPageAssertions(driver);
    }

    @Override
    protected String Url() {
        return REGISTER_PAGE;
    }

    public RegisterPageMap getMap() {
        return registerPageMap;
    }

    public RegisterPageAssertions getAssertions() {
        return registerPageAssertions;
    }

    // Example methods that use RegisterPageMap
    public void enterFirstName(String firstName) {
        registerPageMap.firstNameInput.get().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        registerPageMap.lastNameInput.get().sendKeys(lastName);
    }

    // Example methods that use RegisterPageAssertions
    public void assertFirstNameInputVisible() {
        registerPageAssertions.assertFirstNameInputIsVisible();
    }

    public void assertErrorMessageIsDisplayed(String elementName) {
        registerPageAssertions.assertErrorMessageIsDisplayed(elementName);
    }
}