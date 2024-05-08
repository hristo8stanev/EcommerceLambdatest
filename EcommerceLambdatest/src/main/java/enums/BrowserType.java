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
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME_HEADLESS:
                ChromeOptions optionChrome = new ChromeOptions();
                optionChrome.addArguments("--headless=new");
                return new ChromeDriver(optionChrome);
            case FIREFOX_HEADLESS:
                FirefoxOptions optionFirefox = new FirefoxOptions();
                optionFirefox.addArguments("--headless=new");
                return new FirefoxDriver(optionFirefox);
            case EDGE:
                return new EdgeDriver();
            case EDGE_HEADLESS:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
        }
        return null;
    }
}