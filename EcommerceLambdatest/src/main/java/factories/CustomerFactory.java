package factories;

import com.github.javafaker.Faker;
import enums.AccountType;
import org.apache.commons.lang.RandomStringUtils;
import pages.cartpage.BillingInformation;
import pages.registerpage.PersonalInformation;

public class CustomerFactory {

    private static final Faker faker = new Faker();

    protected static PersonalInformation.PersonalInformationBuilder<?, ?> GenerateCorePersonalInformation() {
        return PersonalInformation.builder()
                .accountType(AccountType.GUEST)
                .firstName(faker.name().firstName())
                .email(faker.internet().emailAddress())
                .telephone(RandomStringUtils.randomNumeric(8))
                .lastName(faker.name().lastName());
    }

    public static PersonalInformation GenerateRegisterAccount() {
        return GenerateCorePersonalInformation()
                .password(faker.internet().password())
                .accountType(AccountType.REGISTER)
                .build();
    }

    public static PersonalInformation GenerateGuestCheckout() {
        return GenerateCorePersonalInformation().accountType(AccountType.GUEST).build();
    }

    public static PersonalInformation GenerateLoginCheckout(String email, String password) {
        return GenerateCorePersonalInformation().accountType(AccountType.LOGIN).email(email).password(password).build();
    }

    public static BillingInformation GenerateBillingAddress() {
        return BillingInformation.builder().firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .company(faker.company().name())
                .address1(faker.address().streetAddress())
                .address2(faker.address().secondaryAddress())
                .city(faker.address().cityName())
                .postCode(faker.address().countryCode())
                .country("United Kingdom").region("London").build();
    }

    public static PersonalInformation loginUser(String email, String password) {
        return PersonalInformation.builder().email(email).password(password).build();
    }
}
