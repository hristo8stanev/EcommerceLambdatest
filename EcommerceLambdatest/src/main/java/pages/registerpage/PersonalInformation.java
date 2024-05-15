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
    public Boolean isPasswordVisible = false;
    public Boolean isPrivacyVisible = false;

    public Boolean getPasswordVisible() {
        return isPasswordVisible;
    }

    public void setPasswordVisible(Boolean passwordVisible) {
        this.isPasswordVisible = passwordVisible;
    }

    public Boolean getPrivacyVisible() {
        return isPrivacyVisible;
    }

    public void setPrivacyVisible(Boolean privacyVisible) {
        this.isPrivacyVisible = privacyVisible;
    }
}
