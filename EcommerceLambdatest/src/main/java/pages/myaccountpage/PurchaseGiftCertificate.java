package pages.myaccountpage;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PurchaseGiftCertificate {
    public String recipientName;
    public String recipientEmail;
    public String yourName;
    public String yourEmail;
    public PurchaseGiftCertificate giftCertificateType;
    public String amount;
}
