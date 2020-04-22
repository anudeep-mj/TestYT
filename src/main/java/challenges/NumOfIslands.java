package challenges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class NumOfIslands {
    public static int numIslands(char[][] grid) {
        int numRows = grid.length;
        if(numRows == 0) {
            return 0;
        }
        int numCols = grid[0].length;
        int numOfIslands = 0;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == '1') {
                    numOfIslands++;
                    fillUpAdjacentCells(grid, row, col);
                }
            }
        }

        return numOfIslands;
    }

    private static void fillUpAdjacentCells(char[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        fillUpAdjacentCells(grid, row + 1, col);
        fillUpAdjacentCells(grid, row - 1, col);
        fillUpAdjacentCells(grid, row, col + 1);
        fillUpAdjacentCells(grid, row, col - 1);
    }

    public static void main(String[] args) {
        numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        });
    }
}
