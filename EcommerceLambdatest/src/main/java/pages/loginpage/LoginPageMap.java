package pages.loginpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageMap extends BaseMap {
    public WebElement emailAddressInput() {
        return waitAndFindElement(By.id("input-email"));
    }

    public WebElement passwordInput() {
        return waitAndFindElement(By.id("input-password"));
    }

    public WebElement loginButton() {
        return waitAndFindElement(By.xpath("//*[@value='Login']"));
    }

    public WebElement forgotPasswordButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/forgotten')]"));
    }

    public WebElement warningMessage() {
        return waitAndFindElement(By.xpath("//div[@id='account-login']//div[contains(normalize-space(@class), 'alert alert-danger')]"));
    }

    public WebElement emailAddress() {
        return waitAndFindElement(By.name("email"));
    }

    public WebElement continueButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//button[contains(normalize-space(@type),'submit')]"));
    }
}

