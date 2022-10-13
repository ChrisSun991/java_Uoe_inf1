import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

class BattleShips {

    public static char fireShot(char[][] grid, Position shot) {
        if (shot.getX() > grid.length || shot.getY() > grid.length){
            return '#';
        }
        if (grid[shot.getY()][shot.getX()] == '#'){
            return '#';
        }else{
            return grid[shot.getY()][shot.getX()];
        }
    }

    public static Map<Character, Integer> findShips(char[][] grid) {
        Map<Character, Integer> output = new HashMap<Character, Integer>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (output.containsKey(grid[i][j])){
                    output.put(grid[i][j], 1);
                }else{
                    output.put(grid[i][j],output.get(grid[i][j] + 1));
                }
            }
        }
        output.remove('#');
        return output;
    }

    public static List<Character> fireShots(char[][] grid, List<Position> shots) {
        List<Character> output = new ArrayList<Character>();
        for (Position pos : shots){
            char c = fireShot(grid,pos);
            if ( c != '#'){
                Map<Character,Integer> d = findShips(grid) ;
                if (d.containsKey(c)) {
                    d.put(c, output.get(c) - 1);
                }
                if (d.get(c) == 0){
                    output.add(c);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java BattleShips ./game01.txt");
            System.exit(1);
        }

        char[][] grid = BattleShipsUtils.parseGrid(args[0]);

        System.out.println("Playing with grid: ");
        BattleShipsUtils.printGrid(grid);

        Position centreShot = new Position(grid.length / 2,
                grid.length / 2);
        System.out.println("\nFiring Shot at centre " +
                centreShot.toString() + " ...");
        fireShot(grid, centreShot);

        System.out.println("\nGenerating shots ...");
        List<Position> shots = BattleShipsUtils.generateShots(grid.length,
                grid.length * 2);
        System.out.println("Shots: " + shots);

        System.out.println("\nFinding Ships ...");
        Map<Character, Integer> ships = findShips(grid);
        if(ships != null) {
            for (Character ship : ships.keySet())
                System.out.println(ship + " has size " + ships.get(ship));
        }

        System.out.println("\nFiring shots ...");
        if(shots != null) {
            List<Character> destroyedShips = fireShots(grid, shots);
            if (destroyedShips != null && !destroyedShips.isEmpty()) {
                System.out.println("Destroyed ships: ");
                for(char ship : destroyedShips)
                    System.out.println(ship);
            }
        }
    }
}