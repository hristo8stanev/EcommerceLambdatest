package pages.checkoutpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseMap.BaseMap;

import java.util.function.Supplier;

public class CheckoutPageMap extends BaseMap {

    public CheckoutPageMap(WebDriver driver) {
        super(driver);
    }
    public Supplier<WebElement> applyCoupon = () -> waitAndFindElement(By.xpath("//div[@id='content']//button[@id='button-coupon']"));
    public Supplier<WebElement> loginInput = () -> waitAndFindElement(By.xpath("//*[@for='input-account-login']"));
    public Supplier<WebElement> emailInput = () -> waitAndFindElement(By.id("input-login-email"));
    public Supplier<WebElement> passwordInput = () -> waitAndFindElement(By.xpath("//input[@id='input-login-password']"));
    public Supplier<WebElement> loginButton = () -> waitAndFindElement(By.xpath("//*[@id='button-login']"));
    public Supplier<WebElement> registerAccountType = () -> waitAndFindElement(By.xpath("//*[@for='input-account-register']"));
    public Supplier<WebElement> guestAccountType = () -> waitAndFindElement(By.xpath("//*[@for='input-account-guest']"));
    public Supplier<WebElement> agreeTerms = () -> waitAndFindElement(By.xpath("//*[@for='input-agree']"));
    public Supplier<WebElement> continueButton = () -> waitAndFindElement(By.id("button-save"));
    public Supplier<WebElement> confirmOrderButton = () -> waitAndFindElement(By.id("button-confirm"));
    public Supplier<WebElement> successfullyConfirmOrderText = () -> waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
    public Supplier<WebElement> firstNameInput = () -> waitAndFindElement(By.id("input-payment-firstname"));
    public Supplier<WebElement> lastNameInput = () -> waitAndFindElement(By.id("input-payment-lastname"));
    public Supplier<WebElement> emailPaymentInput = () -> waitAndFindElement(By.id("input-payment-email"));
    public Supplier<WebElement> telephonePaymentInput = () -> waitAndFindElement(By.id("input-payment-telephone"));
    public Supplier<WebElement> passwordPaymentInput = () -> waitAndFindElement(By.id("input-payment-password"));
    public Supplier<WebElement> confirmPasswordPaymentInput = () -> waitAndFindElement(By.id("input-payment-confirm"));
    public Supplier<WebElement> companyInput = () -> waitAndFindElement(By.id("input-payment-company"));
    public Supplier<WebElement> addressField1 = () -> waitAndFindElement(By.name("address_1"));
    public Supplier<WebElement> addressField2 = () -> waitAndFindElement(By.name("address_2"));
    public Supplier<WebElement> cityInput = () -> waitAndFindElement(By.id("input-payment-city"));
    public Supplier<WebElement> postCodeInput = () -> waitAndFindElement(By.name("postcode"));
    public Supplier<WebElement> searchButton = () -> waitAndFindElement(By.xpath("//div[@id='search']//button[contains(normalize-space(@type),'submit')]"));
    public Supplier<WebElement> quantityField = () -> waitAndFindElement(By.xpath("//table[@class='table']//tbody//input"));
    public Supplier<WebElement> updateButton = () -> waitAndFindElement(By.xpath("//table[@class='table']//tbody//button[contains(normalize-space(@class),'btn-primary')]"));
    public Supplier<WebElement> subTotal = () -> waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//td[contains(text(),'Sub-Total:')]//following-sibling::td"));
    public Supplier<WebElement> total = () -> waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//preceding-sibling::td[text()=\"Total:\"]//following-sibling::td"));
    public Supplier<WebElement> ecoTaxElement = () -> waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//td[contains(text(),'Eco')]//following-sibling::td"));
    public Supplier<WebElement> vatTaxElement = () -> waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//td[contains(text(),'VAT')]//following-sibling::td"));

    public Supplier<WebElement> country(String country) {
        return () -> waitAndFindElement(By.id("input-payment-country")).findElement(By.xpath(".//option[contains(text(), '" + country + "]"));
    }

    public Supplier<WebElement> region(String region) {
        return () -> waitAndFindElement(By.id("input-payment-zone")).findElement(By.xpath(".//option[contains(text(), '" + region + "')]"));
    }

    public Supplier<WebElement> agreePrivacy = () -> waitAndFindElement(By.xpath("//*[@for='input-account-agree']"));

    public Supplier<WebElement> confirmOrderProductName(String cell, String productName) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[contains(normalize-space(@class),'" + cell + "') and contains(text(),'" + productName + "')]"));
    }

    public Supplier<WebElement> confirmOrderInformation(String cell, String productInfo) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[contains(normalize-space(@class),'" + cell + "') and contains(text(),'" + productInfo + "')]"));
    }

    public Supplier<WebElement> confirmOrderQuantityElement(String productModel) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//preceding-sibling::td[normalize-space()='" + productModel + "']]"));
    }

    public Supplier<WebElement> confirmOrderPriceElement(String quantityOfProduct) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//preceding-sibling::td[normalize-space()='" + quantityOfProduct + "']]"));
    }

    public Supplier<WebElement> productNameElement(int id, String name) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id='" + id + "') and normalize-space()='" + name + "'}']]//a"));
    }

    public Supplier<WebElement> productQuantityElement(int id, String productName) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "') and normalize-space()='" + productName + "']]//following-sibling::td//input"));
    }

    public Supplier<WebElement> productPriceElement(String cell, String price) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(normalize-space(@class),'" + cell + "') and contains(text(), '" + price + "')]"));
    }

    public Supplier<WebElement> productTotalPriceElement(String cell, String price) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(normalize-space(@class),'" + cell + "') and contains(text(), '" + price+ "')]//following-sibling::td"));
    }
}