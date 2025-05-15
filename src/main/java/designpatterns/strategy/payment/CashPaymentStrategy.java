package designpatterns.strategy.payment;

public class CashPaymentStrategy implements IPaymentStrategy {

    public PaymentResult pay(double amount) {
        System.out.println("Payment of amount : " + amount + " is made by cash.");
        return new PaymentResult(this, amount, PaymentStatus.SUCCESS);
    }
}
