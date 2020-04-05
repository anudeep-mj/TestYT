package challenges;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
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
public class LongestIncreasingPathInMatrix {

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int max = 1;
        int[][] cacheMatrix = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int length = getLengthFromRowColDFS(matrix, row, col, cacheMatrix);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    private int getLengthFromRowColDFS(int[][] matrix, int row, int col, int[][] cacheMatrix) {
        if (cacheMatrix[row][col] != 0) {
            return cacheMatrix[row][col];
        }

        int maxDistance = 0;

        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow > matrix.length - 1|| newCol < 0 || newCol > matrix[0].length - 1 || matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            } else {
                int distance = 1 + getLengthFromRowColDFS(matrix, newRow, newCol, cacheMatrix);
                maxDistance = Math.max(distance, maxDistance);
            }
        }

        cacheMatrix[row][col] = maxDistance;
        return maxDistance;
    }
}



