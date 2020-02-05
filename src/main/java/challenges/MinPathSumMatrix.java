package challenges;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example:
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinPathSumMatrix {
    public int minPathSum(int[][] grid) {
        return recursiveMinPathSum(0, 0, grid);
    }

    //A better way to do this would be use dynamic programming. basically b
    static int recursiveMinPathSum(int x, int y, int[][] grid) {
        if (x == grid.length || y == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        return grid[x][y] + Math.min(grid[x + 1][y], grid[x][y + 1]);
    }

    public static void main(String[] args) {

    }
}
