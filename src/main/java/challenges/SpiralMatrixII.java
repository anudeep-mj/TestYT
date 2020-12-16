package challenges;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 * <p>
 * Constraints:
 * 1 <= n <= 20
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int layers = (n + 1) / 2;

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

        int count = n * n;
        //int curr = 0;
        int currVal = 1;

        while (currVal < count) {
            for (int col = startCol; col <= endCol && currVal <= count; col++) {
                matrix[startRow][col] = currVal++;
            }

            startRow++;

            for (int row = startRow; row <= endRow && currVal <= count; row++) {
                matrix[row][endCol] = currVal++;
            }

            endCol--;

            for (int col = endCol; col >= startCol && currVal <= count; col--) {
                matrix[endRow][col] = currVal++;
            }

            endRow--;

            for (int row = endRow; row >= startRow && currVal <= count; row--) {
                matrix[row][startCol] = currVal++;
            }

            startCol++;
        }

        return matrix;
    }
}
