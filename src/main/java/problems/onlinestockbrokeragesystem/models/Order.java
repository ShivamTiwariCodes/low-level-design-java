package problems.onlinestockbrokeragesystem.models;

import problems.onlinestockbrokeragesystem.OnlineStockBrokerageSystem;
import problems.onlinestockbrokeragesystem.service.AccountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public abstract class Order {

    protected String orderId;
    protected String stockId;
    protected int stocksCount;
    protected String userId;
    protected BigDecimal totalAmount;
    protected OrderStatus orderStatus;

    public Order(String userId, String stockId, int stocksCount) {
        this.orderId = UUID.randomUUID().toString();
        this.stockId = stockId;
        this.stocksCount = stocksCount;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderStatus = OrderStatus.PENDING;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    private BigDecimal getTotalAmount() {
        return totalAmount;
    }

    private OrderStatus getOrderStatus() {
        return orderStatus;
    }


    public abstract void execute(OnlineStockBrokerageSystem onlineStockBrokerageSystem,
                                 AccountService accountService);
}
