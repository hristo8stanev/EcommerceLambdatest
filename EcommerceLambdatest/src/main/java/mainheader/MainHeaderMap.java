package mainheader;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.productpage.ProductDetails;

public class MainHeaderMap extends BaseMap {

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

    public WebElement findProduct(int productId) {
        return waitAndFindElement(By.xpath("//div[@id='product-search']//a[contains(@href, 'product_id=" + productId + "')]"));
    }

    public WebElement quantityInput() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//input[contains(normalize-space(@name), 'quantity')]"));
    }

    public WebElement addToCartButton() {
        return waitAndFindElement(By.xpath("//div[@class='content']//button[contains(text(),'Add to Cart')]"));
    }

    public WebElement searchButton() {
        return waitAndFindElement(By.xpath("//div[@id='search']//button[contains(normalize-space(@type),'submit')]"));
    }
}
