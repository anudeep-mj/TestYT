/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 *  * clockwise rotate
 *  * first reverse up to down, then swap the symmetry
 *  * 1 2 3     7 8 9     7 4 1
 *  * 4 5 6  => 4 5 6  => 8 5 2
 *  * 7 8 9     1 2 3     9 6 3
 *
 *  * anticlockwise rotate
 *  * first reverse left to right, then swap the symmetry
 *  * 1 2 3     3 2 1     3 6 9
 *  * 4 5 6  => 6 5 4  => 2 5 8
 *  * 7 8 9     9 8 7     1 4 7
 */
package challenges;

import lombok.extern.java.Log;

@Log
public class RotateMatrix {
    public static int[][] rotate(int[][] matrix) {
        reverseUpDown(matrix);
        swapSymmetry(matrix);
        return matrix;
    }

    private static void swapSymmetry(int[][] matrix) {
        for (int i = 0; i <= matrix.length -1; i++) {
            for (int j = i + 1; j <= matrix.length - 1; j++) {
                log.info("i=" + i + ", j=" + j);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseUpDown(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            int rowStart = 0;
            int rowEnd = matrix.length - 1;
            while (rowStart < rowEnd) {
                int buffer = matrix[rowEnd][col];
                matrix[rowEnd][col] = matrix[rowStart][col];
                matrix[rowStart][col] = buffer;
                rowStart++;
                rowEnd--;
            }
        }
    }




    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotate(matrix);
    }
}
