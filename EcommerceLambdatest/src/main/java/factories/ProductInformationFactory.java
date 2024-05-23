package factories;

import pages.productpage.ProductDetails;

import java.util.Arrays;

public class ProductInformationFactory {

    public static ProductDetails build(ProductDetails... products) {
        var productInfo = new ProductDetails();
        productInfo.products = (Arrays.asList(products));

        return productInfo;
    }
}