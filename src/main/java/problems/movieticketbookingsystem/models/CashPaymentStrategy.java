package problems.movieticketbookingsystem.models;

import java.math.BigDecimal;

public class CashPaymentStrategy implements IPaymentStrategy {

    public void pay(BigDecimal amount) {
        System.out.println("Payment of amount : " + amount + " is made by cash.");
    }
}