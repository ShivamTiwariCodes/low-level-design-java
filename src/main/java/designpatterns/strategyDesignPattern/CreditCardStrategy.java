package designpatterns.strategyDesignPattern;

public class CreditCardStrategy implements PaymentStrategy {

    private String fullName, cardNumber, validTill;
    private int cvv;

    public CreditCardStrategy(String fullName, String cardNumber, int cvv, String validTill) {
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.validTill = validTill;
    }


    @Override
    public void pay() {
        System.out.println("Payment strategy chosen is Credit card with name on card is : "+ fullName);
    }
}
