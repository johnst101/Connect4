package core;

/**
 * Plays the computer's move if when the program starts
 * play against the computer is selected.
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 28, 2024
 */

public class Connect4ComputerPlayer {
    /**Holds the data structure state of the Game Board.*/
    private char[][] boardState;

    /**
     * Sole constructor. Assigns this object's board state to be the
     * board state passed from he GameBoard object to ensure the same
     * game board is being used for the computer move.
     *
     * @param curBoard The state of the game board represented by a 2D array of chars
     */
    public Connect4ComputerPlayer(char[][] curBoard) {
        this.boardState = curBoard;
    }

    /**
     * Looks for the first open spot on the board and fills it with 'O'.
     * The computer starts in the bottom left corner and works left to right
     * and bottom to top to find an opening.
     */
    public void setCompBoardState() {
        boolean breakOutter = false;
        for (int i = this.boardState.length - 1; i >= 0; i--) {
            for (int j = 0; j < this.boardState[i].length; j++) {
                if (this.boardState[i][j] == ' ') {
                    this.boardState[i][j] = 'O';
                    breakOutter = true;
                    break;
                }
            }
            if (breakOutter) {
                break;
            }
        }
    }
}
