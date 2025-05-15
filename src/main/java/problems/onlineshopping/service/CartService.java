package problems.onlineshopping.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import problems.onlineshopping.model.Cart;
import problems.onlineshopping.model.User;

public class CartService {

    private static CartService cartServiceInstance;
    private Map<String, Cart> carts;

    private CartService() {
        // ConcurrentHashMap ensures safe concurrent access to the carts map itself.
        // So, putting and getting carts (e.g., carts.get(userId)) is thread-safe.
        // HashMap is not synchronized, 
        // 1. so two threads may see the same key as "absent" and both try to insert new Cart() objects.
        // 2. Concurrent writes (like putting/removing keys) can corrupt the internal hash table.
        // 3. May encounter ConcurrentModificationException, NullPointerException (due to partially initialized entries)
        // or IllegalStateException (hash bucket chains getting into invalid states)
        this.carts = new ConcurrentHashMap<>();
    }

    public static CartService getInstance() {
        if (cartServiceInstance == null) {
            synchronized (CartService.class) {
                if (cartServiceInstance == null) {
                    cartServiceInstance = new CartService();
                }
            }
        }
        return cartServiceInstance;
    }

    public Cart getCart(User user) {
        return carts.computeIfAbsent(user.getId(), id -> new Cart());
    }

    public void addItemToCart(User user, String productId, int count) {
        Cart cart = carts.computeIfAbsent(user.getId(), id -> new Cart());
        cart.addItem(productId, count);
    }
}
