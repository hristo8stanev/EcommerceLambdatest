package pages.myaccountpage;

import core.basemap.BaseMap;
import enums.GiftCertificateType;
import enums.ProductOpened;
import enums.ReasonType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class MyAccountPageMap extends BaseMap {

    public WebElement editMyAccountButton() {
        return waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/edit')]"));
    }

    public WebElement changeMyPasswordButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/password')]"));
    }

    public WebElement addressBookButton() {
        return waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/address')]"));
    }

    public WebElement newAddressButton() {
        return waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/address/add')]"));
    }

    public WebElement companyInput() {
        return waitAndFindElement(By.id("input-company"));
    }

    public WebElement addressInput1() {
        return waitAndFindElement(By.id("input-address-1"));
    }

    public WebElement addressInput2() {
        return waitAndFindElement(By.id("input-address-2"));
    }

    public WebElement cityInput() {
        return waitAndFindElement(By.id("input-city"));
    }

    public WebElement postCodeInput() {
        return waitAndFindElement(By.id("input-postcode"));
    }

    public WebElement firstNameInputPayment() {
        return waitAndFindElement(By.xpath("//*[@id='input-payment-firstname']"));
    }

    public WebElement lastNameInputPayment() {
        return waitAndFindElement(By.xpath("//*[@id='input-payment-lastname']"));
    }

    public WebElement orderIdInput() {
        return waitAndFindElement(By.id("input-order-id"));
    }

    public WebElement productNameInput() {
        return waitAndFindElement(By.id("input-product"));
    }

    public WebElement productCodeInput() {
        return waitAndFindElement(By.id("input-model"));
    }

    public WebElement orderDateInput() {
        return waitAndFindElement(By.id("input-date-ordered"));
    }

    public WebElement productQuantityInput() {
        return waitAndFindElement(By.id("input-quantity"));
    }

    public WebElement returnReasonInput(ReasonType reasonType) {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[@name='return_reason_id' and @value='" + reasonType.getReasonType() + "']"));
    }

    public WebElement productOpenedInput(ProductOpened reasonId) {
        return waitAndFindElement(By.xpath("//div[@id='content']//input[@name='opened' and normalize-space(@value)='" + reasonId.getNumberDisplayed() + "']"));
    }

    public WebElement country(String country) {
        return waitAndFindElement(By.id("input-country")).findElement(By.xpath(".//option[contains(text(), '" + country + "')]"));
    }

    public WebElement findRegionOption(String region) {
        return waitAndFindElement(By.id("input-zone")).findElement(By.xpath(".//option[contains(text(), '" + region + "')]"
        ));
    }

    public WebElement passwordInput() {
        return waitAndFindElement(By.id("input-password"));
    }

    public WebElement confirmPasswordInput() {
        return waitAndFindElement(By.id("input-confirm"));
    }

    public WebElement submitButton() {
        return waitAndFindElement(By.xpath("//*[@value='Submit']"));
    }

    public WebElement continueButton() {
        return waitAndFindElement(By.xpath("//*[@value='Continue']"));
    }

    public WebElement successfullyMessage() {
        return waitAndFindElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
    }

    public WebElement successfullyProductReturn(String expectedMessage) {
        return waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(),'" + expectedMessage + "')]"));
    }

    public WebElement successfullyPurchaseCertificate() {
        return waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
    }

    public WebElement firstNameInput() {
        return waitAndFindElement(By.id("input-firstname"));
    }

    public WebElement lastNameInput() {
        return waitAndFindElement(By.id("input-lastname"));
    }

    public WebElement emailAddressNameInput() {
        return waitAndFindElement(By.id("input-email"));
    }

    public WebElement telephoneInput() {
        return waitAndFindElement(By.id("input-telephone"));
    }

    public WebElement recipientNameInput() {
        return waitAndFindElement(By.xpath("//*[@id='input-to-name']"));
    }

    public WebElement recipientEmailInput() {
        return waitAndFindElement(By.xpath("//*[@id='input-to-email']"));
    }

    public WebElement yourNameInput() {
        return waitAndFindElement(By.id("input-from-name"));
    }

    public WebElement yourEmailInput() {
        return waitAndFindElement(By.id("input-from-email"));
    }

    public WebElement giftCertificateTheme(GiftCertificateType giftCertificateType) {
        return waitAndFindElement(By.xpath("//label[contains(text(), '" + giftCertificateType.getGiftType() + "')]"));
    }

    public WebElement amountCertificateInput() {
        return waitAndFindElement(By.id("input-amount"));
    }

    public WebElement messageCertificate() {
        return waitAndFindElement(By.id("input-message"));
    }

    public WebElement agreeGiftCertificate() {
        return waitAndFindElement(By.name("agree"));
    }

    public WebElement dateTimeElement(String dateTime) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr/td[@class='text-left' and contains(text(), '" + dateTime + "')]"));
    }

    public WebElement customerElement(String name) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr/td[@class='text-left' and contains(text(), '" + name + "')]"));
    }

    public WebElement giftPriceNameElement(String amount, String name) {
        return waitAndFindElement(By.xpath("//div[@id='content']//tr/td[@class='text-left' and contains(text(), '$" + amount + ".00 Gift Certificate for " + name + "')]"));
    }

    public WebElement myAccountMenuSection() {
        return waitAndFindElement(By.xpath("//ul[@class='navbar-nav horizontal']//li[.//a[contains(@href, 'account/account')]]"));
    }

    public WebElement myOrderHistoryButton() {
        return waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/order')]"));
    }

    public WebElement myVoucherButton() {
        return myAccountMenuSection().findElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@href),'account/voucher')]"));
    }

    public WebElement returnOrderButton() {
        return myAccountMenuSection().findElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@href),'account/return')]"));
    }

    public WebElement removeButton() {
        return waitAndFindElement(By.xpath("//button[contains(@onclick, 'voucher.remove')]"));
    }

    public WebElement removedProduct(String product) {
        return waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(), '" + product + "')]"));
    }
}