package pages.cartpage;


import lombok.Data;
import lombok.experimental.SuperBuilder;
import pages.productpage.ProductDetails;

import java.util.List;
//TO do
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

    public List<ProductDetails> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetails> products) {
        this.products = products;
    }

    public boolean isVatApplied() {
        return isVatApplied;
    }

    public void setVatApplied(boolean vatApplied) {
        isVatApplied = vatApplied;
    }

    public String getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(String giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

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

    public void setEcoTax(double ecoTax) {
        this.ecoTax = ecoTax;
    }

    public double getFlatShippingRate() {
        return flatShippingRate = 5.00;
    }

    public void setFlatShippingRate(double flatShippingRate) {
        this.flatShippingRate = flatShippingRate;
    }

    public double getSubTotal() {
        if (products == null) {
          return 0.0;
      }
      return products.stream().mapToDouble(ProductDetails::getTotal).sum();
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getVatTax() {
        return Math.ceil(getSubTotal() * 0.20 + 1);
    }

    public void setVatTax(double vatTax) {
        this.vatTax = vatTax;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public double getTotal() {
        return (flatShippingRate + getSubTotal() + getVatTax() + getEcoTax());
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

//  @Getter
//  @Setter
//  public List<ProductDetails> products;
//  @Getter
//  @Setter
//  public double flatShippingRate = 5.00;

//  public double getSubTotal() {
//      if (products == null) {
//          return 0.0;
//      }
//      return products.stream().mapToDouble(ProductDetails::getTotal).sum();
//  }

//  @Setter
//  private double ecoTax;

//  public double getEcoTax() {
//      int totalQuantity = 0;
//      for (ProductDetails product : products) {
//          int quantity = 0;
//          try {
//              quantity = Integer.parseInt(product.getQuantity());
//          } catch (NumberFormatException ignored) {
//          }
//          totalQuantity += quantity;
//      }

//      double ecoTax = 4.00;
//      int remainingQuantity = totalQuantity - 1;

//      while (remainingQuantity > 0) {
//          ecoTax += 2.00;
//          remainingQuantity--;
//      }

//      return ecoTax;
//  }

//  @Setter
//  private double vatTax;

//  public double getVatTax() {
//      return Math.ceil(getSubTotal() * 0.20 + 1);
//  }

//  @Setter
//  private double total;

//  public double getTotal() {
//      return (flatShippingRate + getSubTotal() + getVatTax() + getEcoTax());
//  }
//  @Getter
//  @Setter
//  public String coupon;
//  @Getter
//  @Setter
//  public String giftCertificate;
//  @Getter
//  @Setter
//  public boolean isVatApplied;
//
