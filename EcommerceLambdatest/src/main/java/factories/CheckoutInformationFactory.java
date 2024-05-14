package factories;

import pages.cartpage.CheckoutInformation;
import pages.productpage.ProductDetails;

import java.util.Arrays;

public class CheckoutInformationFactory {
    public static CheckoutInformation Build(ProductDetails... products)
    {
        var checkoutInformation = new CheckoutInformation();
        checkoutInformation.products = (Arrays.asList(products));
        checkoutInformation.isVatApplied = true;

        return checkoutInformation;
    }

    public static CheckoutInformation BuildWithCoupon(ProductDetails... products)
    {
        var checkoutInformation = Build(products);
        checkoutInformation.coupon = "birthday";

        return checkoutInformation;
    }
    public static CheckoutInformation BuildWithGiftCertificate(ProductDetails... products)
    {
        var checkoutInformation = Build(products);
        checkoutInformation.giftCertificate = "giftCertificate";

        return checkoutInformation;
    }

}
