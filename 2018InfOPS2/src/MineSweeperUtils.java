import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.UncheckedIOException;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Map;

class MineSweeperUtils {

    /**
     * This method parses a game file specified by the given path
     * and returns the corresponding game grid as 2 dimensional array.
     *
     * @param gameFile the path to a minesweeper game grid file
     * @return a 2 dimensional char array with the parsed game grid
     * @exception IllegalArgumentException if the gameFile is null, the file does not exist or is an invalid file.
     * @see IllegalArgumentException
     */
    public static char[][] parseGrid(String gameFile) {
        Path gamePath = Paths.get(gameFile);
        if(gameFile == null)
            throw new IllegalArgumentException("The given game file path must not be null!");
        if(!Files.exists(gamePath))
            throw new IllegalArgumentException("The given game file path does not exist! " + gamePath);
        if(!Files.isRegularFile(gamePath))
            throw new IllegalArgumentException("The given game file path is not a valid file! " + gamePath);

        Scanner in;
        try {
            in = new Scanner(gamePath);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        if (!in.hasNextInt())
            throw new RuntimeException("Given Minesweeper file has invalid format: " + gamePath);

        int size = in.nextInt();
        char[][] grid = new char[size][size];
        for(int y = 0; y < grid.length; y++) {
            for(int x = 0; x < grid[0].length; x++) {
                grid[y][x] = in.next().charAt(0);
            }
        }

        return grid;
    }

    /**
     * This method prints the given game grid in ASCII format.
     *
     * @param grid a minesweeper game grid
     * @return nothing
     * @exception IllegalArgumentException if the game grid is null or its length in either dimension is 0.
     * @see IllegalArgumentException
     */
    public static void printGrid(char[][] grid) {
        if(grid == null)
            throw new IllegalArgumentException("Given grid must not be null!");
        if(grid.length == 0 || grid[0].length == 0)
            throw new IllegalArgumentException("Given grid dimensions invalid!");

        StringBuilder bld = new StringBuilder();
        for (int y = -1; y < grid.length; y++) {
            for(int x = -1; x < grid[0].length; x++) {

                if(y >= 0) {
                    if( x >= 0) {
                        bld.append(grid[y][x]);
                        bld.append(" ");
                    } else {
                        bld.append(y);
                        bld.append(" ");
                    }
                } else {
                    if( x >= 0) {
                        bld.append(x);
                        bld.append(" ");
                    } else {
                        bld.append("  ");
                    }
                }
            }

            bld.append("\n");
        }

        System.out.println(bld);
    }

    /**
     * This method prints the given game grid in ASCII format
     * while printing only mines at coordinates specified in
     * armedMines and ignoring all others.
     *
     * @param grid a minesweeper game grid
     * @param armedMines a mapping of string coordinates to corresponding position objects
     * @return nothing
     * @exception IllegalArgumentException if the game grid is null or its length in either dimension is 0.
     * @see IllegalArgumentException
     */
    public static void printGrid(char[][] grid, Map<String, Position> armedMines) {
        if(grid == null)
            throw new IllegalArgumentException("Given grid must not be null!");
        if(grid.length == 0 || grid[0].length == 0)
            throw new IllegalArgumentException("Given grid dimensions invalid!");
        if(armedMines == null) {
            MineSweeperUtils.printGrid(grid);
            return;
        }

        StringBuilder bld = new StringBuilder();
        for (int y = -1; y < grid.length; y++) {
            for(int x = -1; x < grid[0].length; x++) {
                if(y >= 0) {
                    if( x >= 0) {
                        char value = grid[y][x];
                        Position pos = new Position(x,y);
                        if(value == 'X' && !armedMines.containsKey(pos.toString()))
                            value = 'd';
                        bld.append(value);
                        bld.append(" ");
                    } else {
                        bld.append(y);
                        bld.append(" ");
                    }
                } else {
                    if( x >= 0) {
                        bld.append(x);
                        bld.append(" ");
                    } else {
                        bld.append("  ");
                    }
                }
            }

            bld.append("\n");
        }

        System.out.println(bld);
    }

}