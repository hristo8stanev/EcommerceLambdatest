package factories;

import com.github.javafaker.Faker;

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
                .amount(RandomStringUtils.randomNumeric(2)).build();
    }
}
