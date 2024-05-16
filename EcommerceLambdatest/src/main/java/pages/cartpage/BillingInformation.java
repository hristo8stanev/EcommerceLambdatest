package pages.cartpage;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BillingInformation {
    public String firstName;
    public String lastName;
    public String company;
    public String address1;
    public String address2;
    public String city;
    public String postCode;
    public String country;
    public String region;
}