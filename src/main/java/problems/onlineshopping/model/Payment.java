package problems.onlineshopping.model;

import java.time.Instant;

import common.utils.TextUtil;
import designpatterns.strategy.payment.IPaymentStrategy;
import designpatterns.strategy.payment.PaymentResult;
import designpatterns.strategy.payment.PaymentStatus;

public class Payment {

    private String id;
    private String transactionId;
    private double amount;
    private PaymentStatus paymentStatus;
    private long createDate;
    private IPaymentStrategy paymentStrategy;
    private final int ID_LENGTH = 10;

    public Payment(PaymentResult paymentResult) {
        this.id = TextUtil.generateRandomText(ID_LENGTH);
        this.transactionId = paymentResult.getTransactionId();
        this.amount = paymentResult.getAmount();
        this.paymentStatus = paymentResult.getPaymentStatus();
        this.createDate = Instant.now().getEpochSecond();
        this.paymentStrategy = paymentResult.getPaymentStrategy();
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

}
