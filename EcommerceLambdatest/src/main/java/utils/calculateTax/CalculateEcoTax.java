package utils.calculateTax;

import website.pages.productpage.ProductDetails;

import java.util.List;

public class CalculateEcoTax {

    public static double calculateEcoTax(List<ProductDetails> products) {
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
}