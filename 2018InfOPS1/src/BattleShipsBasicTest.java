import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class BattleShipsBasicTest {

    @Test
    public void fireShotTest() {
        char res = BattleShips.fireShot(new char[2][2], new Position(0,0));
    }

    @Test
    public void findShipsTest() {
        Map<Character, Integer> res = BattleShips.findShips(new char[2][2]);
    }

    @Test
    public void fireShotsTest() {
        List<Position> input = new ArrayList<Position>();
        List<Character> res = BattleShips.fireShots(new char[2][2], input);
    }
}