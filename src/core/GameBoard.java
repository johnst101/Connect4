package core;

/**
 * TODO: Description
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 21, 2024
 */

// packages
import java.util.Arrays;

public class GameBoard {
    /**TODO:*/
    private char[][] boardState;
    /**TODO:*/
    private boolean winState;
    /**TODO:*/
    private boolean drawState;
    /**TODO:*/
    private int pieceCount;

    /**
     * TODO:
     */
    public GameBoard() {
        this.boardState = new char[6][7];
        this.winState = false;
        this.drawState = false;
        this.pieceCount = 42;
    }

    /**
     * TODO:
     * @return
     */
    public char[][] getBoardState() {
        return this.boardState;
    }

    /**
     *
     * @param columnSelection
     * @param isPlayerXTurn
     */
    public boolean setBoardState(int columnSelection, boolean isPlayerXTurn) {
        if (this.boardState[0][columnSelection - 1] != '\0') {
            return false;
        }
        if (isPlayerXTurn) {
            for (int i = this.boardState.length - 1; i >= 0; i--) {
                if (this.boardState[i][columnSelection - 1] == '\0') {
                    this.boardState[i][columnSelection - 1] = 'X';
                    setWinState('X');
                    setDrawState();
                    return true;
                }
            }
        } else {
            for (int i = this.boardState.length - 1; i >= 0; i--) {
                if (this.boardState[i][columnSelection - 1] == '\0') {
                    this.boardState[i][columnSelection - 1] = 'O';
                    setWinState('O');
                    setDrawState();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * TODO:
     */
    public void printCurrentBoard() {
        for (int i = 0; i < this.boardState.length; i++) {
            System.out.print("|");
            for (int j = 0; j < this.boardState[i].length; j++) {
                System.out.print(" " + this.boardState[i][j] + " ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * TODO:
     * @return
     */
    public boolean getWinState() {
        return this.winState;
    }

    /**
     * TODO:
     */
    public void setWinState(char playerTurn) {
        if (checkHorizontal(playerTurn) || checkVertical(playerTurn) || checkDiagonalBotTop(playerTurn) || checkDiagonalTopBot(playerTurn)) {
            this.winState = true;
        }
    }

    /**
     * TODO:
     * @return
     */
    public boolean getDrawState() {
        return this.drawState;
    }

    /**
     * TODO:
     */
    public void setDrawState() {
        if (this.pieceCount == 0) {
            this.drawState = true;
        }
    }

    /**
     * TODO:
     */
    public void subtractOnePiece() {
        this.pieceCount--;
    }

    public boolean checkHorizontal(char playerTurn) {
        for (int row = 0; row < this.boardState.length; row++) {
            for (int col = 0; col < this.boardState[row].length - 3; col++) {
                if (this.boardState[row][col] == playerTurn && this.boardState[row][col + 1] == playerTurn && this.boardState[row][col + 2] == playerTurn && this.boardState[row][col + 3] == playerTurn) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkVertical(char playerTurn) {
        for (int col = 0; col < this.boardState[0].length; col++) {
            for (int row = 0; row < this.boardState.length - 3; row++) {
                if (this.boardState[row][col] == playerTurn && this.boardState[row + 1][col] == playerTurn && this.boardState[row + 2][col] == playerTurn && this.boardState[row + 3][col] == playerTurn) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonalBotTop(char playerTurn) {
        for (int row = 3; row < this.boardState.length; row++) {
            for (int col = 0; col <= this.boardState[col].length - 4; col++) {
                if (this.boardState[row][col] == playerTurn &&
                        this.boardState[row-1][col+1] == playerTurn &&
                        this.boardState[row-2][col+2] == playerTurn &&
                        this.boardState[row-3][col+3] == playerTurn) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonalTopBot(char playerTurn) {
        for (int row = 0; row <= this.boardState.length - 4; row++) {
            for (int col = 0; col <= this.boardState[col].length - 4; col++) {
                if (this.boardState[row][col] == playerTurn &&
                        this.boardState[row+1][col+1] == playerTurn &&
                        this.boardState[row+2][col+2] == playerTurn &&
                        this.boardState[row+3][col+3] == playerTurn) {
                    return true;
                }
            }
        }
        return false;
    }
}
