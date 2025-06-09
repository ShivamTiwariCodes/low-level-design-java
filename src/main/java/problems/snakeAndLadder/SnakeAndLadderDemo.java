package problems.snakeAndLadder;

import problems.snakeAndLadder.models.Player;

import java.util.ArrayList;
import java.util.List;


public class SnakeAndLadderDemo {

    public static void runDemo() {

        List<Player> players1 = new ArrayList<>(List.of(
            new Player("Shivam"), new Player("Himanshu"), new Player("Prashant")));
        
            List<Player> players2 = new ArrayList<>(List.of(
            new Player("Sumit"), new Player("Vaibhav"), new Player("Vikas")));
        
            GameManager gameManager = GameManager.getInstance();
        
            gameManager.startGame(players1);
            gameManager.startGame(players2);
            gameManager.waitForAllTaskToFinishAndShutdown();
    }
    
}
