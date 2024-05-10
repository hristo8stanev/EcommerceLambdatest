package core;

import core.driver.Driver;
import enums.BrowserType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static enums.BrowserType.*;

public class BaseTest {

    private static WebDriver driver;
    protected static WebSite webSite;

    @BeforeAll
    public static void setUp() {
        driver = Driver.startBrowser(BrowserType.CHROME);
        webSite = new WebSite(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
