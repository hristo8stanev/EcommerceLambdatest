package core;

import org.openqa.selenium.WebDriver;
import pages.cartpage.CartPage;
import pages.checkoutpage.CheckoutPage;
import pages.homepage.HomePage;
import pages.loginpage.LoginPage;
import pages.logoutpage.LogoutPage;
import pages.myaccountpage.MyAccountPage;
import pages.registerpage.RegisterPage;
import pages.searchpage.SearchPage;

public class WebSite {

    public WebDriver _driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public LogoutPage logoutPage;
    public SearchPage searchPage;
    public RegisterPage registerPage;
    public MyAccountPage myAccountPage;


    public WebSite(WebDriver driver) {
        this._driver = driver;
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        logoutPage = new LogoutPage(driver);
        searchPage = new SearchPage(driver);
        registerPage = new RegisterPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }
}
