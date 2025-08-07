package designpatterns.strategyDesignPattern;

import designpatterns.common.Item;

// to change behaviour at run time

public class StrategyPattern {

    public void run(String caseId) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Item("Item1", "Description1"));
        shoppingCart.addItem(new Item("Item2", "Description2"));

        switch (caseId.toLowerCase()) {
            case "bitcoin":
                shoppingCart.pay(new BitcoinStrategy("bitcoin-username", "password"));
                break;
            case "credit-card":
                shoppingCart.pay(new CreditCardStrategy("Credit-card-name", "9876-9888-8787", 654, "09/28"));
                break;
            case "upi":
                shoppingCart.pay(new UpiStrategy("8778878787", 0000));
                break;
            case "cash":
                shoppingCart.pay(new CashStrategy());
                break;
            default:
                System.out.println("Choose correct strategy.");
        }

    }


}
