package problems.onlineshopping;

import problems.onlineshopping.model.*;
import problems.onlineshopping.service.CartService;
import problems.onlineshopping.service.CheckoutService;
import problems.onlineshopping.service.InventoryService;
import problems.onlineshopping.service.PaymentService;
import problems.onlineshopping.service.ProductService;
import problems.onlineshopping.service.UserService;

public class OnlineShoppingDemo {

    public void run() {

        UserService userService = UserService.getInstance();
        InventoryService inventoryService = InventoryService.getInstance();
        CartService cartService = CartService.getInstance();
        CheckoutService checkoutService = CheckoutService.getInstance();
        PaymentService paymentService = PaymentService.getInstance();
        ProductService productService = ProductService.getInstance();

        User user1 = new User("User1");
        User user2 = new User("User2");

        userService.registerUser(user1);
        userService.registerUser(user2);

        Product product1 = new Product("Product1", "Product 1 description", ProductType.ELECTRONIC, 50);
        Product product2 = new Product("Product2", "Product 2 description", ProductType.FASHION, 100);
        Product product3 = new Product("Product3", "Product 3 description", ProductType.GROCERIES, 150);
        Product product4 = new Product("Product4", "Product 4 description", ProductType.ELECTRONIC, 200);

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);

        inventoryService.addInventory(product1.getId(), 10);
        inventoryService.addInventory(product2.getId(), 20);
        inventoryService.addInventory(product3.getId(), 50);
        inventoryService.addInventory(product4.getId(), 100);

        cartService.addItemToCart(user1, product2.getId(), 20);
        cartService.addItemToCart(user1, product3.getId(), 50);

        cartService.addItemToCart(user2, product1.getId(), 10);
        cartService.addItemToCart(user2, product4.getId(), 100);

        Order order1 = checkoutService.checkout(user1);
        System.out.println(order1.getOrderStatus());

        IPaymentStrategy paymentStrategy = new UPIPaymentStrategy("user1@upi");
        paymentService.pay(order1, paymentStrategy);

        System.out.println(order1.getOrderStatus());

    }

}
