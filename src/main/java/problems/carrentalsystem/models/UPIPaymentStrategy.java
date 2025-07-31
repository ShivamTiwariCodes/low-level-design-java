package problems.carrentalsystem.models;

import java.math.BigDecimal;

public class UPIPaymentStrategy implements IPaymentStrategy{

    private String upiId;

    public UPIPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Amount paid successfully by upi id : " + upiId + " and amount : " + amount.toString());
    }
}
