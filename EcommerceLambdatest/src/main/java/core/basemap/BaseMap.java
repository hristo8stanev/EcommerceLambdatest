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

    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        browserWait.until(wd -> js.executeScript("return document.readyState").toString().equals("complete"));
    }

    public void scrollToVisible(WebElement element) {
        try {
            ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (ElementNotInteractableException ex) {
        }
    }

    public void typeText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    public boolean isCartEmpty(WebElement element) {
        return !element.getText().equals("0");
    }

    public void hover(WebElement element) {
        actions = new Actions(browser);
        actions.moveToElement(element).perform();
    }

    protected WebElement waitElementToBeClickable(By locator) {
        browserWait = new WebDriverWait(browser, Duration.ofSeconds(WAIT_FOR_TIMEOUT));
        return browserWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}