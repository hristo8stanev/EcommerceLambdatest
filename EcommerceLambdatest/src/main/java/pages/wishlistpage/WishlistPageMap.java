package pages.wishlistpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishlistPageMap extends BaseMap {

    public WebElement searchField() {
        return waitAndFindElement(By.name("search"));
    }

    public WebElement removeFromWishList() {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[contains(@class, 'text-right text-nowrap')]//a[contains(@href, 'account/wishlist&remove')]"));
    }

    public WebElement wishListSection() {
        return waitAndFindElement(By.xpath("//div[@class='toast-body']//a[contains(normalize-space(@href),'account/wishlist')]"));
    }

    public WebElement wishListButton() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//button[contains(normalize-space(@title),'Add to Wish List')]"));
    }

    public WebElement productPriceWishListElement(String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[@class='text-right' and normalize-space()='" + price + "']"));
    }

    public WebElement productElementInformation(String expectedElement) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(text(),'" + expectedElement + "')]"));
    }

    public WebElement productWeightElement(String weight) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(text(),'" + weight + "')]"));
    }

    public WebElement productNameElement(int id, String productName) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + productName + "']]"));
    }


}
