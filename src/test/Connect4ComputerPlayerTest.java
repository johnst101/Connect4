package test;

import core.GameBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Connect4ComputerPlayerTest {
    private static GameBoard gameBoardPVC;

    @Before
    public void setUp() throws Exception {
        gameBoardPVC = new GameBoard("C");
    }

    @After
    public void tearDown() throws Exception {
        gameBoardPVC = null;
    }

    @Test
    public void setCompBoardStateEarlySpotFound() {
        ByteArrayOutputStream outContentPVC = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentPVC));

        String expected = "|   |   |   |   |   |   |   |\n" + "|   |   |   |   |   |   |   |\n" + "|   |   |   |   |   |   |   |\n" + "|   |   |   |   |   |   |   |\n" + "|   |   |   |   |   |   |   |\n" + "| O |   |   |   |   |   |   |\n\n";

        gameBoardPVC.getCompPlayer().setCompBoardState();
        gameBoardPVC.printCurrentBoard();
        assertEquals(expected, outContentPVC.toString());
    }

    @Test
    public void setCompBoardStateLateSpotFound() {
        ByteArrayOutputStream outContentPVC = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentPVC));

        String expected = "|   |   |   |   |   |   |   |\n" + "|   |   |   |   |   |   |   |\n" + "|   |   |   |   |   |   |   |\n" + "|   |   |   |   |   |   |   |\n" + "| X | O | X | O | X | O |   |\n" + "| X | O | X | O | X | O | X |\n\n";

        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(5, true);
        gameBoardPVC.setBoardState(6, false);
        gameBoardPVC.setBoardState(7, true);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(5, true);
        gameBoardPVC.getCompPlayer().setCompBoardState();
        gameBoardPVC.printCurrentBoard();
        assertEquals(expected, outContentPVC.toString());
    }
}
