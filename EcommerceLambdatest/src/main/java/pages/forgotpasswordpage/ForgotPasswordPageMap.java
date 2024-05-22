package pages.forgotpasswordpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageMap extends BaseMap {
    public WebElement forgotPasswordButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/forgotten')]"));
    }

    public WebElement emailAddress() {
        return waitAndFindElement(By.name("email"));
    }

    public WebElement confirmationMessage() {
        return waitAndFindElement(By.xpath("//div[@id='account-login']//div[contains(normalize-space(@class), 'alert alert-success')]"));
    }

    public WebElement warningMessage() {
        return waitAndFindElement(By.xpath("//div[@id='account-forgotten']//div[contains(normalize-space(@class), 'alert alert-danger alert-dismissible')]"));
    }

    public WebElement continueButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//button[contains(normalize-space(@type),'submit')]"));
    }
}