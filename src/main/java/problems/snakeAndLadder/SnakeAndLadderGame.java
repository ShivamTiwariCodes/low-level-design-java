package problems.snakeAndLadder;

import problems.snakeAndLadder.models.Board;
import problems.snakeAndLadder.models.Dice;
import problems.snakeAndLadder.models.Player;

import java.util.List;


public class SnakeAndLadderGame {

    private Board board;
    private List<Player> players;
    private Dice dice = new Dice();

    public SnakeAndLadderGame(List<Player> players) {
        this.board = new Board();
        this.players = players;
    }

    public void start() {

        int chance = 0;

        while(!isGameEnded()) {

            int pos = players.get(chance).getCurrentPosition();
            int rollRes = dice.roll();
            System.out.println(players.get(chance).getName() + " got " + rollRes);

            int finalPos = pos + rollRes;

            if(finalPos == board.getSize()) {
                System.out.println("Winner is " + players.get(chance).getName());
                break;
            }

            if(finalPos <= board.getSize()) {
                finalPos = board.getPositionAfterSnakeAndLadders(finalPos);
                players.get(chance).setCurrentPosition(finalPos);
                System.out.println("Final position of " + players.get(chance).getName() + " is " + finalPos);
            }

            chance = (chance + 1)%players.size();
        }
    }

    private boolean isGameEnded() {
        for(Player player: players) {
            if(player.getCurrentPosition() == board.getSize()) {
                return true;
            }
        }
        return false;
    }

}
