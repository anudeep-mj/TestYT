package challenges;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * Example 1:
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes
{
    public static void setZeroes (int[][] matrix)
    {
        if (matrix.length == 0) {
            return;
        }

        boolean flag = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            //if first column has a 0, set flag to true
            if (matrix[i][0] == 0) {
                flag = true;
            }

            //if any other x,y == 0, set the corresponding row start and col start = 0
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //iterate over matrix and if a row begin or col begin == 0, set the [row,col] to 0. This will ensure both row and col val to be set zero.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //check for matrix[0][0]
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        if (flag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main (String[] args)
    {
        //[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        setZeroes(new int[][] {
            { 0, 1, 2, 0 },
            { 3, 4, 5, 2 },
            { 1, 3, 1, 5 }
        });
    }
}
