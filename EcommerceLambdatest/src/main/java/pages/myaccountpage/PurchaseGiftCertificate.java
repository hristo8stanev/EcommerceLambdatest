package pages.myaccountpage;

import lombok.Getter;
import lombok.Setter;

public class PurchaseGiftCertificate {

    @Getter
    @Setter
    public String RecipientName;
    @Getter
    @Setter
    public String RecipientEmail;
    @Getter
    @Setter
    public String YourName;
    @Getter
    @Setter
    public String YourEmail;
    @Getter
    @Setter
    public PurchaseGiftCertificate GiftCertificateType;
    @Getter
    @Setter
    public String Amount;
}
