package pages.BaseMap;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseMap {

    protected static final int WAIT_FOR_ELEMENT_TIMEOUT = 25;
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    protected static WebElement element;
    protected Actions actions;

    public BaseMap(WebDriver driver) {
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
        actions = new Actions(driver);
    }

    protected WebElement moveToElement(By locator) {
        element = driver.findElement(locator);
        actions.moveToElement(element).perform();
        return element;
    }

    protected WebElement waitElementToBeClcikable(By locator) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitAndFindElement(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waintUntilPageLoadsCompletely() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        webDriverWait.until(wd -> js.executeScript("return document.readyState").toString().equals("comeplete"));
    }
}