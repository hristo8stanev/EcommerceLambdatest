package website.pages.returnproductpage;

import core.basemap.BaseMap;
import enums.DifferentSizeType;
import enums.ProductOpened;
import enums.ReasonType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReturnProductPageMap extends BaseMap {

    public WebElement orderIdInput() {
        return waitAndFindElement(By.id("input-order-id"));
    }

    public WebElement orderDateInput() {
        return waitAndFindElement(By.id("input-date-ordered"));
    }

    public WebElement successfullyProductReturn(String expectedMessage) {
        return waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(),'" + expectedMessage + "')]"));
    }

    public WebElement productNameInput() {
        return waitAndFindElement(By.id("input-product"));
    }

    public WebElement productCodeInput() {
        return waitAndFindElement(By.id("input-model"));
    }

    public WebElement submitButton() {
        return waitAndFindElement(By.xpath("//*[@value='Submit']"));
    }

    public WebElement productQuantityInput() {
        return waitAndFindElement(By.id("input-quantity"));
    }

    public WebElement returnReasonInput(ReasonType reasonType) {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[@name='return_reason_id' and @value='" + reasonType.getReasonType() + "']"));
    }

    public WebElement productOpenedInput(ProductOpened reasonId) {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[@name='opened' and normalize-space(@value)='" + reasonId.getNumberDisplayed() + "']"));
    }
}