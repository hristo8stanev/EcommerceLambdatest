package pages.myaccountpage;

import lombok.Getter;
import lombok.Setter;

public class PurchaseGiftCertificate {

    @Getter
    @Setter
    public String recipientName;
    @Getter
    @Setter
    public String recipientEmail;
    @Getter
    @Setter
    public String yourName;
    @Getter
    @Setter
    public String yourEmail;
    @Getter
    @Setter
    public PurchaseGiftCertificate giftCertificateType;
    @Getter
    @Setter
    public String amount;
}
