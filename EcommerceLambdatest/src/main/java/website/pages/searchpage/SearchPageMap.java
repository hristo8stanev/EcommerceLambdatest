package website.pages.searchpage;

import core.basemap.BaseMap;
import enums.Manufacturer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import website.pages.productpage.ProductDetails;

public class SearchPageMap extends BaseMap {

    public WebElement searchInput() {
        return waitAndFindElement(By.xpath("//div[@id='product-search']//input[contains(normalize-space(@id), 'input-search')]"));
    }

    public WebElement searchButton() {
        return waitAndFindElement(By.id("button-search"));
    }

    public WebElement getProductName(int id, String name) {
        return waitAndFindElement(By.xpath("//h4//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + name + "']"));
    }

    public WebElement getProductPrice() {
        return waitAndFindElement(By.xpath("//div[@id='product-search']//span[contains(normalize-space(@class), 'price-new')]"));
    }

    public WebElement getProduct(int id) {
        return waitAndFindElement(By.xpath("//div[@id='product-search']//a[contains(@href, 'product_id=" + id + "')]"));
    }

    public WebElement quickViewButton(ProductDetails productDetails) {
        return waitAndFindElement(By.xpath("//button[contains(normalize-space(@class),'btn btn-quick-view quick-view-" + productDetails.getId() + "') and @title='Quick view']"));
    }

    public WebElement addToCart(ProductDetails productDetails) {
        return waitAndFindElement(By.xpath("//button[contains(normalize-space(@class),'btn btn-cart cart-" + productDetails.getId() + "') and @title ='Add to Cart']"));
    }

    public WebElement addToWishlist(ProductDetails productDetails) {
        return waitAndFindElement(By.xpath("//button[contains(normalize-space(@class),'btn btn-wishlist wishlist-" + productDetails.getId() + "') and @title ='Add to Wish List']"));
    }

    public WebElement compareButton(ProductDetails productDetails) {
        return waitAndFindElement(By.xpath("//button[contains(normalize-space(@class),'btn btn-compare compare-" + productDetails.getId() + "') and @title ='Compare this Product']"));
    }

    public WebElement quickViewProductName() {
        return waitAndFindElement(By.xpath("//div[@id='product-quick-view']//h1[contains(normalize-space(@class),'h4')]"));
    }

    public WebElement quickViewPrice() {
        return waitAndFindElement(By.xpath("//div[contains(normalize-space(@class),'price')]//h3[contains(normalize-space(@data-update),'price')]"));
    }

    public WebElement quickViewBrand() {
        return waitAndFindElement(By.xpath("//div[@id='product-quick-view']//span[contains(normalize-space(@class),'ls-label')]//following-sibling::a"));
    }

    public WebElement errorMessageNonExistingProduct(String message) {
        return waitAndFindElement(By.xpath("//p[contains(text(), '" + message + "')]"));
    }

    public WebElement minPriceField() {
        return waitAndFindElement(By.xpath("//div[@class='content']//input[contains(normalize-space(@placeholder), 'Minimum Price')]"));
    }

    public WebElement maxPriceField() {
        return waitAndFindElement(By.xpath("//div[@class='content']//input[contains(normalize-space(@placeholder), 'Maximum Price')]"));
    }

    public WebElement quickViewModel() {
        return waitAndFindElement(By.xpath("//div[@id='product-quick-view']//span[contains(normalize-space(@class),'ls-label')]//following-sibling::span"));
    }

    public WebElement quickViewAvailability() {
        return waitAndFindElement(By.xpath("//div[@id='product-quick-view']//span[contains(normalize-space(@class),'badge badge-success')]"));
    }

    public WebElement manufacturerPanel(Manufacturer manufacturer) {
        return waitAndFindElement(By.xpath("//div[@id='mz-filter-0']//img[contains(normalize-space(@alt),'" + manufacturer.getManufacturerName() + "')]"));
    }
}