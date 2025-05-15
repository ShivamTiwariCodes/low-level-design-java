package problems.onlineshopping.model;

import common.utils.TextUtil;

public class Product {

    private String id;
    private String name;
    private String description;
    private ProductType productType;
    private double price;

    public Product(String name, String description, ProductType productType, double price) {
        this.id = TextUtil.generateRandomText(5);
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
