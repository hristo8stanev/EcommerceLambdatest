package pages.comparisonpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComparisonPageMap extends BaseMap {

    public WebElement compareButton() {
        return waitAndFindElement(By.partialLinkText("Product Compare"));
    }

    public WebElement compareProductButton() {
        return waitAndFindElement(By.xpath("//div[@id='product-product']//button[contains(normalize-space(@class), 'btn-compare')]"));
    }

    public WebElement removeFromCompareList(int id) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr//td//a[contains(@href, 'remove=" + id + "') and normalize-space()='Remove']"));
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
