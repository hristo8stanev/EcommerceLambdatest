package website.pages.myaccountpage;

import enums.ProductOpened;
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
    public ProductOpened productOpened;
    public String amount;
}