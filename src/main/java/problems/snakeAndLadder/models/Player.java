package problems.snakeAndLadder.models;

public class Player {

    private String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
    
}
