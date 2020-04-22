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

    public static int minPathSumDP(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[][] dp = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                dp[i][j] = grid[i][j];
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j] + dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = dp[i][j] + dp[i-1][j];
                }
            }
        }

        return dp[numRows-1][numCols-1];
    }


    public int minPathSum(int[][] grid) {
        return recursiveMinPathSum(0, 0, grid);
    }

    //A better way to do this would be use dynamic programming.
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
        minPathSumDP(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        });
    }
}
