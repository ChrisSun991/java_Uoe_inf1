import java.util.Map;
import java.util.Hashtable;

import org.junit.Test;

public class MineSweeperBasicTest {

    @Test
    public void findMinesTest() {
        Map<String, Position> mines = MineSweeper.findMines(new char[2][2]);
    }

    @Test
    public void isIsolatedTest() {
        boolean res = MineSweeper.isIsolated(new char[2][2], new Position(0,0));
    }

    @Test
    public void disarmMinesTest() {
        Map<String, Position> input = new Hashtable<String, Position>();
        int res = MineSweeper.disarmMines(new char[2][2], input);
    }
}