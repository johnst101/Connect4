package ui;

/**
 * Connect4TextConsole contains the main method of the Connect4 game.
 * It drives the game on the console and interacts with the players.
 *
 * @author Tyler Johnson (tjohson)
 * @version 2.0 Mar 28, 2024
 */

// packages
import core.Connect4Logic;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Connect4TextConsole {
    /**For each game that's started, a new Connect4Logic object is created called newGameLogic.*/
    private Connect4Logic newGameLogic;

    /**
     * Constructor for player vs. player game type.
     * Only creates new Connect4Logic object.
     */
    public Connect4TextConsole() {
        this.newGameLogic = new Connect4Logic();
    }

    /**
     * Constructor for player vs. computer game type.
     * Creates a new Connect4Logic object passing the computer
     * game type to the constructor.
     *
     * @param compGame Indicator to determine if the game type is a player vs. computer game
     */
    public Connect4TextConsole(String compGame) { this.newGameLogic = new Connect4Logic(compGame); }

    /**
     * This method runs the console interaction for the Connect4 game.
     * It also calls to the Connect4Logic class to run the logic of the game.
     *
     * @param args Command line arguments - not used
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connect4TextConsole newGameConsole;
        int columnSelection = 0;
        String gameType = "";
        // Print "Begin Game."
        System.out.println("Begin Game.");

        // Getting input for game type
        while (!gameType.equalsIgnoreCase("C") && !gameType.equalsIgnoreCase("P")) {
            System.out.println("Enter 'P' if you want to play against another player; enter 'C' to play against the computer.");
            try {
                gameType = in.next();
            } catch (InputMismatchException ex) {
                gameType = "Z";
                System.out.println("The input must be an integer. Please try again");
                in.nextLine();
            }
        }

        // Create game logic
        if (gameType.equalsIgnoreCase("C")) {
            newGameConsole = new Connect4TextConsole("P");
        } else {
            newGameConsole = new Connect4TextConsole();
        }

        // Print blank board
        newGameConsole.displayCurrentBoard();

        // Game against computer
        if (gameType.equalsIgnoreCase("C")) {
            System.out.println("Start game against computer.");
            while (!newGameConsole.getNewGameLogic().getGameBoard().getWinState() && !newGameConsole.getNewGameLogic().getGameBoard().getDrawState()) {
                if (newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                    System.out.println("Your turn. Choose a column number from 1-7.");
                    try {
                        columnSelection = in.nextInt();
                    } catch (InputMismatchException ex) {
                        columnSelection = 0;
                        System.out.println("The input must be an integer. Please try again");
                        in.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("Computer's turn. Making move now.");
                }
                if (columnSelection < 1 || columnSelection > 7) {
                    // Print "Invalid column selection."
                    System.out.println("Invalid column selection.");
                    // Continue
                } else {
                    // Update boardState
                    if (newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                        if (newGameConsole.getNewGameLogic().getGameBoard().setBoardState(columnSelection, newGameConsole.getNewGameLogic().getPlayerXTurn())) {
                            // Update total piece state
                            newGameConsole.getNewGameLogic().getGameBoard().subtractOnePiece();
                            newGameConsole.getNewGameLogic().getGameBoard().setDrawState();
                            // Print updated boardState
                            newGameConsole.displayCurrentBoard();
                            // Update player turn
                            newGameConsole.getNewGameLogic().setPlayerXTurn(!newGameConsole.getNewGameLogic().getPlayerXTurn());
                        } else {
                            System.out.println("Column full. No move made.");
                        }
                    } else {
                        newGameConsole.getNewGameLogic().getGameBoard().getCompPlayer().setCompBoardState();
                        newGameConsole.getNewGameLogic().getGameBoard().setWinState('O');
                        newGameConsole.getNewGameLogic().getGameBoard().subtractOnePiece();
                        newGameConsole.getNewGameLogic().getGameBoard().setDrawState();
                        // Print updated boardState
                        newGameConsole.displayCurrentBoard();
                        // Update player turn
                        newGameConsole.getNewGameLogic().setPlayerXTurn(!newGameConsole.getNewGameLogic().getPlayerXTurn());
                    }
                }
            }
        } else { // Game against player
            System.out.println("Start game against player.");
            // Loop while WinState or DrawState are not reached
            while (!newGameConsole.getNewGameLogic().getGameBoard().getWinState() && !newGameConsole.getNewGameLogic().getGameBoard().getDrawState()) {
                // If player X turn
                if (newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                    // Print prompt for player x
                    System.out.println("PlayerX-your turn. Choose a column number from 1-7.");
                    // Get input from player x
                    try {
                        columnSelection = in.nextInt();
                    } catch (InputMismatchException ex) {
                        columnSelection = 0;
                        System.out.println("The input must be an integer. Please try again");
                        in.nextLine();
                        continue;
                    }
                } else {
                    // Print prompt for player y
                    System.out.println("PlayerO-your turn. Choose a column number from 1-7.");
                    // Get input from player y
                    try {
                        columnSelection = in.nextInt();
                    } catch (InputMismatchException ex) {
                        columnSelection = 0;
                        System.out.println("The input must be an integer. Please try again");
                        in.nextLine();
                        continue;
                    }
                }
                // If input NOT between 1 and 7
                if (columnSelection < 1 || columnSelection > 7) {
                    // Print "Invalid column selection."
                    System.out.println("Invalid column selection.");
                    // Continue
                } else {
                    // Update boardState
                    if (newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                        if (newGameConsole.getNewGameLogic().getGameBoard().setBoardState(columnSelection, newGameConsole.getNewGameLogic().getPlayerXTurn())) {
                            // Update total piece state
                            newGameConsole.getNewGameLogic().getGameBoard().subtractOnePiece();
                            newGameConsole.getNewGameLogic().getGameBoard().setDrawState();
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
                            newGameConsole.getNewGameLogic().getGameBoard().setDrawState();
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
        }
        // If WinState reached
        if (newGameConsole.getNewGameLogic().getGameBoard().getWinState()) {
            if (gameType.equalsIgnoreCase("C")) {
                if (!newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                    System.out.println("You Won the Game!");
                } else {
                    System.out.println("The Computer Won the Game!");
                }
            } else {
                if (!newGameConsole.getNewGameLogic().getPlayerXTurn()) {
                    System.out.println("Player X Won the Game!");
                } else {
                    System.out.println("Player O Won the Game!");
                }
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
