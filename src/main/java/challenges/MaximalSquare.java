package challenges;

/**
 * Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 * https://www.youtube.com/watch?v=RElcqtFYTm0
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cacheMat = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1] != '0') {
                    int temp = Math.min(cacheMat[i-1][j], cacheMat[i][j-1]);
                    cacheMat[i][j] = Math.min(temp, cacheMat[i-1][j-1]) + 1;
                    max = Math.max(max, cacheMat[i][j]);
                }
                //System.out.print(i + "" + j + ": " + cacheMat[i][j] + " ");
            }
            //System.out.println();
        }
        return max;
    }
}
