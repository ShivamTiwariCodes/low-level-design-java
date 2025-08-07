package problems.onlineshopping.model;

public interface IPaymentStrategy {

    PaymentResult pay(double amount);
}
