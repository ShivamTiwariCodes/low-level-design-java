package problems.onlineshopping.service;

import problems.onlineshopping.model.IPaymentStrategy;
import problems.onlineshopping.model.Order;
import problems.onlineshopping.model.Payment;
import problems.onlineshopping.model.PaymentResult;

public class PaymentService {

    private static PaymentService paymentServiceInstance;

    private PaymentService() {
    }

    // can not use 'this' with paymentServiceInstance, because this refers to instance of class, but when inside static method
    // there is not instance exists.
    public static PaymentService getInstance() {
        if (paymentServiceInstance == null) {
            synchronized (PaymentService.class) {
                if (paymentServiceInstance == null) {
                    paymentServiceInstance = new PaymentService();
                }
            }
        }
        return paymentServiceInstance;
    }

    public void pay(Order order, IPaymentStrategy paymentStrategy) {
        PaymentResult paymentResult = paymentStrategy.pay(order.getAmount());
        Payment payment = new Payment(paymentResult);
        order.applyPayment(payment);
    }

}
