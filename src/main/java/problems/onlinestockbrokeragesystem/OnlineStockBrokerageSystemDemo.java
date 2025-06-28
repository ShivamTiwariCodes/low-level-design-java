package problems.onlinestockbrokeragesystem;

import problems.onlinestockbrokeragesystem.models.Order;
import problems.onlinestockbrokeragesystem.models.SellOrder;
import problems.onlinestockbrokeragesystem.models.Stock;
import problems.onlinestockbrokeragesystem.models.User;
import problems.onlinestockbrokeragesystem.service.AccountService;
import problems.onlinestockbrokeragesystem.service.OrderService;
import problems.onlinestockbrokeragesystem.service.UserService;

import java.math.BigDecimal;
import java.util.Map;

public class OnlineStockBrokerageSystemDemo {

//    The online stock brokerage system should allow users to create and manage their trading accounts.
//    Users should be able to buy and sell stocks, as well as view their portfolio and transaction history.
//    The system should provide real-time stock quotes and market data to users.
//    The system should handle order placement, execution, and settlement processes.
//    The system should enforce various business rules and validations, such as checking account balances and stock availability.
//    The system should handle concurrent user requests and ensure data consistency and integrity.
//    The system should be scalable and able to handle a large number of users and transactions.
//    The system should be secure and protect sensitive user information.

//    User, Account, stocks, portfolio ( list of stocks user have in account ), transaction, System,

//    User will register -> will check stock prices -> buy/sell stocks -> check portfolio

//    Concern	    Approach (LLD Level)
//    Concurrency	Use thread-safe data structures and locking mechanisms (synchronized, AtomicReference, DB-level transactions)
//    Consistency	Enforce atomic updates to balance, holdings, and stock quantity. Ensure business invariants never break.
//    Scalability	Avoid single bottlenecks like in-memory shared state. Use services that can scale horizontally. Decouple responsibilities via interfaces.



    public void run() {

        UserService userService = UserService.getInstance();
        OrderService orderService = OrderService.getInstance();
        AccountService accountService = AccountService.getInstance();
        OnlineStockBrokerageSystem onlineStockBrokerageSystem = OnlineStockBrokerageSystem.getInstance();

        User user1 = new User("user1", "user 1", "user1@gmail.com");
        User user2 = new User("user2", "user 2", "user2@gmail.com");
        User user3 = new User("user3", "user 3", "user3@gmail.com");
        User user4 = new User("user4", "user 4", "user4@gmail.com");

        userService.register(user1);
        userService.register(user2);
        userService.register(user3);
        userService.register(user4);

        generateStocks(onlineStockBrokerageSystem);

        accountService.deposit("user1", new BigDecimal("100000"));
        accountService.deposit("user1", new BigDecimal("500"));
        accountService.deposit("user2", new BigDecimal("50000"));
        accountService.deposit("user3", new BigDecimal("500"));
        accountService.deposit("user4", new BigDecimal("50000"));

        String[] stocks = {"stock_10", "stock_20", "stock_50", "stock_99"};
        Stock stock1 = onlineStockBrokerageSystem.getStock(stocks[0]);
        Stock stock2 = onlineStockBrokerageSystem.getStock(stocks[1]);
        Stock stock3 = onlineStockBrokerageSystem.getStock(stocks[2]);
        Stock stock4 = onlineStockBrokerageSystem.getStock(stocks[3]);

        orderService.buy(user1, stock4, 40);

        Map<Stock, Integer> holdings = accountService.getPorfolio(user1.getUserId());
        for(Map.Entry<Stock, Integer> e: holdings.entrySet()) {
            System.out.println(e.getKey().getName() + " " + e.getValue());
        }

        orderService.sell(user1, stock4, 20);

        holdings = accountService.getPorfolio(user1.getUserId());
        for(Map.Entry<Stock, Integer> e: holdings.entrySet()) {
            System.out.println(e.getKey().getName() + " " + e.getValue());
        }


    }

    private void generateStocks(OnlineStockBrokerageSystem onlineStockBrokerageSystem) {
        for(int i=0; i<100; i++) {
            onlineStockBrokerageSystem.addInventory(new Stock("stock_" + i, "stock_" + i, new BigDecimal(i)), 50);
        }
    }
}
