package factories;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import pages.cartpage.BillingInformation;
import pages.loginpage.LoginInformation;
import pages.registerpage.PersonalInformation;

public class CustomerFactory {
    private static final Faker faker = new Faker();

    public static PersonalInformation GenerateUserDetails() {

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setFirstName(faker.name().firstName());
        personalInformation.setLastName(faker.name().lastName());
        personalInformation.setEmail(faker.internet().emailAddress());
        personalInformation.setPassword(faker.internet().password());
        personalInformation.setConfirmPassword(personalInformation.getPassword());
        personalInformation.setTelephone(RandomStringUtils.randomNumeric(8));

        return personalInformation;
    }

    public static BillingInformation GenerateBillingAddress(String firstName, String lastName, String company, String address1, String address2, String city, String postCode, String country, String region)
    {
       BillingInformation billingInformation = new BillingInformation();
        billingInformation.setFirstName(firstName != null ? firstName : faker.name().firstName());
        billingInformation.setLastName(lastName != null ? lastName : faker.name().lastName());
        billingInformation.setCompany(company != null ? company : faker.company().name());
        billingInformation.setAddress1(address1 != null ? address1 : faker.address().streetAddress());
        billingInformation.setAddress2(address2 != null ? address2 : faker.address().secondaryAddress());
        billingInformation.setCity(city != null ? city : faker.address().cityName());
        billingInformation.setPostCode(postCode != null ? postCode : faker.address().countryCode());
        billingInformation.setCountry(country != null ? country : faker.country().name());
        billingInformation.setRegion(region != null ? region : faker.country().capital());

        return billingInformation;
    }
    public static LoginInformation loginUser(String email, String password)
    {
        var loginDetails = new LoginInformation();
        loginDetails.emailAddress = email;
        loginDetails.passwordField = password;

        return loginDetails;
    }

    public static LoginInformation BuildExistingCustomer()
    {
        //ToDo Implement
        var loginDetails = new LoginInformation();

        return loginDetails;
    }

    public static LoginInformation BuildNewCustomer()
    {
        //ToDo Implement
        var loginDetails = new LoginInformation();

        return loginDetails;
    }
}
