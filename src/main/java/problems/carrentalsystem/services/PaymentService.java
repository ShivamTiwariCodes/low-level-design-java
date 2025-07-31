package problems.carrentalsystem.services;

import problems.carrentalsystem.models.Booking;
import problems.carrentalsystem.models.IPaymentStrategy;
import problems.carrentalsystem.models.Payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentService {

    public static volatile PaymentService paymentServiceInstance;
    private Map<String, Payment> map;

    private PaymentService() {
        this.map = new ConcurrentHashMap<>();
    }

    public static PaymentService getInstance() {
        if(paymentServiceInstance == null) {
            synchronized (PaymentService.class) {
                if(paymentServiceInstance == null) {
                    paymentServiceInstance = new PaymentService();
                }
            }
        }
        return paymentServiceInstance;
    }

    public Payment pay(IPaymentStrategy paymentStrategy, BigDecimal cost) {
        Payment payment = new Payment(UUID.randomUUID().toString(), paymentStrategy, cost);
        map.putIfAbsent(payment.getPaymentId(), payment);
        payment.pay();
        return payment;
    }

}
