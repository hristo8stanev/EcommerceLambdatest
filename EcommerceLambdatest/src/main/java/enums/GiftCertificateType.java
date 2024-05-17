package enums;

public enum GiftCertificateType {
    BIRTHDAY(" Birthday"),
    CHRISTMAS(" Christmas"),
    GENERAL(" General");

    public final String giftType;

    GiftCertificateType(String giftType) {
        this.giftType = giftType;
    }

    public String getGiftType() {
        return giftType;
    }
}
