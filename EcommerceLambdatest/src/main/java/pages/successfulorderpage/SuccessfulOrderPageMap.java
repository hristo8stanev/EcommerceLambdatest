package pages.successfulorderpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessfulOrderPageMap extends BaseMap {

    public WebElement successfullyConfirmOrderText() {
        return waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
    }
}