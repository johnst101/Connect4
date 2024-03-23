package ui;

/**
 * Connect4TextConsole contains the main method of the Connect4 game.
 * It drives the game on the console and interacts with the players.
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 23, 2024
 */

// packages
import core.Connect4Logic;
import java.util.Scanner;

public class Connect4TextConsole {
    /**For each game that's started, a new Connect4Logic object is created called newGameLogic.*/
    private Connect4Logic newGameLogic;

    /**Sole constructor. Only creates new Connect4Logic object.*/
    public Connect4TextConsole() {
        this.newGameLogic = new Connect4Logic();
    }

    /**
     * This method runs the console interaction for the Connect4 game.
     * It also calls to the Connect4Logic class to run the logic of the game.
     *
     * @param args Command line arguments - not used
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connect4TextConsole newGameConsole = new Connect4TextConsole();
        int columnSelection = 0;
        // Print "Begin Game."
        System.out.println("Begin Game.");
        // Print blank game board
        newGameConsole.displayCurrentBoard();

        // Loop while WinState or DrawState are not reached
        while (!newGameConsole.getNewGameLogic().getGameBoard().getWinState() && !newGameConsole.getNewGameLogic().getGameBoard().getDrawState()) {
            // If player X turn
            if (newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                // Print prompt for player x
                System.out.println("PlayerX-your turn. Choose a column number from 1-7.");
                // Get input from player x
                columnSelection = in.nextInt();
            }
            // Else
            else {
                // Print prompt for player y
                System.out.println("PlayerO-your turn. Choose a column number from 1-7.");
                // Get input from player y
                columnSelection = in.nextInt();
            }

            // If input NOT between 1 and 7
            if (columnSelection < 1 || columnSelection > 7) {
                // Print "Invalid column selection."
                System.out.println("Invalid column selection.");
                // Continue
            }
            // Else
            else {
                // Update boardState
                if (newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                    if (newGameConsole.getNewGameLogic().getGameBoard().setBoardState(columnSelection, newGameConsole.getNewGameLogic().getPlayerXTurn())) {
                        // Update total piece state
                        newGameConsole.getNewGameLogic().getGameBoard().subtractOnePiece();
                        // Print updated boardState
                        newGameConsole.displayCurrentBoard();
                        // Update player turn
                        newGameConsole.getNewGameLogic().setPlayerXTurn(!newGameConsole.getNewGameLogic().getPlayerXTurn());
                    } else {
                        System.out.println("Column full. No move made.");
                    }
                } else {
                    if (newGameConsole.getNewGameLogic().getGameBoard().setBoardState(columnSelection, newGameConsole.getNewGameLogic().getPlayerXTurn())) {
                        // Update total piece state
                        newGameConsole.getNewGameLogic().getGameBoard().subtractOnePiece();
                        // Print updated boardState
                        newGameConsole.displayCurrentBoard();
                        // Update player turn
                        newGameConsole.getNewGameLogic().setPlayerXTurn(!newGameConsole.getNewGameLogic().getPlayerXTurn());
                    } else {
                        System.out.println("Column full. No move made.");
                    }
                }

            }
        }
        // If WinState reached
        if (newGameConsole.getNewGameLogic().getGameBoard().getWinState()) {
            // Print "Player <player's letter who made the move> Won the Game."
            // The iff statement uses !current player's turn because at the end of the loop the turn will have updated to the next player
            if (!newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                System.out.println("Player X Won the Game!");
            } else {
                System.out.println("Player O Won the Game!");
            }
            // End the game
        }

        // If DrawState reached
        if (newGameConsole.getNewGameLogic().getGameBoard().getDrawState()) {
            // Print "The Game is a draw."
            System.out.println("This Game is a draw.");
            // End the game
        }
    }

    /**
     * Acts as an access point to retrieve the game logic for the current game.
     * This helps maintain the abstract integrity of the game structure.
     *
     * @return Connect4Logic object that contains runs the movement and player logic.
     */
    public Connect4Logic getNewGameLogic() {
        return this.newGameLogic;
    }

    /**
     * Prints out the visual representation of the current state
     * of the Connect4 game board when called. It does this by
     * accessing the current game logic then getting the game board
     * to print it's state.
     */
    public void displayCurrentBoard() {
        this.newGameLogic.getGameBoard().printCurrentBoard();
    }
}
