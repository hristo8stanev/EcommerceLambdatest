package pages.registerpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseMap.BaseMap;


public class RegisterPageMap extends BaseMap<RegisterPageMap> {

    public RegisterPageMap(WebDriver driver) {
        super(driver);
        addElement("firstNameInput", () -> waitAndFindElement(By.id("input-firstname")));
        addElement("lastNameInput", () -> waitAndFindElement(By.id("input-lastname")));
        addElement("emailAddressInput", () -> waitAndFindElement(By.id("input-email")));
        addElement("telephoneInput", () -> waitAndFindElement(By.id("input-telephone")));
        addElement("passwordInput", () -> waitAndFindElement(By.id("input-password")));
        addElement("confirmPasswordInput", () -> waitAndFindElement(By.id("input-confirm")));
        addElement("agreePrivacy", () -> waitAndFindElement(By.xpath("//div[@id='content']//label[contains(normalize-space(@for),'input-agree')]")));
        addElement("continueButton", () -> waitAndFindElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@type),'submit')]")));
        addElement("logoutButton", () -> waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/logout')]")));
        addElement("errorMessageEmptyFirstNameField", () -> waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]")));
        addElement("errorMessageEmptyEmailAddressField", () -> waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]")));
        addElement("errorMessageEmptyPasswordField", () -> waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'text-danger')]")));
    }
}