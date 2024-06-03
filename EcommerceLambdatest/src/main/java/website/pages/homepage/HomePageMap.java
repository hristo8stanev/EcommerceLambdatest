package website.pages.homepage;

import core.basemap.BaseMap;
import enums.ShopCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class HomePageMap extends BaseMap {

    public WebElement specialOfferTitleField() {
        return waitAndFindElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@href),'product/special')]"));
    }

    public WebElement specialOffersHeader() {
        return waitAndFindElement(By.xpath("//div[@id='product-special']//h1"));
    }

    public WebElement blogArticleTitleField() {
        return waitAndFindElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@href),'blog/home')]"));
    }

    public WebElement latestArticles() {
        return waitAndFindElement(By.xpath("//div[@id='blog-home']//h3"));
    }

    public WebElement myAccountSection() {
        return waitAndFindElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@href),'account/account')]"));
    }

    public WebElement emailInput() {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[@id='input-email']"));
    }

    public WebElement passwordInput() {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[@id='input-password']"));
    }

    public WebElement loginButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@type),'submit')]"));
    }

    public WebElement shopByCategory() {
        return waitAndFindElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@aria-label),'Shop by Category')]"));
    }

    public WebElement category(ShopCategory shopCategory) {
        return waitAndFindElement(By.xpath
                ("//ul[contains(normalize-space(@class),'navbar-nav vertica')]//div//span[contains(normalize-space(@class),'title') and contains(text(),'" + shopCategory.getCategory() + "')]"));
    }

    public WebElement categoryHeader() {
        return waitAndFindElement(By.xpath("//div[@id='product-category']//h1"));
    }
}