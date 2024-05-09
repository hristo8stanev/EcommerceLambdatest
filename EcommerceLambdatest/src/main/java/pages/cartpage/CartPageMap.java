package pages.cartpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMap.BaseMap;

import java.util.function.Supplier;

public class CartPageMap extends BaseMap {

    public CartPageMap(WebDriver driver) {
        super(driver);
    }
    public Supplier<WebElement> updateQuantityButton = () -> waitAndFindElement(By.xpath("//div[@id='content']//button[contains(normalize-space(@type),'submit')]"));
    public Supplier<WebElement> updateQuantityField = () -> waitAndFindElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@name),'quantity')]"));
    public Supplier<WebElement> removeButton = () -> waitAndFindElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));

    public Supplier<WebElement> productNameElement(int id, String productName) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id={" + id + "}') and normalize-space()='" + productName + "']]"));
    }

    public Supplier<WebElement> productPriceElement(String price) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[@class='text-right' and contains(text(), '" + price + "}')]"));
    }

    public Supplier<WebElement> productModel(String modelProduct) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tbody//td[contains(text(), '" + modelProduct + "')]"));
    }

    public Supplier<WebElement> productTotalPriceElement(String price) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tbody//td[contains(text(), '" + price + "')]"));
    }

    public Supplier<WebElement> productQuantity(String cell) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//input[@class='" + cell + "']]//following-sibling::input"));
    }

    public Supplier<WebElement> removedProduct(String product) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(), '" + product + "')]"));
    }
}
