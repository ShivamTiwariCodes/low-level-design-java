package problems.movieticketbookingsystem.models;

public class CashPaymentStrategy implements IPaymentStrategy {

    public void pay(int amount) {
        System.out.println("Payment of amount : " + amount + " is made by cash.");
    }
}