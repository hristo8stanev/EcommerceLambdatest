package enums;

public enum DifferentSizeType {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private String sizeType;

    DifferentSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public String getSizeType() {
        return sizeType;
    }
}
