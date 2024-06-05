package enums;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private String sizeType;

    Size(String sizeType) {
        this.sizeType = sizeType;
    }

    public String getSizeType() {
        return sizeType;
    }
}