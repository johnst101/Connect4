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
    /**TODO:*/
    private final int gameID;
    /**TODO:*/
    private boolean playerXTurn;
    /**TODO:*/
    private GameBoard gameBoard;


    /**
     * TODO:
     */
    public Connect4Logic() {
        Random rand = new Random();
        int min = 100, max = 1000;
        this.gameID = rand.nextInt(max - min + 1) + min;
        this.gameBoard = new GameBoard();
        this.playerXTurn = true;
    }

    /**
     * TODO:
     * @return
     */
    public int getGameID() {
        return this.gameID;
    }

    /**
     * TODO:
     * @return
     */
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    /**
     * TODO:
     * @return
     */
    public boolean getPlayerXTurn() {
        return this.playerXTurn;
    }

    /**
     * TODO:
     * @param turnSwitch
     */
    public void setPlayerXTurn(boolean turnSwitch) {
        this.playerXTurn = turnSwitch;
    }
}
