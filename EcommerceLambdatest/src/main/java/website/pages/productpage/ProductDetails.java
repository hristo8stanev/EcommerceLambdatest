package website.pages.productpage;

import lombok.Data;

import java.util.List;

@Data
public class ProductDetails {

    public List<ProductDetails> products;
    public String name;
    public int id;
    public String unitPrice;
    public String model;
    public String brand;
    public String availability;
    public String weight;
    public String quantity;
    public String size;
    public double total;
}