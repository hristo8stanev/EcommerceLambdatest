package websitedata.factories;

import com.github.javafaker.Faker;

import enums.ProductOpened;
import website.pages.myaccountpage.PurchaseGiftCertificate;

public class GiftCertificateFactory {

    private static final Faker faker = new Faker();

    public static PurchaseGiftCertificate generateGiftCertificate(ProductOpened productOpened) {
        return PurchaseGiftCertificate.builder()
                .recipientName(faker.name().nameWithMiddle())
                .recipientEmail(faker.internet().emailAddress())
                .yourName(faker.name().firstName())
                .yourEmail(faker.internet().emailAddress())
                .productOpened(productOpened)
                .amount(String.valueOf(faker.number().numberBetween(1, 900))).build();
    }
}
