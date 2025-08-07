package problems.onlineshopping.model;

import java.util.Map;

import common.utils.TextUtil;

public class Order {

    private String id;
    private Map<Product, Integer> products;
    private Payment payment;
    private OrderStatus orderStatus;
    private double amount;
    private final int idLength = 10;

    public Order(Map<Product, Integer> products, double amount) {
        this.id = TextUtil.generateRandomText(idLength);
        this.products = products;
        this.orderStatus = OrderStatus.INITIALIZED;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void applyPayment(Payment payment) {
        this.payment = payment;
        this.orderStatus = (payment.getPaymentStatus() == PaymentStatus.SUCCESS) ? OrderStatus.PLACED : OrderStatus.PAYMENT_FAILED;
    }

}
