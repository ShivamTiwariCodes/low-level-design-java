package problems.carrentalsystem.models;

import java.math.BigDecimal;

public class Payment {

    private String paymentId;
    private IPaymentStrategy paymentStrategy;
    private BigDecimal amount;
    private PaymentStaus paymentStaus;

    public Payment(String paymentId, IPaymentStrategy paymentStrategy, BigDecimal amount) {
        this.paymentId = paymentId;
        this.paymentStrategy = paymentStrategy;
        this.amount = amount;
        this.paymentStaus = PaymentStaus.PENDING;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentStaus(PaymentStaus paymentStaus) {
        this.paymentStaus = paymentStaus;
    }

    public PaymentStaus getPaymentStaus() {
        return paymentStaus;
    }

    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public synchronized void pay() {
        paymentStrategy.pay(amount);
        this.paymentStaus = PaymentStaus.COMPLETED;
    }
}
