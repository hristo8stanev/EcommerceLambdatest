package pages.searchpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageMap extends BaseMap {
    
    public WebElement searchInput() {
        return browser.findElement(By.xpath("//div[@id='product-search']//input[contains(normalize-space(@id), 'input-search')]"));
    }

    public WebElement searchButton() {
        return browser.findElement(By.id("button-search"));
    }

    public WebElement getProductName(int id, String name) {
        return browser.findElement(By.xpath("//h4//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + name + "']"));
    }

    public WebElement getProductPrice() {
        return browser.findElement(By.xpath("//div[@id='product-search']//span[contains(normalize-space(@class), 'price-new')]"));
    }

    public WebElement errorMessageNonExistingProduct(String message) {
        return browser.findElement(By.xpath("//p[contains(text(), '" + message + "')]"));
    }

    public WebElement minPriceField() {
        return browser.findElement(By.xpath("//div[@class='content']//input[contains(normalize-space(@placeholder), 'Minimum Price')]"));
    }

    public WebElement maxPriceField() {
        return browser.findElement(By.xpath("//div[@class='content']//input[contains(normalize-space(@placeholder), 'Maximum Price')]"));
    }
}

