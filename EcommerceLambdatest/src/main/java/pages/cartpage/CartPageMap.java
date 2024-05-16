package pages.cartpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPageMap extends BaseMap {

    public WebElement updateQuantityButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//button[contains(normalize-space(@type),'submit')]"));
    }

    public WebElement updateQuantityField() {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@name),'quantity')]"));
    }

    public WebElement removeButton() {
        return waitAndFindElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
    }

    public WebElement productNameElement(int id, String productName) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id={" + id + "}') and normalize-space()='" + productName + "']]"));
    }

    public WebElement productPriceElement(String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[@class='text-right' and contains(text(), '" + price + "}')]"));
    }

    public WebElement productModel(String modelProduct) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tbody//td[contains(text(), '" + modelProduct + "')]"));
    }

    public WebElement productTotalPriceElement(String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tbody//td[contains(text(), '" + price + "')]"));
    }

    public WebElement productQuantity(String cell) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//input[@class='" + cell + "']]//following-sibling::input"));
    }

    public WebElement removedProduct(String product) {
        return waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(), '" + product + "')]"));
    }
}
