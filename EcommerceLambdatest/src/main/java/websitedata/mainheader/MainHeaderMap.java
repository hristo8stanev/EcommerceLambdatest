package websitedata.mainheader;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainHeaderMap extends BaseMap {

    public WebElement compareButton() {
        return waitAndFindElement(By.partialLinkText("Product Compare"));
    }

    public WebElement wishListButton() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//button[contains(normalize-space(@title),'Add to Wish List')]"));
    }

    public WebElement compareProductButton() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//button[contains(normalize-space(@class), 'btn-compare')]"));
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
