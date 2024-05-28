package website.pages.cartpage;

import lombok.Data;
import website.pages.productpage.ProductDetails;

import java.util.List;

@Data
public class CheckoutInformation {

    public List<ProductDetails> products;
    public double flatShippingRate;
    public double subTotal;
    private double ecoTax;
    private double vatTax;
    private double total;
    public String coupon;
    public String giftCertificate;
    public boolean isVatApplied;

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

    public double getFlatShippingRate() {
        return flatShippingRate = 5.00;
    }

    public double getSubTotal() {
        if (products == null) {
            return 0.0;
        }

        return products.stream().mapToDouble(ProductDetails::getTotal).sum();
    }

    public double getVatTax() {

        return Math.ceil(getSubTotal() * 0.20 + 1);
    }

    public double getTotal() {
        return (getFlatShippingRate() + getSubTotal() + getVatTax() + getEcoTax());
    }
}