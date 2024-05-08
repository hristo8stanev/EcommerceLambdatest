package core;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;

import pages.cartpage.CartPage;
import pages.checkoutpage.CheckoutPage;
import pages.homepage.HomePage;
import pages.loginpage.LoginPage;
import pages.logoutpage.LogoutPage;
import pages.myaccountpage.MyAccountPage;
import pages.productpage.ProductPage;
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
    public MyAccountPage myAccountPage;
    public ProductPage productPage;
    public RegisterPage registerPage;

    public WebSite(WebDriver driver) {
        this._driver = driver;
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
        this.loginPage = new LoginPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.logoutPage = new LogoutPage(driver);
        this.searchPage = new SearchPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.myAccountPage = new MyAccountPage(driver);
        this.productPage = new ProductPage(driver);
    }
}