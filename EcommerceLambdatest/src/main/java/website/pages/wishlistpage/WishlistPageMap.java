package website.pages.wishlistpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import website.pages.productpage.ProductDetails;

public class WishlistPageMap extends BaseMap {

    public WebElement searchField() {
        return waitAndFindElement(By.name("search"));
    }

    public WebElement removeFromWishList(ProductDetails expectedProduct) {
        return waitAndFindElement(By.xpath(
                "//div[@id='content']//td[contains(@class, 'text-right text-nowrap')]//a[contains(normalize-space(@href), 'account/wishlist&remove=" + expectedProduct.getId() + "')]"));
    }

    public WebElement wishListSection() {
        return waitAndFindElement(By.xpath("//div[@class='toast-body']//a[contains(normalize-space(@href),'account/wishlist')]"));
    }

    public WebElement removeButton(ProductDetails productDetails) {
        return waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'remove=" + productDetails.getId() + "')]"));
    }

    public WebElement productPriceWishListElement(String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[@class='text-right' and normalize-space()='" + price + "']"));
    }

    public WebElement productElementInformation(String expectedElement) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(text(),'" + expectedElement + "')]"));
    }

    public WebElement productNameElement(int id, String productName) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + productName + "']]"));
    }
}