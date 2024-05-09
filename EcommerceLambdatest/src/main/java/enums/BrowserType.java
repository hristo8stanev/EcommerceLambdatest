package enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE,
    CHROME_HEADLESS,
    FIREFOX_HEADLESS,
    EDGE_HEADLESS;

    private static final int WAIT_FOR_TIMEOUT = 25;
    private static WebDriverWait webDriverWait;
    private static WebDriver webDriver;

    public static WebDriver setupBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                webDriver = new EdgeDriver();
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX_HEADLESS:
                FirefoxOptions optionFirefox = new FirefoxOptions();
                optionFirefox.addArguments("--headless=new");
                webDriver = new FirefoxDriver(optionFirefox);
                break;
            case EDGE_HEADLESS:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                webDriver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_FOR_TIMEOUT));
        return webDriver;
    }
}