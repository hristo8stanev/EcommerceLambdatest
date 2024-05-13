package pages.myaccountpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class MyAccountPageMap extends BaseMap {



    public Supplier<WebElement> editMyAccountButton = () -> waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/edit')]"));
    public Supplier<WebElement> changeMyPasswordButton = () -> waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/password')]"));
    public Supplier<WebElement> addressBookButton = () -> waitAndFindElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/address')]"));
    public Supplier<WebElement> newAddressButton = () -> waitAndFindElement(By.xpath("//div[@id='content']//a[contains(normalize-space(@href),'account/address/add')]"));
    public Supplier<WebElement> companyInput = () -> waitAndFindElement(By.id("input-company"));
    public Supplier<WebElement> addressInput1 = () -> waitAndFindElement(By.id("input-address-1"));
    public Supplier<WebElement> addressInput2 = () -> waitAndFindElement(By.id("input-address-2"));
    public Supplier<WebElement> cityInput = () -> waitAndFindElement(By.id("input-city"));
    public Supplier<WebElement> postCodeInput = () -> waitAndFindElement(By.id("input-postcode"));
    public Supplier<WebElement> firstNameInputPayment = () -> waitAndFindElement(By.xpath("//*[@id='input-payment-firstname']"));
    public Supplier<WebElement> lastNameInputPayment = () -> waitAndFindElement(By.xpath("//*[@id='input-payment-lastname']"));
    public Supplier<WebElement> orderIdInput = () -> waitAndFindElement(By.id("input-order-id"));
    public Supplier<WebElement> productNameInput = () -> waitAndFindElement(By.id("input-product"));
    public Supplier<WebElement> productCodeInput = () -> waitAndFindElement(By.id("input-model"));
    public Supplier<WebElement> orderDateInput = () -> waitAndFindElement(By.id("input-date-ordered"));
    public Supplier<WebElement> productQuantityInput = () -> waitAndFindElement(By.id("input-quantity"));

    public Supplier<WebElement> returnReasonInput(int reasonId) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//input[@name='return_reason_id' and @value='" + reasonId + "']"));
    }

    public Supplier<WebElement> productOpenedInput(int reasonId) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//input[@name='opened' and @value='" + reasonId + "']"));
    }

    public Supplier<WebElement> country(String country) {
        return () -> browser.findElement(By.id("input-country")).findElement(By.xpath(".//option[contains(text(), '" + country + "')]"));
    }

    public Supplier<WebElement> findRegionOption(String region) {
        return () -> browser.findElement(By.id("input-zone")).findElement(By.xpath(".//option[contains(text(), '" + region + "')]")
        );
    }

    public Supplier<WebElement> passwordInput = () -> waitAndFindElement(By.id("input-password"));
    public Supplier<WebElement> confirmPasswordInput = () -> waitAndFindElement(By.id("input-confirm"));
    public Supplier<WebElement> submitButton = () -> waitAndFindElement(By.xpath("//*[@value='Submit']"));
    public Supplier<WebElement> continueButton = () -> waitAndFindElement(By.xpath("//*[@value='Continue']"));
    public Supplier<WebElement> successfullyMessage = () -> waitAndFindElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));

    public Supplier<WebElement> successfullyProductReturn(String expectedMessage) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(),'" + expectedMessage + "')]"));
    }

    public Supplier<WebElement> successfullyPurchaseCertificate = () -> waitAndFindElement(By.xpath("//h1[@class='page-title my-3']"));
    public Supplier<WebElement> firstNameInput = () -> waitAndFindElement(By.id("input-firstname"));
    public Supplier<WebElement> lastNameInput = () -> waitAndFindElement(By.id("input-lastname"));
    public Supplier<WebElement> emailAddressNameInput = () -> waitAndFindElement(By.id("input-email"));
    public Supplier<WebElement> telephoneInput = () -> waitAndFindElement(By.id("input-telephone"));
    public Supplier<WebElement> recipientNameInput = () -> waitAndFindElement(By.xpath("//*[@id='input-to-name']"));
    public Supplier<WebElement> recipientEmailInput = () -> waitAndFindElement(By.xpath("//*[@id='input-to-email']"));
    public Supplier<WebElement> yourNameInput = () -> waitAndFindElement(By.id("input-from-name"));
    public Supplier<WebElement> yourEmailInput = () -> waitAndFindElement(By.id("input-from-email"));
    public Supplier<WebElement> birthdayCertificate = () -> waitAndFindElement(By.xpath("//*[contains(text(), 'Birthday')]"));
    public Supplier<WebElement> christmasCertificate = () -> waitAndFindElement(By.xpath("//*[contains(text(), ' Christmas')]"));
    public Supplier<WebElement> generalCertificate = () -> waitAndFindElement(By.xpath("//*[contains(text(), ' General')]"));
    public Supplier<WebElement> amountCertificateInput = () -> waitAndFindElement(By.id("input-amount"));
    public Supplier<WebElement> messageCertificate = () -> waitAndFindElement(By.id("input-message"));
    public Supplier<WebElement> agreeGiftCertificate = () -> waitAndFindElement(By.name("agree"));

    public Supplier<WebElement> dateTimeElement(String dateTime) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr/td[@class='text-left' and contains(text(), '" + dateTime + "')]"));
    }

    public Supplier<WebElement> customerElement(String name) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr/td[@class='text-left' and contains(text(), '" + name + "')]"));
    }

    public Supplier<WebElement> giftPriceNameElement(String amount, String name) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//tr/td[@class='text-left' and contains(text(), '$" + amount + "}.00 Gift Certificate for " + name + "')]"));
    }

    public Supplier<WebElement> myAccountMenuSection() {
        return () -> browser.findElement(By.xpath("//ul[@class='navbar-nav horizontal']//li[.//a[contains(@href, 'account/account')]]")
        );
    }

    public Supplier<WebElement> myOrderHistoryButton() {
        return () -> browser.findElement(By.xpath("//aside[@id='column-right']//a[contains(normalize-space(@href),'account/order')]")
        );
    }

    public Supplier<WebElement> myVoucherButton() {
        return () -> myAccountMenuSection().get().findElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@href),'account/voucher')]"));
    }

    public Supplier<WebElement> returnOrderButton() {
        return () -> myAccountMenuSection().get().findElement(By.xpath("//div[@id='main-navigation']//a[contains(normalize-space(@href),'account/return')]"));
    }

    public Supplier<WebElement> removeButton = () -> waitAndFindElement(By.xpath("//button[contains(@onclick, 'voucher.remove')]"));


    public Supplier<WebElement> removedProduct(String product) {
        return () -> waitAndFindElement(By.xpath("//div[@id='content']//p[contains(text(), '" + product + "')]"));
    }
}



