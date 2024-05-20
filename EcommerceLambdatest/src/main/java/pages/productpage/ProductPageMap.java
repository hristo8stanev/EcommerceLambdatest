package pages.productpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPageMap extends BaseMap {

    public WebElement removeButton() {
        return waitAndFindElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
    }

    public WebElement removeFromWishList() {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[contains(@class, 'text-right text-nowrap')]//a[contains(@href, 'account/wishlist&remove')]"));
    }

    public WebElement quantityInput() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//input[contains(normalize-space(@name), 'quantity')]"));
    }

    public WebElement addToCartButton() {
        return waitAndFindElement(By.xpath("//div[@class='content']//button[contains(text(),'Add to Cart')]"));
    }

    public WebElement proceedToCompare() {
        return waitAndFindElement(By.xpath("//*[@data-original-title='Compare']"));
    }

    public WebElement findProduct() {
        return waitAndFindElement(By.xpath("//h4/a"));
    }

    public WebElement sizeField() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//select[contains(normalize-space(@id),'input-option')]"));
    }

    public WebElement smallSize() {
        return sizeField().findElement(By.xpath(".//option[contains(text(), 'Small')]"));
    }

    public WebElement mediumSize() {
        return sizeField().findElement(By.xpath(".//option[contains(text(), 'Medium')]"));
    }

    public WebElement largeSize() {
        return sizeField().findElement(By.xpath(".//option[contains(text(), 'Large')]"));
    }

    public WebElement productSize(int id) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "')]]//following-sibling::small"));
    }

    public WebElement productNameElement(int id, String productName) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + productName + "']]"));
    }
}
