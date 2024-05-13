package core.basemap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.driver.Driver;

public abstract class BaseMap {
    protected WebDriver browser;
    protected WebDriverWait browserWait;
    protected static WebDriver _driver;

    public BaseMap() {
        browser = Driver.getBrowser();
        browserWait = Driver.getBrowserWait();
    }

    protected WebElement waitAndFindElement(By locator) {
        browserWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return browser.findElement(locator);
    }
}



  // protected static final int WAIT_FOR_ELEMENT_TIMEOUT = 25;
  //
  // protected static WebDriverWait webDriverWait;
  // protected static WebElement element;
  // protected Actions actions;
  // protected Map<String, Supplier<WebElement>> elements;

   // public BaseMap(WebDriver driver) {
   //     this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
   //     actions = new Actions(driver);
   //     this.elements = new HashMap<>();
   // }
//
   // protected WebElement moveToElement(By locator) {
   //     element = driver.findElement(locator);
   //     actions.moveToElement(element).perform();
   //     return element;
   // }
//
   // protected WebElement waitElementToBeClcikable(By locator) {
   //     webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
   //     return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
   // }
//
   // protected void waintUntilPageLoadsCompletely() {
   //     JavascriptExecutor js = (JavascriptExecutor) driver;
   //     webDriverWait.until(wd -> js.executeScript("return document.readyState").toString().equals("comeplete"));
   // }
//

//
   // protected void addElement(String name, Supplier<WebElement> supplier) {
   //     elements.put(name, supplier);
   // }
//
   // public Supplier<WebElement> getElement(String name) {
   //     return elements.get(name);
   // }
//}