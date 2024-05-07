package enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE,
    CHROME_HEADLESS,
    FIREFOX_HEADLESS,
    EDGE_HEADLESS;

    public static WebDriver setupBrowser(BrowserType browserType) {

        switch (browserType) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
            case CHROME_HEADLESS -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                return new ChromeDriver(chromeOptions);
            }
            case FIREFOX_HEADLESS -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=new");
                return new FirefoxDriver(firefoxOptions);
            }
            case EDGE_HEADLESS -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
            }
            default -> throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        return null;
    }
}