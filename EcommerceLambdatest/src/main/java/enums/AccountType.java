package enums;

public enum AccountType {
    LOGIN("Login"),
    REGISTER("Register Account"),
    GUEST("Guest Checkout");

    private final String displayName;

    AccountType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
