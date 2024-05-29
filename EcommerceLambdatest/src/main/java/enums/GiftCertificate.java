package enums;

public enum GiftCertificate {
    BIRTHDAY(" Birthday"),
    CHRISTMAS(" Christmas"),
    GENERAL(" General");

    public final String giftType;

    GiftCertificate(String giftType) {
        this.giftType = giftType;
    }

    public String getGiftType() {
        return giftType;
    }
}
