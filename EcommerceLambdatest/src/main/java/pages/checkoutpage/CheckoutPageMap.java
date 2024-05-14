package pages.checkoutpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class CheckoutPageMap extends BaseMap {
    public WebElement applyCoupon() {
        return moveToElement(By.xpath("//div[@id='content']//button[@id='button-coupon']"));
    }

    public WebElement loginInput() {
        return waitAndFindElement(By.xpath("//*[@for='input-account-login']"));
    }

    public WebElement emailInput() {
        return waitAndFindElement(By.id("input-login-email"));
    }

    public WebElement passwordInput() {
        return waitAndFindElement(By.xpath("//input[@id='input-login-password']"));
    }

    public WebElement loginButton() {
        return waitAndFindElement(By.xpath("//*[@id='button-login']"));
    }

    public WebElement registerAccountType() {
        return waitAndFindElement(By.xpath("//*[@for='input-account-register']"));
    }

    public WebElement guestAccountType() {
        return waitAndFindElement(By.xpath("//*[@for='input-account-guest']"));
    }

    public WebElement agreeTerms() {
        return waitAndFindElement(By.xpath("//*[@for='input-agree']"));
    }

    public WebElement continueButton() {
        return waitAndFindElement(By.id("button-save"));
    }

    public WebElement confirmOrderButton() {
        return moveToElement(By.id("button-confirm"));
    }

    public WebElement successfullyConfirmOrderText() {
        return waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
    }

    public WebElement firstNameInput() {
        return waitAndFindElement(By.id("input-payment-firstname"));
    }

    public WebElement lastNameInput() {
        return waitAndFindElement(By.id("input-payment-lastname"));
    }

    public WebElement emailPaymentInput() {
        return waitAndFindElement(By.id("input-payment-email"));
    }

    public WebElement telephonePaymentInput() {
        return waitAndFindElement(By.id("input-payment-telephone"));
    }

    public WebElement passwordPaymentInput() {
        return waitAndFindElement(By.id("input-payment-password"));
    }

    public WebElement confirmPasswordPaymentInput() {
        return waitAndFindElement(By.id("input-payment-confirm"));
    }

    public WebElement companyInput() {
        return waitAndFindElement(By.id("input-payment-company"));
    }

    public WebElement addressField1() {
        return waitAndFindElement(By.name("address_1"));
    }

    public WebElement addressField2() {
        return waitAndFindElement(By.name("address_2"));
    }

    public WebElement cityInput() {
        return waitAndFindElement(By.id("input-payment-city"));
    }

    public WebElement postCodeInput() {
        return waitAndFindElement(By.name("postcode"));
    }

    public WebElement searchButton() {
        return moveToElement(By.xpath("//div[@id='search']//button[contains(normalize-space(@type),'submit')]"));
    }

    public WebElement quantityField() {
        return waitAndFindElement(By.xpath("//table[@class='table']//tbody//input"));
    }

    public WebElement updateButton() {
        return waitAndFindElement(By.xpath("//table[@class='table']//tbody//button[contains(normalize-space(@class),'btn-primary')]"));
    }

    public WebElement subTotal() {
        return waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//td[contains(text(),'Sub-Total:')]//following-sibling::td"));
    }

    public WebElement total() {
        return waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//preceding-sibling::td[text()='Total:']//following-sibling::td"));
    }

    public WebElement ecoTaxElement() {
        return waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//td[contains(text(),'Eco')]//following-sibling::td"));
    }

    public WebElement vatTaxElement() {
        return waitAndFindElement(By.xpath("//table[@id='checkout-total']//tbody//td[contains(text(),'VAT')]//following-sibling::td"));
    }

    public WebElement country(String country) {
        WebElement countryDropdown = waitAndFindElement(By.id("input-payment-country"));
        return countryDropdown.findElement(By.xpath(".//option[contains(text(), '" + country + "')]"));
    }

    public WebElement region(String region) {
        WebElement regionDropdown = waitAndFindElement(By.id("input-payment-zone"));
        return regionDropdown.findElement(By.xpath(".//option[contains(text(), '" + region + "')]"));
    }

    public WebElement agreePrivacy() {
        return waitAndFindElement(By.xpath("//*[@for='input-account-agree']"));
    }

    public WebElement confirmOrderProductName(String cell, String productName) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[contains(normalize-space(@class),'" + cell + "') and contains(text(),'" + productName + "')]"));
    }

    public WebElement confirmOrderInformation(String cell, String productInfo) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[contains(normalize-space(@class),'" + cell + "') and contains(text(),'" + productInfo + "')]"));
    }

    public WebElement confirmOrderQuantityElement(String productModel) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//preceding-sibling::td[normalize-space()='" + productModel + "']]"));
    }

    public WebElement confirmOrderPriceElement(String quantityOfProduct) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//preceding-sibling::td[normalize-space()='" + quantityOfProduct + "']]"));
    }

    public WebElement productNameElement(int id, String name) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "') and normalize-space(text())='" + name + "']]//a"));
    }

    public WebElement productQuantityElement(int id, String productName) {
        return waitAndFindElement(By.xpath("//div[@id='content']//td[.//a[contains(@href, 'product_id=" + id + "') and normalize-space(text())='" + productName + "']]//following-sibling::td//input"));
    }

    public WebElement productPriceElement(String cell, String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(normalize-space(@class), '" + cell + "') and contains(normalize-space(text()), '" + price + "')]"));
    }

    public WebElement productTotalPriceElement(String cell, String price) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr//td[contains(normalize-space(@class), '" + cell + "') and contains(normalize-space(text()), '" + price + "')]//following-sibling::td"));
    }
}