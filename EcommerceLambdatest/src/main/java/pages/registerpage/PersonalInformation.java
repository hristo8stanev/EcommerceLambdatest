package pages.registerpage;

import enums.DifferentAccountType;
import lombok.Getter;
import lombok.Setter;


public class PersonalInformation {
    @Getter
    @Setter
    public String firstName;
    @Getter
    @Setter
    public String lastName;
    @Getter
    @Setter
    public String email;
    @Getter
    @Setter
    public String telephone;
    @Getter
    @Setter
    public String password;
    @Getter
    @Setter
    public String confirmPassword;
    @Getter
    @Setter
    public DifferentAccountType accountType;
}
