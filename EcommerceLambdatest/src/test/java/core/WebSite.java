package core;

import website.mainheader.MainHeader;
import org.openqa.selenium.WebDriver;

import website.pages.blogarticlepage.BlogArticlePage;
import website.pages.cartpage.CartPage;
import website.pages.checkoutpage.CheckoutPage;
import website.pages.comparisonpage.ComparisonPage;
import website.pages.forgotpasswordpage.ForgotPasswordPage;
import website.pages.homepage.HomePage;
import website.pages.loginpage.LoginPage;
import website.pages.logoutpage.LogoutPage;
import website.pages.myaccountpage.MyAccountPage;
import website.pages.newaddressbookpage.NewAddressBookPage;
import website.pages.newaddresspage.NewAddressPage;
import website.pages.productpage.ProductPage;
import website.pages.registerpage.RegisterPage;
import website.pages.returnproductpage.ReturnProductPage;
import website.pages.searchpage.SearchPage;
import website.pages.searchproductpricerange.SearchProductPriceRange;
import website.pages.specialproductpage.SpecialProductPage;
import website.pages.successfulorderpage.SuccessfulOrderPage;
import website.pages.successfulregisterpage.SuccessfulRegisterPage;
import website.pages.successfulreturnproductpage.SuccessfulReturnProductPage;
import website.pages.successfulvoucherpage.SuccessfulVoucherPage;
import website.pages.wishlistpage.WishlistPage;

public class WebSite {

    public WebDriver _driver;
    public HomePage homePage;
    public SpecialProductPage specialProductPage;
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
    public BlogArticlePage blogArticlePage;

    public WebSite(WebDriver driver) {
        this._driver = driver;
        this.blogArticlePage = new BlogArticlePage();
        this.mainHeader = new MainHeader();
        this.specialProductPage = new SpecialProductPage();
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