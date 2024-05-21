package pages.productpage;

import core.basemap.BaseMap;
import enums.DifferentSizeType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPageMap extends BaseMap {

    public WebElement removeButton() {
        return waitAndFindElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
    }

    public WebElement addToCartButton() {
        return waitAndFindElement(By.xpath("//div[@class='content']//button[contains(text(),'Add to Cart')]"));
    }

    public WebElement sizeField() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//select[contains(normalize-space(@id),'input-option')]"));
    }

    public WebElement selectSize(DifferentSizeType sizeType) {
        return sizeField().findElement(By.xpath(".//option[contains(text(), '" + sizeType.getSizeType() + "')]"));
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
}