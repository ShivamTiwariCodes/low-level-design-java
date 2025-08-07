package designpatterns.strategyDesignPattern;

public class UpiStrategy implements PaymentStrategy{

    private String number;
    private int pin;

    public UpiStrategy(String number, int pin) {
        this.number = number;
        this.pin = pin;
    }
    @Override
    public void pay() {
        System.out.println("Payment strategy chosen is Upi with number : " + number);
    }
}
