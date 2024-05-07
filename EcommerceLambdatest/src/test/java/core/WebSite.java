package core;

import org.openqa.selenium.WebDriver;
import pages.cartpage.CartPage;

public class WebSite {

    private WebDriver driver;
    private static CartPage cartPage;

    public WebSite(WebDriver driver) {
        this.driver = driver;
        cartPage = new CartPage(driver);

    }
}
