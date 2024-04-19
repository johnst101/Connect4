package test;

import core.GameBoard;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class GameBoardTest {
    private static GameBoard gameBoardPVP;
    private static GameBoard gameBoardPVC;

    @Before
    public void setUp() throws Exception {
        gameBoardPVP = new GameBoard();
        gameBoardPVC = new GameBoard("C");
    }

    @After
    public void tearDown() throws Exception {
        gameBoardPVP = null;
        gameBoardPVC = null;
    }

    @Test
    public void gameBoardStateCreated() {
        assertNotNull(gameBoardPVP.getBoardState());
        assertNotNull(gameBoardPVC.getBoardState());
    }

    @Test
    public void columnSelectionAndPlayerTurnSetBoardState() {
        assertTrue(gameBoardPVP.setBoardState(4,true));
        assertTrue(gameBoardPVP.setBoardState(4,false));


        assertTrue(gameBoardPVC.setBoardState(4,true));
        assertTrue(gameBoardPVC.setBoardState(4,false));

    }

    @Test
    public void setBoardStateThrowsArrayOOBException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVP.setBoardState(0, true);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVP.setBoardState(0, false);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVP.setBoardState(8, true);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVP.setBoardState(8, false);
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVC.setBoardState(0, true);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVC.setBoardState(0, false);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVC.setBoardState(8, true);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            gameBoardPVC.setBoardState(8, false);
        });
    }

    @Test
    public void setBoardStateFalseIfColumnSelectionFull() {
        gameBoardPVP.setBoardState(3,true);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3,true);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3,true);
        gameBoardPVP.setBoardState(3, false);
        assertFalse(gameBoardPVP.setBoardState(3,true));
        assertFalse(gameBoardPVP.setBoardState(3,false));

        gameBoardPVC.setBoardState(3,true);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3,true);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3,true);
        gameBoardPVC.setBoardState(3, false);
        assertFalse(gameBoardPVC.setBoardState(3,true));
        assertFalse(gameBoardPVC.setBoardState(3,false));
    }

    @Test
    public void compPlayerCreatedForPVC() {
        assertNotNull(gameBoardPVC.getCompPlayer());
    }

    @Test
    public void compPlayerNotCreatedForPVP() {
        assertNull(gameBoardPVP.getCompPlayer());
    }

    @Test
    public void setAndGetDrawStateWorks() {
        assertFalse(gameBoardPVP.getDrawState());
        while (gameBoardPVP.getPieceCount() != 0) {
            gameBoardPVP.subtractOnePiece();
        }
        gameBoardPVP.setDrawState();
        assertTrue(gameBoardPVP.getDrawState());

        assertFalse(gameBoardPVC.getDrawState());
        while (gameBoardPVC.getPieceCount() != 0) {
            gameBoardPVC.subtractOnePiece();
        }
        gameBoardPVC.setDrawState();
        assertTrue(gameBoardPVC.getDrawState());
    }

    @Test
    public void setAndGetWinStatePlayerXHorizontal() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(3, true);
        gameBoardPVP.setBoardState(4, true);
        gameBoardPVP.setBoardState(5, true);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkHorizontal('X'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(4, true);
        gameBoardPVC.setBoardState(5, true);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkHorizontal('X'));
    }

    @Test
    public void setAndGetWinStatePlayerOHorizontal() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(4, false);
        gameBoardPVP.setBoardState(5, false);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkHorizontal('O'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(5, false);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkHorizontal('O'));
    }

    @Test
    public void setAndGetWinStatePlayerXVertical() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, true);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkVertical('X'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, true);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkVertical('X'));
    }

    @Test
    public void setAndGetWinStatePlayerOVertical() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(1, false);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkVertical('O'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(1, false);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkVertical('O'));
    }

    @Test
    public void setAndGetWinStatePlayerXDiagonalBotTop() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3, true);
        gameBoardPVP.setBoardState(4, false);
        gameBoardPVP.setBoardState(4, false);
        gameBoardPVP.setBoardState(4, false);
        gameBoardPVP.setBoardState(4, true);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkDiagonalBotTop('X'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(4, true);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkDiagonalBotTop('X'));
    }

    @Test
    public void setAndGetWinStatePlayerODiagonalBotTop() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(3, true);
        gameBoardPVP.setBoardState(3, true);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(4, true);
        gameBoardPVP.setBoardState(4, true);
        gameBoardPVP.setBoardState(4, true);
        gameBoardPVP.setBoardState(4, false);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkDiagonalBotTop('O'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(4, true);
        gameBoardPVC.setBoardState(4, true);
        gameBoardPVC.setBoardState(4, true);
        gameBoardPVC.setBoardState(4, false);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkDiagonalBotTop('O'));
    }

    @Test
    public void setAndGetWinStatePlayerXDiagonalTopBot() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3, true);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3, true);
        gameBoardPVP.setBoardState(4, false);
        gameBoardPVP.setBoardState(4, true);
        gameBoardPVP.setBoardState(4, true);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkDiagonalTopBot('X'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(4, true);
        gameBoardPVC.setBoardState(4, true);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkDiagonalTopBot('X'));
    }

    @Test
    public void setAndGetWinStatePlayerODiagonalTopBot() {
        assertFalse(gameBoardPVP.getWinState());
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(1, true);
        gameBoardPVP.setBoardState(1, false);
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(2, true);
        gameBoardPVP.setBoardState(2, false);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3, true);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(3, false);
        gameBoardPVP.setBoardState(4, false);
        gameBoardPVP.setBoardState(4, true);
        gameBoardPVP.setBoardState(4, false);
        assertTrue(gameBoardPVP.getWinState());
        assertTrue(gameBoardPVP.checkDiagonalTopBot('O'));

        assertFalse(gameBoardPVC.getWinState());
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(1, true);
        gameBoardPVC.setBoardState(1, false);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(2, true);
        gameBoardPVC.setBoardState(2, false);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3, true);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(3, false);
        gameBoardPVC.setBoardState(4, false);
        gameBoardPVC.setBoardState(4, true);
        gameBoardPVC.setBoardState(4, false);
        assertTrue(gameBoardPVC.getWinState());
        assertTrue(gameBoardPVC.checkDiagonalTopBot('O'));
    }

    @Test
    public void printBoardStateRuns() throws IOException {
        ByteArrayOutputStream outContentPVP = new ByteArrayOutputStream();
        ByteArrayOutputStream outContentPVC = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentPVP));

        String expected = "";
        for (int i = 0; i < 6; i++) {
            expected += "|";
            for (int j = 0; j < 7; j++) {
                expected += " " + ' ' + " " + "|";
            }
            expected += "\n";
        }
        expected += "\n";

        gameBoardPVP.printCurrentBoard();
        assertEquals(expected, outContentPVP.toString());

        System.setOut(new PrintStream(outContentPVC));
        gameBoardPVC.printCurrentBoard();
        assertEquals(expected, outContentPVC.toString());
    }
}
