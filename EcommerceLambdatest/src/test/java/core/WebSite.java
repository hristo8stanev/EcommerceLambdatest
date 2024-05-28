package core;

import websitedata.mainheader.MainHeader;
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
import pages.successfulregisterpage.SuccessfulRegisterPage;
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
    public SuccessfulRegisterPage successfulRegisterPage;
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
    public MainHeader mainHeader;

    public WebSite(WebDriver driver) {
        this._driver = driver;
        this.mainHeader = new MainHeader();
        this.homePage = new HomePage();
        this.cartPage = new CartPage();
        this.loginPage = new LoginPage();
        this.checkoutPage = new CheckoutPage();
        this.logoutPage = new LogoutPage();
        this.searchPage = new SearchPage();
        this.registerPage = new RegisterPage();
        this.myAccountPage = new MyAccountPage();
        this.productPage = new ProductPage();
        this.comparisonPage = new ComparisonPage();
        this.newAddressBookPage = new NewAddressBookPage();
        this.newAddressPage = new NewAddressPage();
        this.returnProductPage = new ReturnProductPage();
        this.searchProductPriceRange = new SearchProductPriceRange();
        this.successfulOrderPage = new SuccessfulOrderPage();
        this.successfulReturnProductPage = new SuccessfulReturnProductPage();
        this.successfulVoucherPage = new SuccessfulVoucherPage();
        this.wishlistPage = new WishlistPage();
        this.successfulRegisterPage = new SuccessfulRegisterPage();
        this.forgotPasswordPage = new ForgotPasswordPage();
    }
}