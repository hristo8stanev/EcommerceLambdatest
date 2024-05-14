package pages.cartpage;

import lombok.Getter;
import lombok.Setter;
import pages.productpage.ProductDetails;

import java.util.List;

public class CheckoutInformation {

    @Getter
    @Setter
    public List<ProductDetails> products;
    @Getter
    @Setter
    public double flatShippingRate = 5.00;

    public double getSubTotal() {
        if (products == null) {
            return 0.0;
        }
        return products.stream().mapToDouble(ProductDetails::getTotal).sum();
    }

    @Setter
    private double ecoTax;

    public double getEcoTax() {
        int totalQuantity = 0;
        for (ProductDetails product : products) {
            int quantity = 0;
            try {
                quantity = Integer.parseInt(product.getQuantity());
            } catch (NumberFormatException ignored) {
            }
            totalQuantity += quantity;
        }

        double ecoTax = 4.00;
        int remainingQuantity = totalQuantity - 1;

        while (remainingQuantity > 0) {
            ecoTax += 2.00;
            remainingQuantity--;
        }

        return ecoTax;
    }

    @Setter
    private double vatTax;

    public double getVatTax() {
        return Math.ceil(getSubTotal() * 0.20 + 1);
    }

    @Setter
    private double total;

    public double getTotal() {
        return (flatShippingRate + getSubTotal() + getVatTax() + getEcoTax());
    }
    @Getter
    @Setter
    public String coupon;
    @Getter
    @Setter
    public String giftCertificate;
    @Getter
    @Setter
    public boolean isVatApplied;
}
