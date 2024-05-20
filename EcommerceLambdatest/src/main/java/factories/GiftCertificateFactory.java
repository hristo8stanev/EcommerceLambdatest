package factories;

import com.github.javafaker.Faker;

import enums.ProductOpened;
import org.apache.commons.lang.RandomStringUtils;
import pages.myaccountpage.PurchaseGiftCertificate;

public class GiftCertificateFactory {

    private static final Faker faker = new Faker();

    public static PurchaseGiftCertificate generateGiftCertificate() {
        return PurchaseGiftCertificate.builder()
                .recipientName(faker.name().nameWithMiddle())
                .recipientEmail(faker.internet().emailAddress())
                .yourName(faker.name().firstName())
                .yourEmail(faker.internet().emailAddress())
                .productOpened(ProductOpened.YES)
                .amount(RandomStringUtils.randomNumeric(2)).build();
    }
}
