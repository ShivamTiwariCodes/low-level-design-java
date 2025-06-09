package problems.movieticketbookingsystem.models;

public class UPIPaymentStrategy implements IPaymentStrategy {

    private String upiId;

    public UPIPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    public void pay(int amount) {
        System.out.println("Payment of amount : " + amount + " is made by UPI.");
    }

}

