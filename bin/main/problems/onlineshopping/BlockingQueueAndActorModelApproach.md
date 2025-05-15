Here’s how to implement the `buyProduct()` operation using both:

---

## ✅ 1. **Blocking Queue Approach (High-Level FCFS)**

In this design:

* Each buy request is put into a queue.
* A background worker processes them one by one.
* This ensures **first-come-first-served fairness**.

### ✅ Classes

```java
class BuyRequest {
    String productId;
    CompletableFuture<Boolean> response;

    public BuyRequest(String productId) {
        this.productId = productId;
        this.response = new CompletableFuture<>();
    }
}
```

### ✅ Inventory Service with Queue Worker

```java
public class InventoryService {
    private final Map<String, AtomicInteger> productInventory = new ConcurrentHashMap<>();
    private final BlockingQueue<BuyRequest> requestQueue = new LinkedBlockingQueue<>();

    public InventoryService() {
        // Start the background worker thread
        Thread worker = new Thread(this::processRequests);
        worker.setDaemon(true);
        worker.start();
    }

    public void addProduct(String productId, int quantity) {
        productInventory.put(productId, new AtomicInteger(quantity));
    }

    public CompletableFuture<Boolean> buyProductAsync(String productId) {
        BuyRequest request = new BuyRequest(productId);
        requestQueue.offer(request);
        return request.response;
    }

    private void processRequests() {
        while (true) {
            try {
                BuyRequest request = requestQueue.take();
                AtomicInteger count = productInventory.get(request.productId);
                if (count == null || count.get() <= 0) {
                    request.response.complete(false);
                } else {
                    count.decrementAndGet();
                    request.response.complete(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

### ✅ Usage

```java
InventoryService service = new InventoryService();
service.addProduct("p1", 2);

CompletableFuture<Boolean> result = service.buyProductAsync("p1");
result.thenAccept(success -> System.out.println("Buy success: " + success));
```

---

## ✅ 2. **Actor Model Approach (One Thread Per Product)**

Each product is managed by a dedicated thread ("actor") that:

* Accepts buy requests
* Processes them one at a time
* Keeps its own local state

---

### ✅ Buy Request

```java
class ProductBuyRequest {
    CompletableFuture<Boolean> response;

    public ProductBuyRequest() {
        this.response = new CompletableFuture<>();
    }
}
```

---

### ✅ Product Actor

```java
class ProductActor implements Runnable {
    private final String productId;
    private final BlockingQueue<ProductBuyRequest> requestQueue = new LinkedBlockingQueue<>();
    private int stock;

    public ProductActor(String productId, int initialStock) {
        this.productId = productId;
        this.stock = initialStock;
        new Thread(this).start(); // Starts actor thread
    }

    public CompletableFuture<Boolean> handleBuy() {
        ProductBuyRequest req = new ProductBuyRequest();
        requestQueue.offer(req);
        return req.response;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ProductBuyRequest request = requestQueue.take();
                if (stock > 0) {
                    stock--;
                    request.response.complete(true);
                } else {
                    request.response.complete(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

---

### ✅ Inventory Manager

```java
class InventoryActorService {
    private final Map<String, ProductActor> productActors = new ConcurrentHashMap<>();

    public void addProduct(String productId, int initialStock) {
        productActors.put(productId, new ProductActor(productId, initialStock));
    }

    public CompletableFuture<Boolean> buyProductAsync(String productId) {
        ProductActor actor = productActors.get(productId);
        if (actor == null) {
            CompletableFuture<Boolean> fail = new CompletableFuture<>();
            fail.complete(false);
            return fail;
        }
        return actor.handleBuy();
    }
}
```

---

### ✅ Usage

```java
InventoryActorService service = new InventoryActorService();
service.addProduct("p1", 1);

CompletableFuture<Boolean> result = service.buyProductAsync("p1");
result.thenAccept(System.out::println);  // prints true
```

---

## 🔍 Summary

| Approach       | Ensures FCFS | Scales Per Product         | Thread-safe | Notes                    |
| -------------- | ------------ | -------------------------- | ----------- | ------------------------ |
| Blocking Queue | ✅            | ❌ (single global queue)    | ✅           | Simple centralized queue |
| Actor Model    | ✅            | ✅ (one thread per product) | ✅           | Good for many products   |
