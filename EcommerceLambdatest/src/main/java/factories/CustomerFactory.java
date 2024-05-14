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

    public static BillingInformation GenerateBillingAddress(){
       BillingInformation billingInformation = new BillingInformation();
        billingInformation.setFirstName(faker.name().firstName());
        billingInformation.setLastName(faker.name().lastName());
        billingInformation.setCompany(faker.company().name());
        billingInformation.setAddress1(faker.address().streetAddress());
        billingInformation.setAddress2(faker.address().secondaryAddress());
        billingInformation.setCity(faker.address().cityName());
        billingInformation.setPostCode(faker.address().countryCode());
        billingInformation.setCountry("United States");
        billingInformation.setRegion("California");

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
