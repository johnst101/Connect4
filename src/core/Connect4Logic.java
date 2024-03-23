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
    private final Player PlayerO;
    private boolean playerXTurn;
    private int pieceCount;
    private GameBoard gameBoard;


    /**
     * TODO:
     */
    public Connect4Logic() {
        Random rand = new Random();
        int min = 100, max = 1000;
        this.gameID = rand.nextInt(max - min + 1) + min;
        this.pieceCount = 42;
        this.playerX = new Player();
        this.PlayerO = new Player();
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
    
    public Player getPlayerX() {
        return this.playerX;
    }
    
    public Player getPlayerO() {
        return this.PlayerO;
    }

    /**
     * TODO:
     * @return
     */
    public int getPieceCount() {
        return this.pieceCount;
    }
    
    public void subtractOnePiece() {
        this.pieceCount--;
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
