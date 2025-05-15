package problems.onlineshopping.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class Cart {

    // why Map<ProductId, Integer> productsMap; not Map<Product, Integer> productsMap;
    // Advantages:
    // Lightweight keys → avoids hashing/comparing full Product objects.
    // Stable identity → product IDs don’t change, even if Product fields do.
    // Avoids equals/hashCode complexity → no risk of incorrect map behavior due to mutable fields in Product.
    // Better for distributed systems → you can easily pass product IDs over the network, or serialize them.
    // Disadvantages:
    // Heavy key objects → more memory, slower hash/equals.
    // Brittle if Product is mutable → even changing name/price could break map behavior if not handled carefully.
    // Harder to debug issues from duplicate or "invisible" keys due to poor equals/hashCode.
    // Use Only If:
    // Product is immutable (final fields, no setters).
    // You have a specific reason to attach metadata directly in the map.
    Map<String, Integer> items;
    Map<String, Integer> saveForLaterMap;
    private final StampedLock lock = new StampedLock();

    public Cart() {
        this.items = new HashMap<>();
        this.saveForLaterMap = new HashMap<>();
    }

    public void saveForLater(String productId) {
        long stamp = lock.writeLock();
        try {
            if (!items.containsKey(productId)) {
                return;
            }
            saveForLaterMap.put(productId, items.get(productId));
            items.remove(productId);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public Map<String, Integer> checkout() {
        long stamp = lock.writeLock();
        try {
            Map<String, Integer> products = new HashMap<>(items);
            items.clear();
            items.putAll(saveForLaterMap);
            saveForLaterMap.clear();
            return products;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public void addItem(String productId, int count) {
        // why lock inside try finally block
        // try-finally guarantees that unlockWrite(stamp) is always executed.
        // Even if the line inside the try block throws a runtime exception like:

        // 1. NullPointerException
        // 2. ConcurrentModificationException
        // 3. or any other unchecked exception
        // ...the lock will still be safely released in the finally block.
        // other deadlock or Unrecoverable bug might occur
        long stamp = lock.writeLock();
        try {
            items.put(productId, items.getOrDefault(productId, 0) + count);
        } finally {
            lock.unlock(stamp);
        }
    }

    public Map<String, Integer> viewCart() {
        long stamp = lock.tryOptimisticRead();
        Map<String, Integer> snapshot = new HashMap<>(items);
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                snapshot = new HashMap<>(items);
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return snapshot;
    }

}
