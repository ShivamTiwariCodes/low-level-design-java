package problems.onlinestockbrokeragesystem.service;

import problems.onlinestockbrokeragesystem.OnlineStockBrokerageSystem;
import problems.onlinestockbrokeragesystem.exceptions.InsufficientAmountException;
import problems.onlinestockbrokeragesystem.models.Account;
import problems.onlinestockbrokeragesystem.models.Stock;

import java.math.BigDecimal;
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

//    Thread safe
    private Account getAccountOrThrow(String userId) {
        Account account = accounts.get(userId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + userId);
        }
        return account;
    }

    public void deposit(String userId, BigDecimal amount) {
//         Not atomic between containsKey() and get()
//         May cause NullPointerException if removed concurrently
//        if(accounts.containsKey(userId)) {
//            accounts.get(userId).addBalance(amount);
//        }
        getAccountOrThrow(userId).deposit(amount);
    }

    public void withdraw(String userId, BigDecimal amount) throws InsufficientAmountException {
//        You’ve already obtained a reference to the Account object.
//        Even if it is removed from accounts map by another thread in between, your reference is still valid.
//        In Java, objects live in memory as long as some thread has a reference — even if they are removed from a map.
        Account account = getAccountOrThrow(userId);
        account.withdraw(amount);
    }

    public Map<Stock, Integer> getPorfolio(String userId) {
        Account account = getAccountOrThrow(userId);
            Map<String, Integer> holdings = account.getStocks();
            return holdings.entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> onlineStockBrokerageSystem.getStock(e.getKey()),
                            Map.Entry::getValue
                    ));

    }

    public void addStock(String userId, String stockId, int count) {
        Account account = getAccountOrThrow(userId);
        account.addStocks(stockId, count);
    }

    public void removeStock(String userId, String stockId, int count) {
        Account account = getAccountOrThrow(userId);
        account.removeStocks(stockId, count);
    }






}
