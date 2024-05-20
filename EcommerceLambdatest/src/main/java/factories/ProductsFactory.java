package factories;

import pages.productpage.ProductDetails;

public class ProductsFactory {
    public static ProductDetails NikonProduct() {
        var productDetails = new ProductDetails();
        productDetails.name = "Nikon D300";
        productDetails.brand = "Nikon";
        productDetails.weight = "0.00kg";
        productDetails.id = 31;
        productDetails.availability = "In Stock";
        productDetails.unitPrice = "$80.00";
        productDetails.model = "Product 4";
        productDetails.quantity = "4";
        var parsedQuantity = ParseQuantity(productDetails);
        var parsedUnitPrice = ParseUnitPrice(productDetails);
        productDetails.total = parsedQuantity * parsedUnitPrice;

        return productDetails;
    }

    public static ProductDetails HtcTouch() {
        var productDetails = new ProductDetails();
        productDetails.name = "HTC Touch HD";
        productDetails.brand = "HTC";
        productDetails.weight = "146.40g";
        productDetails.id = 28;
        productDetails.availability = "In Stock";
        productDetails.unitPrice = "$146.00";
        productDetails.model = "Product 1";
        productDetails.quantity = "3";
        var parsedQuantity = ParseQuantity(productDetails);
        var parsedUnitPrice = ParseUnitPrice(productDetails);
        productDetails.total = parsedQuantity * parsedUnitPrice;

        return productDetails;
    }

    public static ProductDetails SamsungSyncMaster() {
        var productDetails = new ProductDetails();
        productDetails.name = "Samsung SyncMaster 941BW";
        productDetails.brand = "Canon";
        productDetails.weight = "5.00kg";
        productDetails.id = 66;
        productDetails.availability = "In Stock";
        productDetails.unitPrice = "$242.00";
        productDetails.model = "Product 6";
        productDetails.quantity = "2";
        var parsedQuantity = ParseQuantity(productDetails);
        var parsedUnitPrice = ParseUnitPrice(productDetails);
        productDetails.total = parsedQuantity * parsedUnitPrice;

        return productDetails;
    }

    public static ProductDetails iPodNano() {
        var productDetails = new ProductDetails();
        productDetails.name = "iPod Nano";
        productDetails.brand = "Apple";
        productDetails.weight = "5.00kg";
        productDetails.id = 36;
        productDetails.availability = "In Stock";
        productDetails.unitPrice = "$122.00";
        productDetails.model = "Product 9";
        productDetails.quantity = "3";
        double parsedQuantity = ParseQuantity(productDetails);
        double parsedUnitPrice = ParseUnitPrice(productDetails);
        productDetails.total = parsedQuantity * parsedUnitPrice;

        return productDetails;
    }

    public static ProductDetails AppleProduct() {
        var productDetails = new ProductDetails();
        productDetails.name = "Apple Cinema 30";
        productDetails.brand = "Apple";
        productDetails.weight = "0.00kg";
        productDetails.id = 42;
        productDetails.availability = "In Stock";
        productDetails.unitPrice = "$76.00";
        productDetails.model = "Product 15";
        productDetails.quantity = "6";
        productDetails.size = "Size: Medium";
        var parsedQuantity = ParseQuantity(productDetails);
        var parsedUnitPrice = ParseUnitPrice(productDetails);
        productDetails.total = parsedQuantity * parsedUnitPrice;

        return productDetails;
    }

    public static ProductDetails IPodShuffleProduct() {
        var productDetails = new ProductDetails();
        productDetails.name = "iPod Shuffle";
        productDetails.brand = "Apple";
        productDetails.weight = "5.00kg";
        productDetails.id = 34;
        productDetails.availability = "In Stock";
        productDetails.unitPrice = "$182.00";
        productDetails.model = "Product 7";
        productDetails.quantity = "5";
        var parsedQuantity = ParseQuantity(productDetails);
        var parsedUnitPrice = ParseUnitPrice(productDetails);
        productDetails.total = parsedQuantity * parsedUnitPrice;

        return productDetails;
    }

    public static ProductDetails BoschProduct() {
        var productDetails = new ProductDetails();
        productDetails.name = "Bosch";
        productDetails.brand = "Bosch";
        productDetails.weight = "0.00kg";
        productDetails.id = 929;
        productDetails.availability = "In Stock";
        productDetails.unitPrice = "$2983.00";
        productDetails.model = "Product 151";
        productDetails.quantity = "16";
        var parsedQuantity = ParseQuantity(productDetails);
        var parsedUnitPrice = ParseUnitPrice(productDetails);
        productDetails.total = parsedQuantity * parsedUnitPrice;

        return productDetails;
    }

    private static double ParseUnitPrice(ProductDetails productDetails) {
        double parsedUnitPrice;

        try {
            parsedUnitPrice = Double.parseDouble(productDetails.getUnitPrice().replace("$", ""));
        } catch (NumberFormatException e) {
            parsedUnitPrice = 0.0;
        }
        return parsedUnitPrice;
    }

    private static double ParseQuantity(ProductDetails productDetails) {
        double parsedQuantity;

        try {
            parsedQuantity = Double.parseDouble(productDetails.getQuantity());
        } catch (NumberFormatException e) {
            parsedQuantity = 0.0;
        }
        return parsedQuantity;
    }
}
