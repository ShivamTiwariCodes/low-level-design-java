package problems.onlineshopping.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class InventoryService {

    // Requirements :
    // Thread-safe access to the product inventory.
    // Atomic check and update of product count (e.g., check stock > 0, then decrement).
    // Support high concurrency.
    // Minimize locking bottlenecks.
    // Tips for thread safety :
    // Never use Map<String, Integer> — Integer is immutable, not safe for concurrent mutation.
    // Avoid full synchronized blocks — they reduce scalability.
    // Use lock-free or fine-grained lock patterns (CAS, Atomic*, ReadWriteLock only when necessary).
    // Why this works :
    // ConcurrentHashMap ensures thread-safe access to the map.
    // AtomicInteger ensures atomic updates to the stock count.
    // compareAndSet prevents race conditions (CAS ensures correctness).
    private final ConcurrentHashMap<String, AtomicInteger> inventory;

    private static InventoryService inventoryServiceInstance;

    private InventoryService() {
        this.inventory = new ConcurrentHashMap<>();
    }

    public static InventoryService getInstance() {
        if (inventoryServiceInstance == null) {
            synchronized (InventoryService.class) {
                if (inventoryServiceInstance == null) {
                    inventoryServiceInstance = new InventoryService();
                }
            }
        }
        return inventoryServiceInstance;
    }

    public void addInventory(String productId, int count) {
        inventory.compute(productId, (id, currentCount) -> {
            if (currentCount == null) {
                return new AtomicInteger(count);
            }
            currentCount.addAndGet(count);
            return currentCount;
        });
    }

    // This doesn't guarantee FCFS, whoever will be done first with CAS, will get success
    public boolean buyProduct(String ProductId, int count) {
        AtomicInteger availableCount = inventory.get(ProductId);
        if (availableCount == null) {
            return false;
        }
        // if some thread came and buy, then if availability is there
        // this loop will help to retry
        while (true) {
            int currentCount = availableCount.get();
            if (currentCount < count) {
                return false;
            }
            if (availableCount.compareAndSet(currentCount, currentCount - count)) {
                return true;
            }
        }
    }

    // this way we achieve first come first serve
    // Other way of doing this is
    // 1. Blocking queue  
    // 2. Actor Model Approach (One Thread Per Product)
    private final ReentrantLock lock = new ReentrantLock(true); // true = fair lock

    public boolean buyProductFCFS1(String productId, int count) {
        lock.lock();
        try {
            AtomicInteger availableCount = inventory.get(productId);
            if (availableCount == null || availableCount.get() <= count) {
                return false;
            }
            availableCount.getAndAdd(-count);
            return true;
        } finally {
            lock.unlock();
        }
    }

}
