package designpatterns.strategy.payment;

public class CreditCardPaymentStrategy implements IPaymentStrategy {

    private String cardNumber;
    private String validUpto;
    private int cvv;

    public CreditCardPaymentStrategy(String cardNumber, String validUpto, int cvv) {
        this.cardNumber = cardNumber;
        this.validUpto = validUpto;
        this.cvv = cvv;
    }

    public PaymentResult pay(double amount) {
        System.out.println("Payment of amount " + amount + " is made using credit card.");
        return new PaymentResult(this, amount, PaymentStatus.SUCCESS);
    }
}
