package website.pages.registerpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPageMap extends BaseMap {

    public WebElement firstNameInput() {
        return waitAndFindElement(By.id("input-firstname"));
    }

    public WebElement lastNameInput() {
        return waitAndFindElement(By.id("input-lastname"));
    }

    public WebElement emailAddressInput() {
        return waitAndFindElement(By.id("input-email"));
    }

    public WebElement telephoneInput() {
        return waitAndFindElement(By.id("input-telephone"));
    }

    public WebElement passwordInput() {
        return waitAndFindElement(By.id("input-password"));
    }

    public WebElement confirmPasswordInput() {
        return waitAndFindElement(By.id("input-confirm"));
    }

    public WebElement agreePrivacy() {
        return waitAndFindElement(By.xpath("//div[@id='content']//label[contains(normalize-space(@for),'input-agree')]"));
    }

    public WebElement continueButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@type),'submit')]"));
    }

    public WebElement logoutButton() {
        return waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/logout')]"));
    }

    public WebElement errorMessageEmptyFirstNameField() {
        return waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
    }

    public WebElement errorMessageEmptyEmailAddressField() {
        return waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
    }

    public WebElement errorMessageEmptyPasswordField() {
        return waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
    }
}