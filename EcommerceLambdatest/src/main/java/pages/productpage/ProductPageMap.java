package pages.productpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMap.BaseMap;

import java.util.function.Supplier;

public class ProductPageMap extends BaseMap {

    public ProductPageMap(WebDriver driver) {
        super(driver);
    }

    public Supplier<WebElement> searchField = () -> waitAndFindElement(By.name("search"));
    public Supplier<WebElement> removeButton = () -> waitAndFindElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
    public Supplier<WebElement> compareButton = () -> waitAndFindElement(By.partialLinkText("Product Compare"));
    public Supplier<WebElement> removeFromWishList = () -> waitAndFindElement(By.xpath("//div[@id='content']//td[contains(@class, 'text-right text-nowrap')]//a[contains(@href, 'account/wishlist&remove')]"));

    public Supplier<WebElement> removeFromCompareList(int id) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr//td//a[contains(@href, 'remove=" + id + "') and normalize-space()='Remove']"));
    }

    public Supplier<WebElement> quantityInput = () -> waitAndFindElement(By.xpath("//div[@id='product-product']//input[contains(normalize-space(@name), 'quantity')]"));
    public Supplier<WebElement> addToCartButton = () -> waitAndFindElement(By.xpath("//div[@class='content']//button[contains(text(),'Add to Cart')]"));
    public Supplier<WebElement> compareProductButton = () -> waitAndFindElement(By.xpath("//div[@id='product-product']//button[contains(normalize-space(@class), 'btn-compare')]"));
    public Supplier<WebElement> proceedToCompare = () -> waitAndFindElement(By.xpath("//*[@data-original-title='Compare']"));
    public Supplier<WebElement> findProduct = () -> waitAndFindElement(By.xpath("//h4/a"));
    public Supplier<WebElement> wishListSection = () -> waitAndFindElement(By.xpath("//div[@class='toast-body']//a[contains(normalize-space(@href),'account/wishlist')]"));
    public Supplier<WebElement> wishListButton = () -> waitAndFindElement(By.xpath("//div[@id='product-product']//button[contains(normalize-space(@title),'Add to Wish List')]"));
    public Supplier<WebElement> sizeField = () -> waitAndFindElement(By.xpath("//div[@id='product-product']//select[contains(normalize-space(@id),'input-option')]"));

    public Supplier<WebElement> smallSize() {
        return () -> sizeField.get().findElement(By.xpath(".//option[contains(text(), 'Small')]"));
    }

    public Supplier<WebElement> mediumSize() {
        return () -> sizeField.get().findElement(By.xpath(".//option[contains(text(), 'Medium')]"));
    }

    public Supplier<WebElement> largeSize() {
        return () -> sizeField.get().findElement(By.xpath(".//option[contains(text(), 'Large')]"));
    }

    public Supplier<WebElement> productSize(int id) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id={" + id + "')]]//following-sibling::small"));
    }

    public Supplier<WebElement> productNameElement(int id, String productName) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + productName + "']]"));
    }

    public Supplier<WebElement> productPriceWishListElement(String price) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[@class='text-right' and normalize-space()='" + price + "']"));
    }

    public Supplier<WebElement> productElementInformation(String expectedElement) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(text(),'" + expectedElement + "')]"));
    }

    public Supplier<WebElement> productWeightElement(String weight) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(text(),'" + weight + "')]"));
    }
}
