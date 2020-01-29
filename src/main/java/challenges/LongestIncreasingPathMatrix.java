package challenges;

/**
 * > Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 *
 * Example 1:
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 */

public class LongestIncreasingPathMatrix {
    static int[][] directions =
            new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int numRows = matrix.length;
        if (numRows == 0) {
            return 0;
        }
        int numCols = matrix[0].length;
        int max = 1;
        int[][] cache = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int len = getMaxFromDFS(i, j, numRows, numCols, cache, matrix);
                max = Math.max(len, max);
            }
        }
        return max;
    }

    static int getMaxFromDFS(int row, int col, int numRows, int numCols, int[][] cache, int[][] matrix) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        int max = 1;
        for (int[] dir : directions) {
            int newX = row + dir[0];
            int newY = col + dir[1];
            if (newX < 0 || newX >= numRows || newY < 0 || newY >= numCols || matrix[newX][newY] <= matrix[row][col]) {
                continue;
            }
            int len = 1 + getMaxFromDFS(newX, newY, numRows, numCols, cache, matrix);
            max = Math.max(len, max);
        }
        cache[row][col] = max;
        return max;
    }

    public static void main(String[] args) {

    }
}
