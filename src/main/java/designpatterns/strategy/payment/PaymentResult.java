package designpatterns.strategy.payment;

import common.utils.TextUtil;

public class PaymentResult {

    private String transacationId;
    private IPaymentStrategy paymentStrategy;
    private double amount;
    private PaymentStatus paymentStatus;

    public PaymentResult(IPaymentStrategy paymentStrategy, double amount, PaymentStatus paymentStatus) {
        this.transacationId = TextUtil.generateRandomText(16);
        this.paymentStrategy = paymentStrategy;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transacationId;
    }

    public double getAmount() {
        return amount;
    }

    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

}
