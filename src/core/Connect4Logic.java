package core;

/**
 * Connect4Logic runs the moves of each player and the game board state.
 *
 * @author Tyler Johnson (tjohson)
 * @version 2.0 Mar 28, 2024
 */

// packages
import java.util.Random;

public class Connect4Logic {
    /**Is a random unique ID to each game*/
    private final int gameID;
    /**Tracks if it's Player X's turn or not*/
    private boolean playerXTurn;
    /**For each game a new Game Board is created and used*/
    private GameBoard gameBoard;


    /**
     * Player vs. player constructor. Creates random ID for the game between 100 and 1000,
     * creates a new Game Board object, and sets playerXTurn to true.
     */
    public Connect4Logic() {
        Random rand = new Random();
        int min = 100, max = 1000;
        this.gameID = rand.nextInt(max - min + 1) + min;
        this.gameBoard = new GameBoard();
        this.playerXTurn = true;
    }

    /**
     * Player vs. computer constructor. Creates random ID for the game between 100 and 1000,
     * creates a new Game Board object with the computer game indicator as the parameter,
     * and sets playerXTurn to true.
     *
     * @param compGame Indicator to determine if the game type is a player vs. computer game
     */
    public Connect4Logic(String compGame) {
        Random rand = new Random();
        int min = 100, max = 1000;
        this.gameID = rand.nextInt(max - min + 1) + min;
        this.gameBoard = new GameBoard(compGame);
        this.playerXTurn = true;
    }

    /**
     * Returns the game ID.
     *
     * @return The integer ID for the current game.
     */
    public int getGameID() {
        return this.gameID;
    }

    /**
     * Returns the current game board.
     *
     * @return The GameBoard object for the current game.
     */
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    /**
     * Returns whether it is currently Player X's turn.
     *
     * @return The boolean representation of if it's Player X's turn.
     */
    public boolean getPlayerXTurn() {
        return this.playerXTurn;
    }

    /**
     * Takes a boolean argument set by the GameBoard that
     * flips the boolean value for if it's Player X's turn
     * to switch who is next to make a move.
     *
     * @param turnSwitch The opposite boolean of which player just made a move.
     */
    public void setPlayerXTurn(boolean turnSwitch) {
        this.playerXTurn = turnSwitch;
    }
}
