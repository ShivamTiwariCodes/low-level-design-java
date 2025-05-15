package problems.onlineshopping.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import problems.onlineshopping.model.Product;

public class ProductService {

    private static ProductService productServiceInstance;
    private Map<String, Product> products;

    private ProductService() {
        this.products = new ConcurrentHashMap<>();
    }

    public static ProductService getInstance() {
        if (productServiceInstance == null) {
            synchronized (UserService.class) {
                if (productServiceInstance == null) {
                    productServiceInstance = new ProductService();
                }
            }
        }
        return productServiceInstance;
    }

    public void addProduct(Product product) {
        products.putIfAbsent(product.getId(), product);
    }

    public Product getProductById(String productId) {
        return products.get(productId);
    }

}
