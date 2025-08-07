package designpatterns.strategyDesignPattern;

public class BitcoinStrategy implements PaymentStrategy{

    private String userName, password;

    public BitcoinStrategy(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void pay() {
        System.out.println("Payment strategy choosen is Bitcoin with username : " + userName);
    }
}
