package problems.movieticketbookingsystem.models;

import common.utils.TextUtil;

import lombok.Getter;

public class Payment {

    private String id;
    private User user;
    private int amount;
    private PaymentStatus paymentStatus;
    private IPaymentStrategy paymentStrategy;

    public Payment(User user, int amount, IPaymentStrategy paymentStrategy) {
        this.id = TextUtil.generateRandomText(8);
        this.user = user;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
        this.paymentStrategy = paymentStrategy;
        
    }

    public String getId() {
        return id;
    }

    public void pay() {
        if(!paymentStatus.equals(PaymentStatus.PENDING)) {
            return;
        }
        synchronized (this) {
            paymentStrategy.pay(amount);
            paymentStatus = PaymentStatus.DONE;
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", user=" + (user != null ? user.toString() : "null") +
                ", amount=" + amount +
                ", paymentStatus=" + paymentStatus +
                ", paymentStrategy=" + (paymentStrategy != null ? paymentStrategy.getClass().getSimpleName() : "null") +
                '}';
    }

}