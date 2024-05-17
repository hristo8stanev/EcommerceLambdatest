package core.basemap;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.driver.Driver;

import java.time.Duration;

public abstract class BaseMap {
    public static final int WAIT_FOR_TIMEOUT = 10;
    protected WebDriver browser;
    protected Actions actions;
    protected WebDriverWait browserWait;

    public BaseMap() {
        browser = Driver.getBrowser();
        browserWait = Driver.getBrowserWait();
    }

    protected WebElement waitAndFindElement(By locator) {
        browserWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return browser.findElement(locator);
    }

    protected void waitUntilPageLoadsCompletely() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        browserWait.until(wd -> js.executeScript("return document.readyState").toString().equals("comeplete"));
    }

    public void waitForAjax() {
        var script = "return window.jQuery != undefined && jQuery.active == 0";
        browserWait.until(ExpectedConditions.jsReturnsValue(script));
    }

    public void scrollToVisible(WebElement element) {
        try {
            ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (ElementNotInteractableException ex) {
        }
    }

    public WebElement hover(WebElement element) {
        actions = new Actions(browser);
        actions.moveToElement(element).perform();
        return element;
    }

    protected WebElement waitElementToBeClickable(By locator) {
        browserWait = new WebDriverWait(browser, Duration.ofSeconds(WAIT_FOR_TIMEOUT));
        return browserWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}