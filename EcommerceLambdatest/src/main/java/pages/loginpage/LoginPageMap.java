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

    public WebElement myAccountNavigationBarElement() {
        return waitAndFindElement(By.xpath("//ul[@class='navbar-nav horizontal']//a[contains(@href, 'account/account')]"));
    }

    public WebElement logoutButton() {
        return waitAndFindElement(By.xpath("//div[@id='account-account']//a[contains(normalize-space(@href),'account/logout')]"));
    }

    public WebElement forgotPasswordButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/forgotten')]"));
    }

    public WebElement emailAddress() {
        return waitAndFindElement(By.name("email"));
    }

    public WebElement continueButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//button[contains(normalize-space(@type),'submit')]"));
    }

    public WebElement confirmationMessage() {
        return waitAndFindElement(By.xpath("//div[@id='account-login']//div[contains(normalize-space(@class), 'alert alert-success')]"));
    }

    public WebElement warningMessage() {
        return waitAndFindElement(By.xpath("//div[@id='account-login']//div[contains(normalize-space(@class), 'alert alert-danger')]"));
    }

    public WebElement accountLogout() {
        return waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
    }
}

