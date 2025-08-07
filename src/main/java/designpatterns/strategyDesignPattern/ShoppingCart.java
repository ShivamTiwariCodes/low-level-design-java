package designpatterns.strategyDesignPattern;

import designpatterns.common.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> itemsList;

    public ShoppingCart() {
        itemsList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemsList.add(item);
    }

    public void pay(PaymentStrategy paymentStrategy) {
        printItems();
        paymentStrategy.pay();
    }

    private void printItems() {
        System.out.println("Bought items are : " + itemsList.toString());
    }
}
