package pages.registerpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMap.BaseMap;

import java.util.function.Supplier;

public class RegisterPageMap extends BaseMap {

    public RegisterPageMap(WebDriver driver) {
        super(driver);
    }
     public Supplier<WebElement> firstNameInput = () -> waitAndFindElement(By.id("input-firstname"));
     public Supplier<WebElement> lastNameInput = () -> waitAndFindElement(By.id("input-lastname"));
     public Supplier<WebElement> emailAddressNameInput = () -> waitAndFindElement(By.id("input-email"));
     public Supplier<WebElement> telephoneInput = () -> waitAndFindElement(By.id("input-telephone"));
     public Supplier<WebElement> passwordInput = () -> waitAndFindElement(By.id("input-password"));
     public Supplier<WebElement> confirmPasswordInput = () -> waitAndFindElement(By.id("input-confirm"));
     public Supplier<WebElement> agreePrivacy = () -> waitAndFindElement(By.xpath("//div[@id='content']//label[contains(normalize-space(@for),'input-agree')]"));
     public Supplier<WebElement> oontinueButton = () -> waitAndFindElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@type),'submit')]"));
     public Supplier<WebElement> logoutButton = () -> waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/logout')]"));
     public Supplier<WebElement> errorMessageEmptyFistNameField = () -> waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
     public Supplier<WebElement> errorMessageEmptyEmailAddressField = () -> waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
     public Supplier<WebElement> errorMessageEmptyPasswordField = () -> waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
}