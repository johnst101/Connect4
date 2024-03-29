package core;

/**
 * Plays the computer's move if when the program starts
 * play against the computer is selected.
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 28, 2024
 */

public class Connect4ComputerPlayer {
    /**TODO:*/
    private char[][] boardState;

    /**
     * TODO:
     * @param curBoard
     */
    public Connect4ComputerPlayer(char[][] curBoard) {
        this.boardState = curBoard;
    }

    /**
     * TODO:
     */
    public void setCompBoardState() {
        for (int i = this.boardState.length - 1; i >= 0; i--) {
            for (int j = 0; j < this.boardState[i].length; j++) {
                if (this.boardState[i][j] == '\0') {
                    this.boardState[i][j] = 'O';
                }
            }
        }
    }
}
