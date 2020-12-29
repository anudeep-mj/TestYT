package challenges;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order
 * as shown in the below image.
 *
 * Example:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int[][] dirs = {{-1, 1}, {1, -1}};
        int[] result = new int[numRows * numCols];

        int r = 0;
        int c = 0;

        for (int i = 0; i < numRows * numCols; i++) {
            result[i] = matrix[r][c];
            //even diagonal
            if ((r + c) % 2 == 0) {
                if (r - 1 >= 0 && c + 1 < numCols) {
                    r = r - 1;
                    c = c + 1;
                } else if (c + 1 < numCols) {
                    c = c + 1;
                } else {
                    r = r + 1;
                }
            } else {
                if (r + 1 < numRows && c - 1 >= 0) {
                    r = r + 1;
                    c = c - 1;
                } else if (r + 1 < numRows) {
                    r = r + 1;
                } else {
                    c = c + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findDiagonalOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }
}
