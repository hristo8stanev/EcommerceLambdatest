package core.basepage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.driver.Driver;
import core.newistance.NewInstance;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constants.ErrorMessageUrl;

public abstract class WebPage <ElementsT extends BaseMap, AssertionsT extends BaseAssertions<ElementsT>> {

     public String url;
     protected WebDriver driver;
     private static WebDriverWait wait;

    protected abstract String Url();

    public void navigate() {
        Driver.getBrowser().navigate().to(Url());
    }

    protected ElementsT elements() {
        return NewInstance.createByTypeParameter(getClass(), 0);
    }

    public AssertionsT assertions() {
        return NewInstance.createByTypeParameter(getClass(), 1);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void waitForAjax() {
        var script = "return window.jQuery != undefined && jQuery.active == 0";
        wait.until(ExpectedConditions.jsReturnsValue(script));
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void scrolltoVisible(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (ElementNotInteractableException ex) {
        }
    }

    public void assertUrlPage() {
        Assertions.assertEquals(Url(), driver.getCurrentUrl(), ErrorMessageUrl);
        waitForAjax();
    }
}