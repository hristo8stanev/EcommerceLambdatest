package pages.homepage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class HomePageMap extends BaseMap {

    public WebElement myAccount() {
        return waitAndFindElement(By.xpath("//ul[@class='navbar-nav horizontal']//a[contains(@href, 'account/account')]"));
    }

    public WebElement registerButton() {
        return waitAndFindElement(By.xpath("//div[@id='main-navigation']//a[contains(@href, 'account/register')]//following-sibling::span"));
    }

    public WebElement loginButton() {
        return waitAndFindElement(By.xpath("(//div[@id='main-navigation']//a[contains(@href, 'account/login')]//following-sibling::span"));
    }

    public WebElement searchField() {
        return waitAndFindElement(By.name("search"));
    }

    public WebElement searchButton() {
        return waitAndFindElement(By.xpath("//div[@id='search']//button[contains(normalize-space(@type),'submit')]"));
    }
}