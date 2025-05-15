package problems.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import problems.onlineshopping.model.Order;

public class OrderService {

    private static OrderService orderServiceInstance;
    List<Order> orders;

    private OrderService() {
        this.orders = new ArrayList<>();
    }

    public static OrderService getInstance() {
        if (orderServiceInstance == null) {
            synchronized (OrderService.class) {
                if (orderServiceInstance == null) {
                    orderServiceInstance = new OrderService();
                }
            }
        }
        return orderServiceInstance;
    }

    

    

}
