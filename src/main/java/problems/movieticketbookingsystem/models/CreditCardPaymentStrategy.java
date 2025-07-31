package problems.movieticketbookingsystem.models;

import problems.carrentalsystem.models.Booking;

import java.math.BigDecimal;

public class CreditCardPaymentStrategy implements IPaymentStrategy {

    private String cardNumber;
    private String validUpto;
    private int cvv;

    public CreditCardPaymentStrategy(String cardNumber, String validUpto, int cvv) {
        this.cardNumber = cardNumber;
        this.validUpto = validUpto;
        this.cvv = cvv;
    }

    public void pay(BigDecimal amount) {
        System.out.println("Payment of amount " + amount + " is made using credit card.");
    }
}