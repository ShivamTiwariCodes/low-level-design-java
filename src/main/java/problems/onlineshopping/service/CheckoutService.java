package problems.onlineshopping.service;

import java.util.HashMap;
import java.util.Map;

import problems.onlineshopping.model.Cart;
import problems.onlineshopping.model.Order;
import problems.onlineshopping.model.Product;
import problems.onlineshopping.model.User;

public class CheckoutService {

    private static CheckoutService checkoutServiceInstance;

    private CheckoutService() {
    }

    public static CheckoutService getInstance() {
        if (checkoutServiceInstance == null) {
            synchronized (CheckoutService.class) {
                if (checkoutServiceInstance == null) {
                    checkoutServiceInstance = new CheckoutService();
                }
            }
        }
        return checkoutServiceInstance;
    }

    public Order checkout(User user) {
        CartService cartService = CartService.getInstance();
        ProductService productService = ProductService.getInstance();
        OrderService orderService = OrderService.getInstance();
        Cart cart = cartService.getCart(user);
        Map<String, Integer> products = cart.checkout();
        Map<Product, Integer> productsToCheckout = new HashMap<>();
        for (Map.Entry<String, Integer> en : products.entrySet()) {
            productsToCheckout.put(productService.getProductById(en.getKey()), en.getValue());
        };
        Order order = new Order(productsToCheckout, getTotal(productsToCheckout));
        // orderService.
        return order;
    }

    private double getTotal(Map<Product, Integer> products) {
        double amount = 0;
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            amount += e.getKey().getPrice() * e.getValue();
            System.out.println(amount);
        }
        return amount;
    }

}
