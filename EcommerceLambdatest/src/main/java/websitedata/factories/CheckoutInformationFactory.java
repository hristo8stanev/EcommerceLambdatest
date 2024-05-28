package websitedata.factories;

import website.pages.cartpage.CheckoutInformation;
import website.pages.productpage.ProductDetails;

import java.util.Arrays;

public class CheckoutInformationFactory {
    public static CheckoutInformation build(ProductDetails... products) {
        var checkoutInformation = new CheckoutInformation();
        checkoutInformation.products = (Arrays.asList(products));
        checkoutInformation.isVatApplied = true;

        return checkoutInformation;
    }

    public static CheckoutInformation buildWithCoupon(ProductDetails... products) {
        var checkoutInformation = build(products);
        checkoutInformation.coupon = "birthday";

        return checkoutInformation;
    }

    public static CheckoutInformation buildwithgiftcertificate(ProductDetails... products) {
        var checkoutInformation = build(products);
        checkoutInformation.giftCertificate = "giftCertificate";

        return checkoutInformation;
    }
}