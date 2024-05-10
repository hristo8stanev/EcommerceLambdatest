package pages.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.baseelements.BaseMap;

import java.util.function.Supplier;

public class LoginPageMap extends BaseMap {
    public LoginPageMap(WebDriver driver) {
        super(driver);
    }

    public Supplier<WebElement> emailAddressInput = () -> waitAndFindElement(By.id("input-email"));
    public Supplier<WebElement> passwordInput = () -> waitAndFindElement(By.id("input-password"));
    public Supplier<WebElement> loginButton = () -> waitAndFindElement(By.xpath("//*[@value='Login']"));
    public Supplier<WebElement> myAccountNavigationBarElement = () -> waitAndFindElement(By.xpath("//ul[@class='navbar-nav horizontal']//a[contains(@href, 'account/account')]"));
    public Supplier<WebElement> logoutButton = () -> waitAndFindElement(By.xpath("//div[@id='account-account']//a[contains(normalize-space(@href),'account/logout')]"));
    public Supplier<WebElement> forgotPasswordButton = () -> waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/forgotten')]"));
    public Supplier<WebElement> emailAddress = () -> waitAndFindElement(By.name("email"));
    public Supplier<WebElement> continueButton = () -> waitAndFindElement(By.xpath("//div[@id='content']//button[contains(normalize-space(@type),'submit')]"));
    public Supplier<WebElement> confirmationMessage = () -> waitAndFindElement(By.xpath("//div[@id='account-login']//div[contains(normalize-space(@class), 'alert alert-success')]"));
    public Supplier<WebElement> warningMessage = () -> waitAndFindElement(By.xpath("//div[@id='account-login']//div[contains(normalize-space(@class), 'alert alert-danger')]"));
    public Supplier<WebElement> accountLogout = () -> waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
}
