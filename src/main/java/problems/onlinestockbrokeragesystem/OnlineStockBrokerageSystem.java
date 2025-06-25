package problems.onlinestockbrokeragesystem;

import problems.onlinestockbrokeragesystem.exceptions.InsufficientStockException;
import problems.onlinestockbrokeragesystem.models.Stock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineStockBrokerageSystem {

    private volatile Map<String, Stock> stocks;
    private volatile Map<String, Integer> inventory;

    private final Object lock = new Object();

//    if writes are rare
//    Map<String, Stock> updated = new HashMap<>(stocks);
//    updated.put("AAPL", new Stock(...));
//    stocks = Collections.unmodifiableMap(updated);

    private static volatile OnlineStockBrokerageSystem onlineStockBrokerageSystemInstance;

    private OnlineStockBrokerageSystem(){
        stocks = new ConcurrentHashMap<>();
        inventory = new ConcurrentHashMap<>();
    }

    public static OnlineStockBrokerageSystem getInstance() {
        if(onlineStockBrokerageSystemInstance == null) {
            synchronized (OnlineStockBrokerageSystem.class) {
                if(onlineStockBrokerageSystemInstance == null) {
                    onlineStockBrokerageSystemInstance = new OnlineStockBrokerageSystem();
                }
            }
        }
        return onlineStockBrokerageSystemInstance;
    }

    public void addInventory(Stock stock, int count) {
        synchronized (lock) {
            stocks.putIfAbsent(stock.getStockId(), stock);
            inventory.put(stock.getStockId(), inventory.getOrDefault(stock.getStockId(), 0)+ count);
        }

    }

    public Stock getStock(String stockId) {
        return stocks.get(stockId);
    }

    public void decreaseInventory(Stock stock, int count) throws InsufficientStockException {
        synchronized (lock) {
            if(inventory.containsKey(stock.getStockId()) && inventory.get(stock.getStockId())-count >= 0) {
                inventory.put(stock.getStockId(), inventory.getOrDefault(stock.getStockId(), 0) - count);
            } else {
                throw new InsufficientStockException();
            }
        }
    }

}
