package problems.onlinestockbrokeragesystem.service;

import problems.onlinestockbrokeragesystem.OnlineStockBrokerageSystem;
import problems.onlinestockbrokeragesystem.exceptions.InsufficientAmountException;
import problems.onlinestockbrokeragesystem.models.Account;
import problems.onlinestockbrokeragesystem.models.Stock;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AccountService {

    private volatile Map<String, Account> accounts;
    private static volatile AccountService accountService;
    private OnlineStockBrokerageSystem onlineStockBrokerageSystem;

    private AccountService() {
        this.accounts = new ConcurrentHashMap<>();
        this.onlineStockBrokerageSystem = OnlineStockBrokerageSystem.getInstance();
    }

    public static AccountService getInstance() {
        if(accountService == null) {
            synchronized (AccountService.class) {
                if(accountService == null) {
                    accountService = new AccountService();
                }
            }
        }
        return accountService;
    }

    public void createAccount(String userId) {
        accounts.putIfAbsent(userId, new Account(userId, new BigDecimal("0")));
    }

    public void deposit(String userId, BigDecimal amount) {
        if(accounts.containsKey(userId)) {
            accounts.get(userId).addBalance(amount);
        }
    }

    public void withdraw(String userId, BigDecimal amount) throws InsufficientAmountException {
        if(accounts.containsKey(userId) && accounts.get(userId).getBalance().compareTo(amount) >= 0) {
            accounts.get(userId).getBalance().subtract(amount);
        } else {
            throw new InsufficientAmountException();
        }
    }

    public Map<Stock, Integer> getPorfolio(String userId) {
        if(accounts.containsKey(userId)) {
            Map<String, Integer> holdings = accounts.get(userId).getStocks();
            return holdings.entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> onlineStockBrokerageSystem.getStock(e.getKey()),
                            Map.Entry::getValue
                    ));
        }
        return null;
    }

    public void addStock(String userId, String stockId, int count) {
        if(accounts.containsKey(userId)) {
            accounts.get(userId).addStocks(stockId, count);
        }
    }

    public void removeStock(String userId, String stockId, int count) {
        if(accounts.containsKey(userId)) {
            accounts.get(userId).removeStocks(stockId, count);
        }
    }






}
