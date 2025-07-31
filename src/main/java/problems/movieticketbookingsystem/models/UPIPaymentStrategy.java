package problems.movieticketbookingsystem.models;

import java.math.BigDecimal;

public class UPIPaymentStrategy implements IPaymentStrategy {

    private String upiId;

    public UPIPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    public void pay(BigDecimal amount) {
        System.out.println("Payment of amount : " + amount + " is made by UPI.");
    }

}

