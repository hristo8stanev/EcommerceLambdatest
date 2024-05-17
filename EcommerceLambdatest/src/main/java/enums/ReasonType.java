package enums;

public enum ReasonType {
    DEAD_ON_ARRIVAL(1),
    FAULTY_PLEASE_SUPPLY_DETAILS(2),
    ORDER_ERROR(3),
    OTHER_PLEASE_SUPPLY_DETAILS(4),
    RECEIVED_WRONG_ITEM(5);

    public final int reasonType;

    ReasonType(int reasonType) {
        this.reasonType = reasonType;
    }

    public int getReasonType() {
        return reasonType;
    }
}
