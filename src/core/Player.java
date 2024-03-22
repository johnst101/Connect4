package core;

/**
 * TODO: Description
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 21, 2024
 */

// packages
import java.util.Random;

public class Player {
    private final int playerID;
    private int pieceCount;

    /**
     * TODO:
     */
    public Player() {
        Random rand = new Random();
        int min = 100, max = 1000;
        this.playerID = rand.nextInt(max - min + 1) + min;
        this.pieceCount = 21;
    }

    /**
     * TODO:
     * @return
     */
    public int getPlayerID() {

    }

    /**
     * TODO:
     * @return
     */
    public int getPieceCount() {

    }

    /**
     * TODO:
     */
    public void makeMove() {

    }
}
