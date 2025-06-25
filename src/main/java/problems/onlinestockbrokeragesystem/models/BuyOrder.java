package problems.onlinestockbrokeragesystem.models;

import problems.onlinestockbrokeragesystem.OnlineStockBrokerageSystem;
import problems.onlinestockbrokeragesystem.service.AccountService;

import java.math.BigDecimal;

public class BuyOrder extends Order{

    public BuyOrder(String userId, String stockId, int stocksCount) {
        super(userId, stockId, stocksCount);
    }

    @Override
    public void execute(OnlineStockBrokerageSystem onlineStockBrokerageSystem,
                        AccountService accountService) {
        Stock stock = onlineStockBrokerageSystem.getStock(stockId);
        BigDecimal totalAmount = stock.getPrice().multiply(new BigDecimal(stocksCount));

        boolean isWithdrawn = false, isStocksAdded = false, isInventoryDecreased = false;

        try {

//          decrease count from central system
            onlineStockBrokerageSystem.decreaseInventory(stock, stocksCount);
            isInventoryDecreased = true;

//          withdraw
            accountService.withdraw(userId, totalAmount);
            isWithdrawn = true;

//          add stocks
            accountService.addStock(userId, stockId, stocksCount);
            isStocksAdded = true;

            orderStatus = OrderStatus.EXECUTED;
        } catch (Exception ex) {

            if(isInventoryDecreased) {
                onlineStockBrokerageSystem.addInventory(stock, stocksCount);
            }

            if(isWithdrawn) {
                accountService.deposit(userId, totalAmount);
            }

            if(isStocksAdded) {
                accountService.removeStock(userId, stockId, stocksCount);
            }

            orderStatus = OrderStatus.CANCELLED;
        }
    }
}
