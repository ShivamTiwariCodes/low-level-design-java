package problems.carrentalsystem.models;

import java.math.BigDecimal;

public class UPIPaymentStrategy implements IPaymentStrategy{

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Amount paid successfully : " + amount.toString());
    }
}
