package core;

import enums.BrowserType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.registerpage.RegisterPage;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebSite webSite;
    public static RegisterPage registerPage;

    @BeforeAll
    public static void setUp() {
        driver = BrowserType.setupBrowser(BrowserType.CHROME);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        registerPage = new RegisterPage(driver);
        webSite = new WebSite(driver);
    }

    @AfterAll
    public static void dispose() {
        driver.quit();
    }
}
