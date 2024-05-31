package website.pages.checkoutpage;

import core.basemap.BaseMap;
import enums.AccountType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPageMap extends BaseMap {

    public WebElement accountType(AccountType accountType) {
        return waitAndFindElement(By.xpath("//input[@name='account']/following-sibling::label[contains(text(),'" + accountType.getDisplayName() + "')]"));
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

    public WebElement agreeTerms() {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[@name='agree']//following-sibling::label"));
    }

    public WebElement continueButton() {
        return waitAndFindElement(By.xpath("//button[@id='button-save']"));
    }

    public WebElement confirmOrderButton() {
        return waitAndFindElement(By.id("button-confirm"));
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
        return waitAndFindElement(By.xpath("//div[@id='content']//input[contains(normalize-space(@id),'input-payment-password')]"));
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

    public WebElement newAddressLabel() {
        return waitElementToBeClickable(By.xpath("//div[@id='content']//input[@id='input-payment-address-new']//following-sibling::label"));
    }

    public WebElement searchButton() {
        return waitAndFindElement(By.xpath("//div[@id='search']//button[contains(normalize-space(@type),'submit')]"));
    }

    public WebElement updateButton() {
        return waitAndFindElement(By.xpath("//table[@class='table']//tbody//button[contains(normalize-space(@class),'btn-primary')]"));
    }

    public WebElement quantityField() {
        return waitAndFindElement(By.xpath("//div[@id='content']//tbody//td[contains(normalize-space(@class),'text-left')]//input[contains(normalize-space(@type),'text')]"));
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

    public WebElement privacyPolicy() {
        return waitElementToBeClickable(By.xpath("//label[@for='input-account-agree']"));
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

    public WebElement errorMessageAgreeTerms() {
        return waitAndFindElement(By.xpath("//div[@id='content']//div[contains(normalize-space(@class),'alert alert-warning alert-dismissible')]"));
    }

    public WebElement removeButton() {
        return waitAndFindElement(By.xpath("//div[@id='checkout-cart']//button[contains(normalize-space(@class),'btn btn-danger')]"));
    }

    public WebElement shoppingCartAmount() {
        return waitAndFindElement(By.xpath("//div[@id='main-header']//span[contains(normalize-space(@class),'badge badge-pill badge-info cart-item-total')]"));
    }
}