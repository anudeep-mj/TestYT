package challenges;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] mnDP = new int[m][n];
        for (int i = 0; i < m; i++) {
            mnDP[i][0] = 1;
        }

        //to arrive at a point(i, j) -> it means, you can come from top or left.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mnDP[i][j] = mnDP[i-1][j] + mnDP[i][j-1];
            }
        }

        return mnDP[m-1][n-1];
    }
}
