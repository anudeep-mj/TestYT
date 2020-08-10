package challenges;

import java.util.HashSet;

/**
 * In a given grid, each cell can have one of three values:
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * Example 1:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * Note:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class RottingOranges
{
    public static int orangesRotting (int[][] grid)
    {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        HashSet<String> freshOranges = new HashSet<>();
        HashSet<String> rottenOranges = new HashSet<>();

        int count = 0;
        int[][] directions = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

        //populateFreshRottenOranges(grid, freshOranges, rottenOranges);

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    rottenOranges.add(row + "," + col);
                }
                if (grid[row][col] == 1) {
                    freshOranges.add(row + "," + col);
                }
            }
        }

        while (!freshOranges.isEmpty()) {
            HashSet<String> infectedOranges = new HashSet<>();

            for (String pair : rottenOranges) {
                String[] splitPair = pair.split(",");

                for (int[] direction : directions) {
                    int newX = Integer.parseInt(splitPair[0]) + direction[0];
                    int newY = Integer.parseInt(splitPair[1]) + direction[1];

                    String newDirection = newX + "," + newY;

                    if (freshOranges.contains(newDirection)) {
                        infectedOranges.add(newDirection);
                        freshOranges.remove(newDirection);
                    }
                }
            }

            if (infectedOranges.isEmpty()) {
                return -1;
            }
            else {
                rottenOranges = infectedOranges;
                count++;
            }
        }

        return count;
    }

    public static void main (String[] args)
    {
        int[][] grid = new int[][] {
            { 2, 1, 1 },
            { 1, 1, 0 },
            { 0, 1, 1 }
        };

        orangesRotting(grid);
    }
}
