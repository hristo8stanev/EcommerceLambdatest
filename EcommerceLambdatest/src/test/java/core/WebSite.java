package core;

import org.openqa.selenium.WebDriver;

import pages.cartpage.CartPage;
import pages.checkoutpage.CheckoutPage;
import pages.comparisonpage.ComparisonPage;
import pages.forgotpasswordpage.ForgotPasswordPage;
import pages.homepage.HomePage;
import pages.loginpage.LoginPage;
import pages.logoutpage.LogoutPage;
import pages.myaccountpage.MyAccountPage;
import pages.newaddressbookpage.NewAddressBookPage;
import pages.newaddresspage.NewAddressPage;
import pages.productpage.ProductPage;
import pages.registerpage.RegisterPage;
import pages.returnproductpage.ReturnProductPage;
import pages.searchpage.SearchPage;
import pages.searchproductpricerange.SearchProductPriceRange;
import pages.successfulorderpage.SuccessfulOrderPage;
import pages.successfulreturnproductpage.SuccessfulReturnProductPage;
import pages.successfulvoucherpage.SuccessfulVoucherPage;
import pages.wishlistpage.WishlistPage;

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
    public ComparisonPage comparisonPage;
    public ForgotPasswordPage forgotPasswordPage;
    public NewAddressBookPage newAddressBookPage;
    public NewAddressPage newAddressPage;
    public ReturnProductPage returnProductPage;
    public SearchProductPriceRange searchProductPriceRange;
    public SuccessfulOrderPage successfulOrderPage;
    public SuccessfulReturnProductPage successfulReturnProductPage;
    public SuccessfulVoucherPage successfulVoucherPage;
    public WishlistPage wishlistPage;

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
        this.comparisonPage = new ComparisonPage(driver);
        this.forgotPasswordPage = new ForgotPasswordPage(driver);
        this.newAddressBookPage = new NewAddressBookPage(driver);
        this.newAddressPage = new NewAddressPage(driver);
        this.returnProductPage = new ReturnProductPage(driver);
        this.searchProductPriceRange = new SearchProductPriceRange(driver);
        this.successfulOrderPage = new SuccessfulOrderPage(driver);
        this.successfulReturnProductPage = new SuccessfulReturnProductPage(driver);
        this.successfulVoucherPage = new SuccessfulVoucherPage(driver);
        this.wishlistPage = new WishlistPage(driver);
    }
}