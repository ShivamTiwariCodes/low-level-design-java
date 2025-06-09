package problems.snakeAndLadder;

import problems.snakeAndLadder.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class GameManager {

    private List<SnakeAndLadderGame> snakeAndLadderGames;
    private ExecutorService executorService;
    private List<Future<?>> gameFutures;

    private static GameManager gameManagerInstance;

    private GameManager() {
        this.snakeAndLadderGames = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(10);
        this.gameFutures = new ArrayList<>();
    }

    public static GameManager getInstance() {
        if(gameManagerInstance == null) {
            synchronized (GameManager.class) {
                if(gameManagerInstance == null) {
                    gameManagerInstance = new GameManager();
                }
            }
        }
        return gameManagerInstance;
    }

    public void startGame(List<Player> players) {
        Future<?> future = executorService.submit(() -> {
            SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(players);
            snakeAndLadderGames.add(snakeAndLadderGame);
            snakeAndLadderGame.start();
        });
        this.gameFutures.add(future);
    }

    public void waitForAllTaskToFinishAndShutdown() {
        for(Future<?> future: gameFutures) {
            try {
                future.get();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("All games are completed and executor is shutdown.");
    }
    
}
