package problems.snakeAndLadder.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size = 100;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board() {
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        initializeSnakesAndLadders();
    }

    public int getSize() {
        return size;
    }

    private void initializeSnakesAndLadders() {

        ladders.add(new Ladder(2, 30));
        ladders.add(new Ladder(9, 70));
        ladders.add(new Ladder(28, 56));
        ladders.add(new Ladder(52, 92));
        ladders.add(new Ladder(69, 97));

        snakes.add(new Snake(97, 29));
        snakes.add(new Snake(80, 40));
        snakes.add(new Snake(51, 3));
        snakes.add(new Snake(39, 8));
        snakes.add(new Snake(22, 1));
    }

    public int getPositionAfterSnakeAndLadders(int pos) {
        for(Ladder ladder: ladders) {
            if(ladder.getStart() == pos) {
                return ladder.getEnd();
            }
        }
        for(Snake snake: snakes) {
            if(snake.getStart() == pos) {
                return snake.getEnd();
            }
        }
        return pos;
    }
    
}
