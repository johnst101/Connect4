package core;

/**
 * TODO: Description
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 21, 2024
 */

// packages
import java.util.Random;


public class Connect4Logic {
    private final int gameID;
    private final Player playerX;
    private final Player playerY;
    private int pieceCount;

    /**
     * TODO:
     */
    public Connect4Logic() {
        Random rand = new Random();
        int min = 100, max = 1000;
        this.gameID = rand.nextInt(max - min + 1) + min;
        this.pieceCount = 42;
        this.playerX = new Player();
        this.playerY = new Player();
    }

    /**
     * TODO:
     */
    public void startNewGame() {

    }

    /**
     * TODO:
     */
    public void endGame() {

    }
}
