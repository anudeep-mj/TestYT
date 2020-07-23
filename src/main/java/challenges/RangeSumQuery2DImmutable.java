package challenges;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * Note:
 *     You may assume that the matrix does not change.
 *     There are many calls to sumRegion function.
 *     You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DImmutable {

    static int[][] mat;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        mat = matrix;
    }

    public int sumRegionBF(int row1, int col1, int row2, int col2) {
        if(row1 > row2) {
            int temp1 = row1;
            int temp2 = col1;
            row1 = row2;
            col1 = col2;
            row2 = temp1;
            col2 = temp2;
        }

        int sum = 0;

        for (int row = row1; row <= row2; row++) {
            if(col1 < col2) {
                for(int col = col1; col <= col2; col++) {
                    sum = sum + mat[row][col];
                }
            } else {
                for(int col = col1; col >= col2; col--) {
                    sum = sum + mat[row][col];
                }
            }
        }

        return sum;
    }

    private static int[][] getDP (int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i+1][j+1] = mat[i][j] + dp[i + 1][j] + dp[i][j + 1] + dp[i][j];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        getDP(input);
    }
}
