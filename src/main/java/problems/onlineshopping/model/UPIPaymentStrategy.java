package problems.onlineshopping.model;

public class UPIPaymentStrategy implements IPaymentStrategy{

    private String upiId;

    public UPIPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    public PaymentResult pay(double amount) {
        System.out.println("Payment of amount : " + amount + " is made by UPI.");
        return new PaymentResult(this, amount, PaymentStatus.SUCCESS);
    }
}
