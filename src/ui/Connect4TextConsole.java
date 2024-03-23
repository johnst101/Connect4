package ui;

/**
 * TODO: Description
 *
 * @author Tyler Johnson (tjohson)
 * @version 1.0 Mar 21, 2024
 */

import core.Connect4Logic;
import java.util.Scanner;

public class Connect4TextConsole {
    private Connect4Logic newGameLogic;

    /**
     * TODO:
     */
    public Connect4TextConsole() {
        this.newGameLogic = new Connect4Logic();
    }

    /**
     * TODO:
     * @param args
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
        while (!newGameConsole.getNewGameLogic().getGameBoard().getWinState() || !newGameConsole.getNewGameLogic().getGameBoard().getDrawState()) {
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
                continue;
            }
            // Else
            else {
                // Update boardState
                // Update player piece state
                if (newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                    newGameConsole.getNewGameLogic().getPlayerX().subtractOnePiece();
                } else {
                    newGameConsole.getNewGameLogic().getPlayerO().subtractOnePiece(); 
                }
                // Update total piece state
                newGameConsole.getNewGameLogic().subtractOnePiece();
                // Print updated boardState
                newGameConsole.displayCurrentBoard();
                // Update player turn
                newGameConsole.getNewGameLogic().setPlayerXTurn(!newGameConsole.getNewGameLogic().getPlayerXTurn());
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
     * TODO:
     * @return
     */
    public Connect4Logic getNewGameLogic() {
        return this.newGameLogic;
    }

    /**
     * TODO:
     */
    public void displayCurrentBoard() {
        this.newGameLogic.getGameBoard();
    }

    /**
     * TODO:
     */
    public void displayPlayerXMove() {

    }

    /**
     * TODO:
     */
    public void displayPlayerOMove() {

    }

    /**
     * TODO:
     */
    public void displayWinState() {

    }

    /**
     * TODO:
     */
    public void displayDrawState() {

    }
}
