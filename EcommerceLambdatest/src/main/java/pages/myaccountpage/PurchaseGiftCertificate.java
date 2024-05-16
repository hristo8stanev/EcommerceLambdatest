package pages.myaccountpage;

import lombok.Data;

@Data
public class PurchaseGiftCertificate {
    public String recipientName;
    public String recipientEmail;
    public String yourName;
    public String yourEmail;
    public PurchaseGiftCertificate giftCertificateType;
    public String amount;
}
