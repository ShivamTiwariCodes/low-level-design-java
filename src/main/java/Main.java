
import problems.onlineshopping.OnlineShoppingDemo;
import problems.onlinestockbrokeragesystem.OnlineStockBrokerageSystemDemo;
import problems.pubsubsystem.PubSubSystemDemo;
import problems.snakeAndLadder.SnakeAndLadderDemo;

public class Main {

    public static void main(String[] args) {
        OnlineShoppingDemo onlineshopping = new OnlineShoppingDemo();
//        onlineshopping.run();


        PubSubSystemDemo pubSubSystemDemo = new PubSubSystemDemo();
//        pubSubSystemDemo.run();

        SnakeAndLadderDemo snakeAndLadderDemo = new SnakeAndLadderDemo();
//        snakeAndLadderDemo.runDemo();

        OnlineStockBrokerageSystemDemo onlineStockBrokerageSystemDemo = new OnlineStockBrokerageSystemDemo();
        onlineStockBrokerageSystemDemo.run();
    }

}
