package designpatterns.strategy.payment;

public interface IPaymentStrategy {
    public PaymentResult pay(double amount);
}
