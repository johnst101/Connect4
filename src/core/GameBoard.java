package core;

/**
 * TODO: Description
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 21, 2024
 */

public class GameBoard {
    private char[][] boardState;
    private boolean winState;
    private boolean drawState;

    /**
     * TODO:
     */
    public GameBoard() {
        this.boardState = new char[6][7];
        this.winState = false;
        this.drawState = false;
    }

    /**
     *
     * @return
     */
    public char[][] getBoardState() {

    }

    public void printCurrentBoard() {

    }

    /**
     *
     * @return
     */
    public boolean getWinState() {

    }

    /**
     *
     * @return
     */
    public boolean getDrawState() {

    }
}