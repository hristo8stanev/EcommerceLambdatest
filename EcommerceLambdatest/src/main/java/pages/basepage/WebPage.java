package pages.basepage;

import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebPage {
    public static final int TIME_FOR_TIMEOUT = 30;
    public String url;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebPage(WebDriver webDriver, String url) {
        this.url = url;
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIME_FOR_TIMEOUT));
    }

    protected abstract String Url();

    public void navigate() {
        webDriver.get(url);
    }

    public void assertUrlPage() {
        Assertions.assertEquals(Url(), webDriver.getCurrentUrl(), ErrorMessageUrl);
    }
}
