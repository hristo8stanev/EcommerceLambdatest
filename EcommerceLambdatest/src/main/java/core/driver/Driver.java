package core.driver;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.*;

public class Driver {

    private static final int WAIT_FOR_TIMEOUT = 25;
    private static WebDriverWait browserWait;
    private static WebDriver browser;

    public static WebDriver getBrowser() {
        if (browser == null) {
            throw new NullPointerException(THE_WEB_DRIVER_BROWSER_INSTANCE_WAS_NOT_INITIALIZED_YOU_SHOULD_FIRST_CALL_THE_START_METHOD);
        }

        return browser;
    }

    public static void setBrowser(WebDriver browser) {
        Driver.browser = browser;
    }

    public static String getCurrentUrl() {
        if (browser == null) {
            throw new NullPointerException(THE_WEB_DRIVER_BROWSER_INSTANCE_WAS_NOT_INITIALIZED_YOU_SHOULD_FIRST_CALL_THE_START_METHOD);
        }

        return browser.getCurrentUrl();
    }

    public static void waitForAjax() {
        var script = "return window.jQuery != undefined && jQuery.active == 0";
        browserWait.until(ExpectedConditions.jsReturnsValue(script));
    }


    public static WebDriverWait getBrowserWait() {
        if (browserWait == null || browser == null) {
            throw new NullPointerException(THE_WEB_DRIVER_BROWSER_INSTANCE_WAS_NOT_INITIALIZED_YOU_SHOULD_FIRST_CALL_THE_START_METHOD);
        }

        return browserWait;
    }

    public static void setBrowserWait(WebDriverWait browserWait) {
        Driver.browserWait = browserWait;
    }

    public static WebDriver startBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                browser = new ChromeDriver();
                break;
            case FIREFOX:
                browser = new FirefoxDriver();
                break;
            case EDGE:
                browser = new EdgeDriver();
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                browser = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX_HEADLESS:
                FirefoxOptions optionFirefox = new FirefoxOptions();
                optionFirefox.addArguments("--headless=new");
                browser = new FirefoxDriver(optionFirefox);
                break;
            case EDGE_HEADLESS:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                browser = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException(UNSUPPORTED_BROWSER_TYPE + browserType);
        }
        browser.manage().window().maximize();
        browserWait = new WebDriverWait(browser, Duration.ofSeconds(WAIT_FOR_TIMEOUT));

        return browser;
    }
}