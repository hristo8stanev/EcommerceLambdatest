package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.baseelements.BaseMap;

import java.util.function.Supplier;

public class HomepageMap extends BaseMap {

    public Supplier<WebElement> myAccount = () -> waitAndFindElement(By.xpath("//ul[@class='navbar-nav horizontal']//a[contains(@href, 'account/account')]"));
    public Supplier<WebElement> registerButton = () -> waitAndFindElement(By.xpath("//div[@id='main-navigation']//a[contains(@href, 'account/register')]//following-sibling::span"));
    public Supplier<WebElement> loginButton = () -> waitAndFindElement(By.xpath("(//div[@id='main-navigation']//a[contains(@href, 'account/login')]//following-sibling::span"));
    public Supplier<WebElement> searchField = () -> waitAndFindElement(By.name("search"));
    public Supplier<WebElement> searchButton = () -> waitAndFindElement(By.xpath("//div[@id='search']//button[contains(normalize-space(@type),'submit')]"));
}
