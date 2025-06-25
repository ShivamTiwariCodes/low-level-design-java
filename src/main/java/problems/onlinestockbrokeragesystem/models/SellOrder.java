package problems.onlinestockbrokeragesystem.models;

import problems.onlinestockbrokeragesystem.OnlineStockBrokerageSystem;
import problems.onlinestockbrokeragesystem.service.AccountService;

import java.math.BigDecimal;
import java.util.List;

public class SellOrder extends Order{

    public SellOrder(String userId, String stockId, int stocksCount) {
        super(userId, stockId, stocksCount);
    }

    @Override
    public void execute(OnlineStockBrokerageSystem onlineStockBrokerageSystem,
                        AccountService accountService) {
        Stock stock = onlineStockBrokerageSystem.getStock(stockId);
        BigDecimal totalAmount = stock.getPrice().multiply(new BigDecimal(stocksCount));

        boolean stocksRemoved = false, isDeposited = false, isInventoryAdded = false;

        try {
//          withdraw and add stock
            accountService.removeStock(userId, stockId, stocksCount);
            stocksRemoved = true;

//          amount deposited
            accountService.deposit(userId, totalAmount);
            isDeposited = true;

//          decrese count from central system
            onlineStockBrokerageSystem.addInventory(stock, stocksCount);
            isInventoryAdded = true;

            orderStatus = OrderStatus.EXECUTED;
        } catch (Exception ex) {

            if(stocksRemoved) {
                accountService.addStock(userId, stockId, stocksCount);
            }

            if(isDeposited) {
                accountService.withdraw(userId, totalAmount);
            }

            if(isInventoryAdded) {
                onlineStockBrokerageSystem.decreaseInventory(stock, stocksCount);
            }

            orderStatus = OrderStatus.CANCELLED;
        }
    }
}
