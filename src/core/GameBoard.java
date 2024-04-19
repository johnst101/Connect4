package core;

/**
 * Controls the moves on the Game Board and holds
 * the actual state of the board.
 *
 * @author Tyler Johnson (tjohson)
 * @version 3.0 Apr 7, 2024
 */

public class GameBoard {
    /**Holds the data structure state of the Game Board.*/
    private char[][] boardState;
    /**The trigger for a winning move.*/
    private boolean winState;
    /**The trigger for a draw move*/
    private boolean drawState;
    /**The number of pieces left to be used*/
    private int pieceCount;
    /**For each player vs. computer game a Computer Player will be create*/
    private Connect4ComputerPlayer compPlayer;

    /**
     * Player vs. player constructor. Invokes a new Game Board. Creates a 2D array
     * of characters as the board, sets the win state and the draw state
     * to false, and starts the game with 42 total pieces as there are
     * 42 spaces to be filled.
     */
    public GameBoard() {
        this.boardState = new char[6][7];
        this.winState = false;
        this.drawState = false;
        this.pieceCount = 42;
        for (int i = 0; i < this.boardState.length; i++) {
            for (int j = 0; j < this.boardState[i].length; j++) {
                this.boardState[i][j] = ' ';
            }
        }
    }

    /**
     * Player vs. computer constructor. Invokes a new Game Board. Creates a 2D array
     * of characters as the board, sets the win state and the draw state
     * to false, starts the game with 42 total pieces, and invokes a new
     * Computer Player object passing the board state to the object.
     *
     * @param compGame Indicator to determine if the game type is a player vs. computer game
     */
    public GameBoard(String compGame) {
        this.boardState = new char[6][7];
        this.winState = false;
        this.drawState = false;
        this.pieceCount = 42;
        this.compPlayer = new Connect4ComputerPlayer(this.boardState);
        for (int i = 0; i < this.boardState.length; i++) {
            for (int j = 0; j < this.boardState[i].length; j++) {
                this.boardState[i][j] = ' ';
            }
        }
    }

    /**
     * Returns the 2D array of characters that is the game board.
     * Currently not in use.
     *
     * @return The character 2D array representation of the Game Board.
     */
    public char[][] getBoardState() {
        return this.boardState;
    }

    /**
     * Adds new pieces to the board based on the selection of the Player.
     * Checks if the column selection is already full and will return false
     * to tell the Connect4TextConsole to output an error message and request
     * a new input. If the input is valid, the piece is added and a
     * check is made if the move created a valid win state or draw state.
     *
     * @param columnSelection The inputted selection by the Player.
     * @param isPlayerXTurn The indicator for if it's Player X's turn or not.
     * @return The boolean representation of if the move made was valid.
     */
    public boolean setBoardState(int columnSelection, boolean isPlayerXTurn) throws ArrayIndexOutOfBoundsException {
        if (this.boardState[0][columnSelection - 1] != ' ') {
            return false;
        }
        if (isPlayerXTurn) {
            for (int i = this.boardState.length - 1; i >= 0; i--) {
                if (this.boardState[i][columnSelection - 1] == ' ') {
                    this.boardState[i][columnSelection - 1] = 'X';
                    setWinState('X');
                    return true;
                }
            }
        } else {
            for (int i = this.boardState.length - 1; i >= 0; i--) {
                if (this.boardState[i][columnSelection - 1] == ' ') {
                    this.boardState[i][columnSelection - 1] = 'O';
                    setWinState('O');
                    return true;
                }
            }
        }
        return false;
    }

    /**Prints the visual representation of the Game Board into the console.*/
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
     * Returns the computer player object.
     *
     * @return The computer player object for a player vs. computer game.
     */
    public Connect4ComputerPlayer getCompPlayer() {
        return this.compPlayer;
    }

    /**
     * Returns the boolean representation of in the Game Board
     * is in a valid win state.
     *
     * @return The boolean representation of a valid win state.
     */
    public boolean getWinState() {
        return this.winState;
    }

    /**
     * The method checks for a win state horizontally, vertically,
     * and diagonally. If one of the four checks is true, then the
     * win state will change to true.
     *
     * @param playerTurn The character 'X' or 'O' to represent who's turn it is.
     */
    public void setWinState(char playerTurn) {
        if (checkHorizontal(playerTurn) || checkVertical(playerTurn) || checkDiagonalBotTop(playerTurn) || checkDiagonalTopBot(playerTurn)) {
            this.winState = true;
        }
    }

    /**
     * Returns the boolean representation of if a valid
     * draw state has been met.
     *
     * @return The boolean representation of a valid draw state.
     */
    public boolean getDrawState() {
        return this.drawState;
    }

    /**
     * Changes the draw state to true if there are no
     * pieces left to be placed.
     */
    public void setDrawState() {
        if (this.pieceCount == 0) {
            this.drawState = true;
        }
    }

    /**
     * Decrements the piece count down by 1 when called.
     */
    public void subtractOnePiece() {
        this.pieceCount--;
    }

    /**
     * Returns the number of pieces left to be played in the game.
     *
     * @return The integer representation of the number of pieces left in the game.
     */
    public int getPieceCount() {
        return this.pieceCount;
    }

    /**
     * Checks over the Game Board horizontally to determine if
     * the given player has four pieces in a row. Returns true
     * if four pieces in a row are found. Otherwise, returns false.
     *
     * @param playerTurn The char representation of the player whose turn it is.
     * @return The boolean representation of if a win state was found.
     */
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

    /**
     * Checks over the Game Board vertically to determine if
     * the given player has four concurrent pieces in a column. Returns true
     * if four concurrent pieces are found. Otherwise, returns false.
     *
     * @param playerTurn The char representation of the player whose turn it is.
     * @return The boolean representation of if a win state was found.
     */
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

    /**
     * Checks over the Game Board diagonally from bottom to top to determine if
     * the given player has four concurrent pieces. Returns true
     * if four concurrent pieces are found. Otherwise, returns false.
     *
     * @param playerTurn The char representation of the player whose turn it is.
     * @return The boolean representation of if a win state was found.
     */
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

    /**
     * Checks over the Game Board diagonally from top to bottom to determine if
     * the given player has four concurrent pieces. Returns true
     * if four concurrent pieces are found. Otherwise, returns false.
     *
     * @param playerTurn The char representation of the player whose turn it is.
     * @return The boolean representation of if a win state was found.
     */
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
