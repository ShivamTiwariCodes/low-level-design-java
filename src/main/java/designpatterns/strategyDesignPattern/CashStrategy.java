package designpatterns.strategyDesignPattern;

public class CashStrategy implements PaymentStrategy{

    @Override
    public void pay() {
        System.out.println("Payment strategy chosen is Cash .");
    }
}
