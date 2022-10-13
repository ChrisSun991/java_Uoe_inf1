import java.util.HashMap;
import java.util.Map;

class MineSweeper {

    public static Map<String, Position> findMines(char[][] grid) {
        Map<String, Position> output = new HashMap<String, Position>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length;j++){
                if (grid[i][j] == 'X'){
                    String temp = "("+ j + "," + i + ")";
                    output.put(temp,new Position(j,i));
                }
            }
        }
        return output;
    }

    public static boolean isIsolated(char[][] grid, Position minePos) {
        int x = minePos.getX();
        int y = minePos.getY();
        if (grid[y+1][x] == '0' && grid[y-1][x] == '0' && grid[y][x-1] == '0'
        && grid[y][x+1] == '0'){
            return true;
        }
        return false;
    }

    public static int disarmMines(char[][] grid, Map<String, Position> armedMines) {
        int count = 0;
        for (Position m : armedMines.values()){
            if (isIsolated(grid,m)){
                int x = m.getX();
                int y = m.getY();
                String temp = "("+ x + "," + y + ")";
                armedMines.remove(armedMines.get(temp));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java MineSweeper ./game01.txt");
            System.exit(1);
        }

        char[][] grid = MineSweeperUtils.parseGrid(args[0]);
        System.out.println("Playing with grid: ");
        MineSweeperUtils.printGrid(grid);

        System.out.println("Searching mines ...");
        Map<String, Position> mines = findMines(grid);
        if(mines != null) {
            if(mines.isEmpty()) System.out.println("No mines found.");
            else System.out.println("Mines found at: " + mines.keySet());
        }

        System.out.println("\nDisarming mines ...");
        int disarmed = disarmMines(grid, mines);
        System.out.println(disarmed + " mines disarmed!");
        MineSweeperUtils.printGrid(grid, mines);
    }
}