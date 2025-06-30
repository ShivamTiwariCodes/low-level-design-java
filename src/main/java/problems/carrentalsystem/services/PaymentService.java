package problems.carrentalsystem.services;

import problems.carrentalsystem.models.Payment;

public class PaymentService {

    public static volatile PaymentService paymentServiceInstance;

    private PaymentService() {}

    public PaymentService getCarServiceInstance() {
        if(paymentServiceInstance == null) {
            synchronized (PaymentService.class) {
                if(paymentServiceInstance == null) {
                    paymentServiceInstance = new PaymentService();
                }
            }
        }
        return paymentServiceInstance;
    }
}
