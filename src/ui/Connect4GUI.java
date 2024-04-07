package ui;

/**
 * Runs the graphical user interface and starts the game
 * for Connect 4. This class helps to prompt the user through
 * the Connect 4 game and allows for choosing different game modes.
 *
 * @author Tyler Johnson (tjohson)
 * @version @version 1.0 Apr 7, 2024
 */

// packages
import core.Connect4Logic;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Connect4GUI extends Application {

    /**Graphical game board where the pieces are placed to visually represent each move.*/
    private GridPane board = new GridPane();
    /**Logic to drive each move of the Connect 4 game.*/
    private Connect4Logic newGameLogic;
    /**Indicator for if the game chosen is against the computer or another player.*/
    private boolean compGameInd;

    /**
     * Acts as the main method and sets the Stage for the GUI Scenes to
     * sit on top of. Within the method there is event handling so that
     * when buttons are pressed the game progresses and can complete.
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        // title text scene 0
        Label sceneTitle0 = new Label("CONNECT 4");
        sceneTitle0.setFont(Font.font("Avant Garde Gothic Bold", FontWeight.BOLD, 50));
        sceneTitle0.setTextFill(Color.BLACK);
        VBox titleContainer0 = new VBox(sceneTitle0);
        titleContainer0.setAlignment(Pos.CENTER);

        // choose UI buttons
        Button btnGUI = new Button("Play on GUI");
        btnGUI.setTextFill(Color.WHITE);
        Button btnConsole = new Button("Play on Console");
        btnConsole.setTextFill(Color.WHITE);
        Button btnExit0 = new Button("Exit");
        btnExit0.setTextFill(Color.WHITE);
        HBox hBoxButtons0 = new HBox(btnGUI, btnConsole, btnExit0);
        hBoxButtons0.setSpacing(20);
        hBoxButtons0.setAlignment(Pos.CENTER);

        // title text scene 1
        Label sceneTitle1 = new Label("CONNECT 4");
        sceneTitle1.setFont(Font.font("Avant Garde Gothic Bold", FontWeight.BOLD, 50));
        sceneTitle1.setTextFill(Color.BLACK);
        VBox titleContainer1 = new VBox(sceneTitle1);
        titleContainer1.setAlignment(Pos.CENTER);

        // first game selection buttons
        Button btnPlayComputer = new Button("Play Computer");
        btnPlayComputer.setTextFill(Color.WHITE);
        Button btnPlayPlayer = new Button("Play Another Player");
        btnPlayPlayer.setTextFill(Color.WHITE);
        Button btnExit1 = new Button("Exit");
        btnExit1.setTextFill(Color.WHITE);
        HBox hBoxButtons1 = new HBox(btnPlayComputer, btnPlayPlayer, btnExit1);
        hBoxButtons1.setSpacing(20);
        hBoxButtons1.setAlignment(Pos.CENTER);

        // Buttons for the game board
        Button btnColumn0 = new Button("Drop");
        btnColumn0.setMinWidth(10);
        btnColumn0.setTextFill(Color.WHITE);
        Button btnColumn1 = new Button("Drop");
        btnColumn1.setMinWidth(10);
        btnColumn1.setTextFill(Color.WHITE);
        Button btnColumn2 = new Button("Drop");
        btnColumn2.setMinWidth(10);
        btnColumn2.setTextFill(Color.WHITE);
        Button btnColumn3 = new Button("Drop");
        btnColumn3.setMinWidth(10);
        btnColumn3.setTextFill(Color.WHITE);
        Button btnColumn4 = new Button("Drop");
        btnColumn4.setMinWidth(10);
        btnColumn4.setTextFill(Color.WHITE);
        Button btnColumn5 = new Button("Drop");
        btnColumn5.setMinWidth(10);
        btnColumn5.setTextFill(Color.WHITE);
        Button btnColumn6 = new Button("Drop");
        btnColumn6.setMinWidth(10);
        btnColumn6.setTextFill(Color.WHITE);
        drawBlankGrid(btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);

        // title text scene 2
        Label sceneTitle2 = new Label("CONNECT 4");
        sceneTitle2.setFont(Font.font("Avant Garde Gothic Bold", FontWeight.BOLD, 50));
        sceneTitle2.setTextFill(Color.BLACK);
        VBox titleContainer2 = new VBox(sceneTitle2);
        titleContainer2.setAlignment(Pos.CENTER);

        // in-game spacers and bottom text
        Text gameText = new Text("Testing for now.");
        gameText.setFont(Font.font("Avant Garde Gothic Bold", 16));
        VBox gameTextContainer = new VBox(gameText);
        gameTextContainer.setAlignment(Pos.CENTER);
        gameTextContainer.setPadding(new Insets(10));

        // title text scene 3
        Label sceneTitle3 = new Label("CONNECT 4");
        sceneTitle3.setFont(Font.font("Avant Garde Gothic Bold", FontWeight.BOLD, 50));
        sceneTitle3.setTextFill(Color.BLACK);
        VBox titleContainer3 = new VBox(sceneTitle3);
        titleContainer3.setAlignment(Pos.CENTER);

        // post-game messages
        Text postGameText = new Text("Testing for now!");
        postGameText.setFont(Font.font("Avant Garde Gothic Bold", FontWeight.BOLD, 35));
        VBox postGameTextContainer = new VBox(postGameText);
        postGameTextContainer.setAlignment(Pos.CENTER);
        Button btnExit2 = new Button("Exit");
        btnExit2.setAlignment(Pos.CENTER);
        btnExit2.setTextFill(Color.WHITE);
        VBox exit2Container = new VBox(btnExit2);
        exit2Container.setAlignment(Pos.CENTER);
        exit2Container.setPadding(new Insets(10));

        // scene0 root
        BorderPane borderPane0 = new BorderPane();
        borderPane0.setCenter(hBoxButtons0);
        borderPane0.setTop(titleContainer0);

        // scene1 root
        BorderPane borderPane1 = new BorderPane();
        borderPane1.setCenter(hBoxButtons1);
        borderPane1.setTop(titleContainer1);

        // scene2 root
        BorderPane borderPane2 = new BorderPane();
        borderPane2.setCenter(board);
        borderPane2.setTop(titleContainer2);
        borderPane2.setBottom(gameTextContainer);

        // scene3 root
        BorderPane borderPane3 = new BorderPane();
        borderPane3.setCenter(postGameTextContainer);
        borderPane3.setTop(titleContainer3);
        borderPane3.setBottom(exit2Container);

        // final scenes and staging
        Scene scene0 = new Scene(borderPane0, 500, 450);
        Scene scene1 = new Scene(borderPane1, 500, 450);
        Scene scene2 = new Scene(borderPane2, 500, 450);
        Scene scene3 = new Scene(borderPane3, 500, 450);
        scene0.getStylesheets().add("styles.css");
        scene1.getStylesheets().add("styles.css");
        scene2.getStylesheets().add("styles.css");
        scene3.getStylesheets().add("styles.css");
        primaryStage.setScene(scene0);
        primaryStage.setTitle("Connect 4");
        primaryStage.show();

        // ACTIONS //
        // Exit Action
        btnExit0.setOnAction(event -> {
            primaryStage.close();
        });

        btnExit1.setOnAction(event -> {
            primaryStage.close();
        });

        btnExit2.setOnAction(event -> {
            primaryStage.close();
        });

        // Switch Scenes
        btnGUI.setOnAction(event -> {
            primaryStage.setScene(scene1);
        });

        btnConsole.setOnAction(event -> {
            primaryStage.close();
            Connect4TextConsole.main(new String[0]);
        });

        btnPlayComputer.setOnAction(event -> {
            gameText.setText("Your turn. Choose a column to drop your piece in.");
            primaryStage.setScene(scene2);
            newGameLogic = new Connect4Logic("C");
            compGameInd = true;
        });

        btnPlayPlayer.setOnAction(event -> {
            gameText.setText("Red player - your turn. Choose a column to drop your piece in.");
            primaryStage.setScene(scene2);
            newGameLogic = new Connect4Logic();
            compGameInd = false;
        });

        btnColumn0.setOnAction(event1 -> {
            if(makeMove(1, gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6)) {
                if (compGameInd) {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("You Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    computerMove(gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Computer Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                } else {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Red Player Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                }
            }
        });
        btnColumn1.setOnAction(event1 -> {
            if(makeMove(2, gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6)) {
                if (compGameInd) {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("You Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    computerMove(gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Computer Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                } else {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Red Player Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                }
            }
        });
        btnColumn2.setOnAction(event1 -> {
            if(makeMove(3, gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6)) {
                if (compGameInd) {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("You Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    computerMove(gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Computer Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                } else {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Red Player Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                }
            }
        });
        btnColumn3.setOnAction(event1 -> {
            if(makeMove(4, gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6)) {
                if (compGameInd) {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("You Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    computerMove(gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Computer Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                } else {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Red Player Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                }
            }
        });
        btnColumn4.setOnAction(event1 -> {
            if(makeMove(5, gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6)) {
                if (compGameInd) {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("You Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    computerMove(gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Computer Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                } else {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Red Player Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                }
            }
        });
        btnColumn5.setOnAction(event1 -> {
            if(makeMove(6, gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6)) {
                if (compGameInd) {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("You Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    computerMove(gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Computer Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                } else {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Red Player Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                }
            }
        });
        btnColumn6.setOnAction(event1 -> {
            if(makeMove(7, gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6)) {
                if (compGameInd) {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("You Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    computerMove(gameText, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Computer Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                } else {
                    if (newGameLogic.getGameBoard().getWinState()) {
                        postGameText.setText("Red Player Won the Game!");
                        primaryStage.setScene(scene3);
                        return;
                    }
                    if (newGameLogic.getGameBoard().getDrawState()) {
                        postGameText.setText("This Game is a draw.");
                        primaryStage.setScene(scene3);
                        return;
                    }
                }
            }
        });
    }

    /**
     * Based on the button that is selected by the player, the next available
     * space in that column will be filled in with the player's colored piece.
     * The game board is redrawn with each move to see the result of the move
     * in the GUI. This method returns a boolean value for if the move was
     * properly completed or not.
     *
     * @param columnSelection The associated column number for the button selected by the user.
     * @param gameText The text object for the game text at the bottom of the scene.
     * @param btnColumn0 The drop button for column 1 to be passed through to draw the game board.
     * @param btnColumn1 The drop button for column 2 to be passed through to draw the game board.
     * @param btnColumn2 The drop button for column 3 to be passed through to draw the game board.
     * @param btnColumn3 The drop button for column 4 to be passed through to draw the game board.
     * @param btnColumn4 The drop button for column 5 to be passed through to draw the game board.
     * @param btnColumn5 The drop button for column 6 to be passed through to draw the game board.
     * @param btnColumn6 The drop button for column 7 to be passed through to draw the game board.
     * @return The boolean representation of if a move was completed or not.
     */
    private boolean makeMove(int columnSelection, Text gameText, Button btnColumn0, Button btnColumn1, Button btnColumn2, Button btnColumn3, Button btnColumn4, Button btnColumn5, Button btnColumn6) {
        if (compGameInd) {
            gameText.setText("Your turn. Choose a column to drop your piece in.");
        } else {
            if (!newGameLogic.getPlayerXTurn()) {
                gameText.setText("Red player - your turn. Choose a column to drop your piece in.");
            } else {
                gameText.setText("Yellow player - your turn. Choose a column to drop your piece in.");
            }
        }
        if (newGameLogic.getGameBoard().setBoardState(columnSelection, newGameLogic.getPlayerXTurn())) {
            newGameLogic.getGameBoard().subtractOnePiece();
            newGameLogic.getGameBoard().setDrawState();
            char[][] boardState = newGameLogic.getGameBoard().getBoardState();
            drawGrid(boardState, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
            newGameLogic.setPlayerXTurn(!newGameLogic.getPlayerXTurn());
            return true;
        } else {
            gameText.setText("Column full. Choose a different column.");
            return false;
        }
    }

    /**
     * This method makes a move for the computer player. It finds the next
     * available space from the bottom to top, left to right and fills it
     * with a yellow game piece. The game board is redrawn with each move
     * to see the result of the move in the GUI.
     *
     * @param gameText The text object for the game text at the bottom of the scene.
     * @param btnColumn0 The drop button for column 1 to be passed through to draw the game board.
     * @param btnColumn1 The drop button for column 2 to be passed through to draw the game board.
     * @param btnColumn2 The drop button for column 3 to be passed through to draw the game board.
     * @param btnColumn3 The drop button for column 4 to be passed through to draw the game board.
     * @param btnColumn4 The drop button for column 5 to be passed through to draw the game board.
     * @param btnColumn5 The drop button for column 6 to be passed through to draw the game board.
     * @param btnColumn6 The drop button for column 7 to be passed through to draw the game board.
     */
    private void computerMove(Text gameText, Button btnColumn0, Button btnColumn1, Button btnColumn2, Button btnColumn3, Button btnColumn4, Button btnColumn5, Button btnColumn6) {
        gameText.setText("Computer's turn. Making move now.");
        newGameLogic.getGameBoard().getCompPlayer().setCompBoardState();
        newGameLogic.getGameBoard().setWinState('O');
        newGameLogic.getGameBoard().subtractOnePiece();
        newGameLogic.getGameBoard().setDrawState();
        char[][] boardState = newGameLogic.getGameBoard().getBoardState();
        drawGrid(boardState, btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
        newGameLogic.setPlayerXTurn(!newGameLogic.getPlayerXTurn());
        gameText.setText("Your turn. Choose a column to drop your piece in.");
    }

    /**
     * Draws a blank game board on the scene to visually represent the beginning state of
     * a new game.
     *
     * @param column0 The drop button for column 1 to be passed through to draw the game board.
     * @param column1 The drop button for column 2 to be passed through to draw the game board.
     * @param column2 The drop button for column 3 to be passed through to draw the game board.
     * @param column3 The drop button for column 4 to be passed through to draw the game board.
     * @param column4 The drop button for column 5 to be passed through to draw the game board.
     * @param column5 The drop button for column 6 to be passed through to draw the game board.
     * @param column6 The drop button for column 7 to be passed through to draw the game board.
     */
    private void drawBlankGrid(Button column0, Button column1, Button column2, Button column3, Button column4, Button column5, Button column6) {
        board.getChildren().clear();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Circle circle = new Circle(22, Color.WHITE);
                circle.setStrokeWidth(1);
                circle.setStroke(Color.BLACK);
                board.add(circle, j, i);
            }
        }

        board.add(column0, 0, 6);
        board.add(column1, 1, 6);
        board.add(column2, 2, 6);
        board.add(column3, 3, 6);
        board.add(column4, 4, 6);
        board.add(column5, 5, 6);
        board.add(column6, 6, 6);
        board.setVgap(3);
        board.setHgap(3);
        board.setAlignment(Pos.CENTER);
    }

    /**
     * Draws an updated game board on the scene to visually represent the current state of
     * a game. It takes the board state char array and all the buttons to add onto the
     * bottom row.
     *
     * @param boardState The char[][] array state of the game board to see if a space is filled or not.
     * @param column0 The drop button for column 1 to be passed through to draw the game board.
     * @param column1 The drop button for column 2 to be passed through to draw the game board.
     * @param column2 The drop button for column 3 to be passed through to draw the game board.
     * @param column3 The drop button for column 4 to be passed through to draw the game board.
     * @param column4 The drop button for column 5 to be passed through to draw the game board.
     * @param column5 The drop button for column 6 to be passed through to draw the game board.
     * @param column6 The drop button for column 7 to be passed through to draw the game board.
     */
    private void drawGrid(char[][] boardState, Button column0, Button column1, Button column2, Button column3, Button column4, Button column5, Button column6) {
        board.getChildren().clear();

        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                Circle circle = new Circle(22, Color.WHITE);
                circle.setStrokeWidth(1);
                circle.setStroke(Color.BLACK);

                if (boardState[i][j] == 'X') {
                    circle.setFill(Color.RED);
                } else if (boardState[i][j] == 'O') {
                    circle.setFill(Color.YELLOW);
                }

                board.add(circle, j, i);
            }
        }

        board.add(column0, 0, 6);
        board.add(column1, 1, 6);
        board.add(column2, 2, 6);
        board.add(column3, 3, 6);
        board.add(column4, 4, 6);
        board.add(column5, 5, 6);
        board.add(column6, 6, 6);
        board.setVgap(3);
        board.setHgap(3);
        board.setAlignment(Pos.CENTER);
    }

    /**
     * Entry point into the program.
     *
     * @param args: used to launch GUI
     */
    public static void main(String[] args) {
        launch(args);
    }
}
