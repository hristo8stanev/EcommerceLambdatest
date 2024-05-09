package pages.searchpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMap.BaseMap;

import java.util.function.Supplier;

public class SearchPageMap extends BaseMap {

    public SearchPageMap(WebDriver driver) {
        super(driver);
    }
        public Supplier<WebElement> searchInput = () -> waitAndFindElement(By.xpath("//div[@id='product-search']//input[contains(normalize-space(@id),'input-search')]"));
        public Supplier<WebElement> searchButton = () -> waitAndFindElement(By.id("button-search"));

        public Supplier<WebElement> getProductName(int id, String name) {
            return () -> waitAndFindElement(By.xpath("//h4//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + name + "']"));
        }

        public Supplier<WebElement> getProductPrice() {
            return () -> waitAndFindElement(By.xpath("//div[@id='product-search']//span[contains(normalize-space(@class),'price-new')]"));
        }

        public Supplier<WebElement> errorMessageNonExistingProduct(String message) {
            return () -> waitAndFindElement(By.xpath("//p[contains(text(),'" + message + "')]"));
        }

        public Supplier<WebElement> minPriceField = () -> waitAndFindElement(By.xpath("//div[@class='content']//input[contains(normalize-space(@placeholder), 'Minimum Price')]"));
        public Supplier<WebElement> maxPriceField = () -> waitAndFindElement(By.xpath("//div[@class='content']//input[contains(normalize-space(@placeholder), 'Maximum Price')]"));
    }
