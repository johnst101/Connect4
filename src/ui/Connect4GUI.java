package ui;

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
    /**
     * TODO:
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
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

        // in-game board
        Circle circle00 = new Circle(22, Color.WHITE);
        circle00.setStrokeWidth(1);
        circle00.setStroke(Color.BLACK);
        Circle circle01 = new Circle(22, Color.WHITE);
        circle01.setStrokeWidth(1);
        circle01.setStroke(Color.BLACK);
        Circle circle02 = new Circle(22, Color.WHITE);
        circle02.setStrokeWidth(1);
        circle02.setStroke(Color.BLACK);
        Circle circle03 = new Circle(22, Color.WHITE);
        circle03.setStrokeWidth(1);
        circle03.setStroke(Color.BLACK);
        Circle circle04 = new Circle(22, Color.WHITE);
        circle04.setStrokeWidth(1);
        circle04.setStroke(Color.BLACK);
        Circle circle05 = new Circle(22, Color.WHITE);
        circle05.setStrokeWidth(1);
        circle05.setStroke(Color.BLACK);
        Circle circle06 = new Circle(22, Color.WHITE);
        circle06.setStrokeWidth(1);
        circle06.setStroke(Color.BLACK);
        Background rowsBG = new Background(new BackgroundFill(Color.rgb(0,100,200), null, null));
        HBox row0 = new HBox(circle00, circle01, circle02, circle03, circle04, circle05, circle06);
        row0.setSpacing(5);
        row0.setAlignment(Pos.CENTER);
        row0.setBackground(rowsBG);
        Circle circle10 = new Circle(22, Color.WHITE);
        circle10.setStrokeWidth(1);
        circle10.setStroke(Color.BLACK);
        Circle circle11 = new Circle(22, Color.WHITE);
        circle11.setStrokeWidth(1);
        circle11.setStroke(Color.BLACK);
        Circle circle12 = new Circle(22, Color.WHITE);
        circle12.setStrokeWidth(1);
        circle12.setStroke(Color.BLACK);
        Circle circle13 = new Circle(22, Color.WHITE);
        circle13.setStrokeWidth(1);
        circle13.setStroke(Color.BLACK);
        Circle circle14 = new Circle(22, Color.WHITE);
        circle14.setStrokeWidth(1);
        circle14.setStroke(Color.BLACK);
        Circle circle15 = new Circle(22, Color.WHITE);
        circle15.setStrokeWidth(1);
        circle15.setStroke(Color.BLACK);
        Circle circle16 = new Circle(22, Color.WHITE);
        circle16.setStrokeWidth(1);
        circle16.setStroke(Color.BLACK);
        HBox row1 = new HBox(circle10, circle11, circle12, circle13, circle14, circle15, circle16);
        row1.setSpacing(5);
        row1.setAlignment(Pos.CENTER);
        row1.setBackground(rowsBG);
        Circle circle20 = new Circle(22, Color.WHITE);
        circle20.setStrokeWidth(1);
        circle20.setStroke(Color.BLACK);
        Circle circle21 = new Circle(22, Color.WHITE);
        circle21.setStrokeWidth(1);
        circle21.setStroke(Color.BLACK);
        Circle circle22 = new Circle(22, Color.WHITE);
        circle22.setStrokeWidth(1);
        circle22.setStroke(Color.BLACK);
        Circle circle23 = new Circle(22, Color.WHITE);
        circle23.setStrokeWidth(1);
        circle23.setStroke(Color.BLACK);
        Circle circle24 = new Circle(22, Color.WHITE);
        circle24.setStrokeWidth(1);
        circle24.setStroke(Color.BLACK);
        Circle circle25 = new Circle(22, Color.WHITE);
        circle25.setStrokeWidth(1);
        circle25.setStroke(Color.BLACK);
        Circle circle26 = new Circle(22, Color.WHITE);
        circle26.setStrokeWidth(1);
        circle26.setStroke(Color.BLACK);
        HBox row2 = new HBox(circle20, circle21, circle22, circle23, circle24, circle25, circle26);
        row2.setSpacing(5);
        row2.setAlignment(Pos.CENTER);
        row2.setBackground(rowsBG);
        Circle circle30 = new Circle(22, Color.WHITE);
        circle30.setStrokeWidth(1);
        circle30.setStroke(Color.BLACK);
        Circle circle31 = new Circle(22, Color.WHITE);
        circle31.setStrokeWidth(1);
        circle31.setStroke(Color.BLACK);
        Circle circle32 = new Circle(22, Color.WHITE);
        circle32.setStrokeWidth(1);
        circle32.setStroke(Color.BLACK);
        Circle circle33 = new Circle(22, Color.WHITE);
        circle33.setStrokeWidth(1);
        circle33.setStroke(Color.BLACK);
        Circle circle34 = new Circle(22, Color.WHITE);
        circle34.setStrokeWidth(1);
        circle34.setStroke(Color.BLACK);
        Circle circle35 = new Circle(22, Color.WHITE);
        circle35.setStrokeWidth(1);
        circle35.setStroke(Color.BLACK);
        Circle circle36 = new Circle(22, Color.WHITE);
        circle36.setStrokeWidth(1);
        circle36.setStroke(Color.BLACK);
        HBox row3 = new HBox(circle30, circle31, circle32, circle33, circle34, circle35, circle36);
        row3.setSpacing(5);
        row3.setAlignment(Pos.CENTER);
        row3.setBackground(rowsBG);
        Circle circle40 = new Circle(22, Color.WHITE);
        circle40.setStrokeWidth(1);
        circle40.setStroke(Color.BLACK);
        Circle circle41 = new Circle(22, Color.WHITE);
        circle41.setStrokeWidth(1);
        circle41.setStroke(Color.BLACK);
        Circle circle42 = new Circle(22, Color.WHITE);
        circle42.setStrokeWidth(1);
        circle42.setStroke(Color.BLACK);
        Circle circle43 = new Circle(22, Color.WHITE);
        circle43.setStrokeWidth(1);
        circle43.setStroke(Color.BLACK);
        Circle circle44 = new Circle(22, Color.WHITE);
        circle44.setStrokeWidth(1);
        circle44.setStroke(Color.BLACK);
        Circle circle45 = new Circle(22, Color.WHITE);
        circle45.setStrokeWidth(1);
        circle45.setStroke(Color.BLACK);
        Circle circle46 = new Circle(22, Color.WHITE);
        circle46.setStrokeWidth(1);
        circle46.setStroke(Color.BLACK);
        HBox row4 = new HBox(circle40, circle41, circle42, circle43, circle44, circle45, circle46);
        row4.setSpacing(5);
        row4.setAlignment(Pos.CENTER);
        row4.setBackground(rowsBG);
        Circle circle50 = new Circle(22, Color.WHITE);
        circle50.setStrokeWidth(1);
        circle50.setStroke(Color.BLACK);
        Circle circle51 = new Circle(22, Color.WHITE);
        circle51.setStrokeWidth(1);
        circle51.setStroke(Color.BLACK);
        Circle circle52 = new Circle(22, Color.WHITE);
        circle52.setStrokeWidth(1);
        circle52.setStroke(Color.BLACK);
        Circle circle53 = new Circle(22, Color.WHITE);
        circle53.setStrokeWidth(1);
        circle53.setStroke(Color.BLACK);
        Circle circle54 = new Circle(22, Color.WHITE);
        circle54.setStrokeWidth(1);
        circle54.setStroke(Color.BLACK);
        Circle circle55 = new Circle(22, Color.WHITE);
        circle55.setStrokeWidth(1);
        circle55.setStroke(Color.BLACK);
        Circle circle56 = new Circle(22, Color.WHITE);
        circle56.setStrokeWidth(1);
        circle56.setStroke(Color.BLACK);
        HBox row5 = new HBox(circle50, circle51, circle52, circle53, circle54, circle55, circle56);
        row5.setSpacing(5);
        row5.setAlignment(Pos.CENTER);
        row5.setBackground(rowsBG);
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
        HBox row6 = new HBox(btnColumn0, btnColumn1, btnColumn2, btnColumn3, btnColumn4, btnColumn5, btnColumn6);
        row6.setSpacing(5);
        row6.setAlignment(Pos.CENTER);
        GridPane board = new GridPane();
        board.addRow(0, row0);
        board.addRow(1, row1);
        board.addRow(2, row2);
        board.addRow(3, row3);
        board.addRow(4, row4);
        board.addRow(5, row5);
        board.addRow(6, row6);
        board.setVgap(3);
        board.setAlignment(Pos.CENTER);

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
            primaryStage.setScene(scene2);
            gameText.setText("Your turn. Choose a column to drop your piece in.");
        });

        btnPlayPlayer.setOnAction(event -> {
            primaryStage.setScene(scene2);
            gameText.setText("Red player - your turn. Choose a column to drop your piece in.");
        });
    }

    /**
     * TODO:
     */
    public static void main(String[] args) {
        launch(args);
    }
}
