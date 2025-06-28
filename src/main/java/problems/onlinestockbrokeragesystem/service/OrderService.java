package problems.onlinestockbrokeragesystem.service;

import problems.onlinestockbrokeragesystem.OnlineStockBrokerageSystem;
import problems.onlinestockbrokeragesystem.models.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class OrderService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(20);

    private static OrderService orderServiceInstance;
    private AccountService accountService;
    private OnlineStockBrokerageSystem onlineStockBrokerageSystem;
    private Map<String, Order> orders;

    private final Object lock = new Object();

    private OrderService(){
        this.orders = new ConcurrentHashMap<>();
        this.accountService = AccountService.getInstance();
        this.onlineStockBrokerageSystem = OnlineStockBrokerageSystem.getInstance();
    }

    public static OrderService getInstance() {
        if(orderServiceInstance == null) {
            synchronized (OrderService.class) {
                if(orderServiceInstance == null) {
                    orderServiceInstance = new OrderService();
                }
            }
        }
        return orderServiceInstance;
    }


    public void buy(User user, Stock stock, int count) {
        Order order = new BuyOrder(user.getUserId(), stock.getStockId(), count);
        orders.put(order.getOrderId(), order);
//        order.execute(onlineStockBrokerageSystem, accountService);
        placeOrder(order);
    }

    public void sell(User user, Stock stock, int count) {
        Order order = new SellOrder(user.getUserId(), stock.getStockId(), count);
        orders.put(order.getOrderId(), order);
//        order.execute(onlineStockBrokerageSystem, accountService);
        placeOrder(order);
    }

    public void placeOrder(Order order) {
        executorService.submit(() -> {
            try {
                order.execute(onlineStockBrokerageSystem, accountService);
            } catch (Exception e) {
                System.err.println("Order " + order.getOrderId() + " failed: " + e.getMessage());
            }
        });
    }
}
