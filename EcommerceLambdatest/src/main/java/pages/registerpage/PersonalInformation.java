package pages.registerpage;

import enums.AccountType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PersonalInformation {
    public String firstName;
    public String lastName;
    public String email;
    public String telephone;
    public String password;
    public AccountType accountType;
}
