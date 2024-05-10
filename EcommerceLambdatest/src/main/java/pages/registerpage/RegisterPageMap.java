package pages.registerpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterPageMap extends BaseMap {

    public WebElement firstNameInput() {
        return browser.findElement(By.id("input-firstname"));
    }

    public WebElement lastNameInput() {
        return browser.findElement(By.id("input-lastname"));
    }

    public WebElement emailAddressInput() {
        return browser.findElement(By.id("input-email"));
    }

    public WebElement telephoneInput() {
        return browser.findElement(By.id("input-telephone"));
    }

    public WebElement passwordInput() {
        return browser.findElement(By.id("input-password"));
    }

    public WebElement confirmPasswordInput() {
        return browser.findElement(By.id("input-confirm"));
    }

    public WebElement agreePrivacy() {
        return browser.findElement(By.xpath("//div[@id='content']//label[contains(normalize-space(@for),'input-agree')]"));
    }

    public WebElement continueButton() {
        return browser.findElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@type),'submit')]"));
    }

    public WebElement logoutButton() {
        return browser.findElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/logout')]"));
    }

    public WebElement errorMessageEmptyFirstNameField() {
        return browser.findElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
    }

    public WebElement errorMessageEmptyEmailAddressField() {
        return browser.findElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
    }

    public WebElement errorMessageEmptyPasswordField() {
        return browser.findElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]"));
    }
}