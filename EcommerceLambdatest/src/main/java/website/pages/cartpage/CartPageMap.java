package website.pages.cartpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import website.pages.productpage.ProductDetails;

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

    public WebElement productNameElement(ProductDetails expectedProduct) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + expectedProduct.getId() + "') and normalize-space()='" + expectedProduct.getName() + "']]//a"));
    }

    public WebElement productPriceElement(String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[@class='text-right' and contains(text(), '" + price + "')]"));
    }

    public WebElement productModel(ProductDetails expectedProduct) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tbody//td[contains(text(), '" + expectedProduct.getModel() + "')]"));
    }

    public WebElement productTotalPriceElement(String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tbody//td[contains(text(), '" + price + "')]"));
    }

    public WebElement productQuantity(ProductDetails expectedProduct) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[contains(normalize-space(@class),'text-left')]//input[contains(normalize-space(@value),'" + expectedProduct.getQuantity() + "')]"));
    }

    public WebElement removedProduct(String product) {
        return waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(), '" + product + "')]"));
    }

    public WebElement shoppingCartAmount() {
        return waitAndFindElement(By.xpath("//div[@id='main-header']//span[contains(normalize-space(@class),'badge badge-pill badge-info cart-item-total')]"));
    }
}