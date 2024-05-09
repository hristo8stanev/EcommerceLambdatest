package pages.basepage;

import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebPage {

    public static final int TIME_FOR_SECOND_TIMEOUT = 25;
    public String url;
    protected WebDriver driver;
    private static WebDriverWait wait;

    public WebPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_FOR_SECOND_TIMEOUT));
    }

    protected abstract String Url();

    public void navigate() {
        driver.get(url);
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