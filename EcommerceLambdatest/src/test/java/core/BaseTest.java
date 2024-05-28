package core;

import core.driver.Driver;
import enums.BrowserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    private static WebDriver driver;
    protected static WebSite webSite;

    @BeforeEach
    public void setUp() {
        driver = Driver.startBrowser(BrowserType.CHROME);
        driver.manage().deleteAllCookies();
        webSite = new WebSite(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}