package test;

import core.Connect4Logic;
import core.GameBoard;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class Connect4LogicTest {
    private static Connect4Logic logicPVP;
    private static Connect4Logic logicPVC;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        logicPVP = new Connect4Logic();
        logicPVC = new Connect4Logic("C");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        logicPVP = null;
        logicPVC = null;
    }

    @Test
    public void gameIDBetweenHundredAndThousand() {
        assertTrue(logicPVP.getGameID() >= 100 && logicPVP.getGameID() <= 1000);
        assertTrue(logicPVC.getGameID() >= 100 && logicPVC.getGameID() <= 1000);
    }

    @Test
    public void gameBoardCreated() {
        assertNotNull(logicPVP.getGameBoard());
        assertNotNull(logicPVC.getGameBoard());
    }

    @Test
    public void playerXTurnFirst() {
        assertTrue(logicPVP.getPlayerXTurn());
        assertTrue(logicPVC.getPlayerXTurn());
    }

    @Test
    public void setPlayerXTurnFlipsPlayerXTurnToOppositeOfCurrent() {
        boolean playerXTurnBeforePVP = logicPVP.getPlayerXTurn();
        logicPVP.setPlayerXTurn(!playerXTurnBeforePVP);
        boolean playerXTurnNowPVP =  logicPVP.getPlayerXTurn();
        assertTrue(playerXTurnNowPVP != playerXTurnBeforePVP);

        boolean playerXTurnBeforePVC = logicPVP.getPlayerXTurn();
        logicPVP.setPlayerXTurn(!playerXTurnBeforePVC);
        boolean playerXTurnNowPVC =  logicPVP.getPlayerXTurn();
        assertTrue(playerXTurnNowPVC != playerXTurnBeforePVC);
    }
}
