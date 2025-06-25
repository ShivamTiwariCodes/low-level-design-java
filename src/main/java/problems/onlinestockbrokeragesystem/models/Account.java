package problems.onlinestockbrokeragesystem.models;

import problems.onlinestockbrokeragesystem.exceptions.InsufficientAmountException;
import problems.onlinestockbrokeragesystem.exceptions.InsufficientStockException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

//    synchronised on method put lock on whole object

    private String id;
    private BigDecimal balance;
    private final Map<String, Integer> stocks;
    private final List<Transaction> transactions;

    private final Object lock = new Object();
    private final Object stocksLock = new Object();

    public Account(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
        this.stocks = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    public void addBalance(BigDecimal amount) {
        synchronized (lock) {
            this.balance = this.balance.add(amount);
        }
    }

    public void deposit(BigDecimal amount) {
        synchronized (lock) {
            this.balance.add(amount);
        }
    }

    public void withdraw(BigDecimal amountToWithdraw) {
        synchronized (lock) {
            if(balance.compareTo(amountToWithdraw) >= 0) {
                balance.subtract(amountToWithdraw);
            }
        }
    }

    public void addStocks(String stocksId, int count) {
        synchronized (stocksLock) {
            stocks.put(stocksId, stocks.getOrDefault(stocksId, 0)+ count);
        }
    }

    public void removeStocks(String stockId, int count) throws InsufficientStockException {
        synchronized (stocksLock) {
            if(stocks.containsKey(stockId) && stocks.get(stockId)-count >= 0) {
                stocks.put(stockId, stocks.get(stockId)- count);
            } else {
                throw new InsufficientStockException("Sufficient stocks not found for stockId : " + stockId);
            }

        }
    }

    public Map<String, Integer> getStocks() {
        return stocks;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
