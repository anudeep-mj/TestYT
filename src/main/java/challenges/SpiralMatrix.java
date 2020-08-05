package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix
{
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int rowPtrStart = 0;
        int rowPtrEnd = rows - 1;
        int colPtrStart = 0;
        int colPtrEnd = cols - 1;
        int size = matrix.length * matrix[0].length;

        //remember to have result.size() < size
        while (result.size() < size) {
            for (int col = colPtrStart; col <= colPtrEnd && result.size() < size; col++) {
                result.add(matrix[rowPtrStart][col]);
            }

            rowPtrStart++;

            for (int row = rowPtrStart; row <= rowPtrEnd && result.size() < size; row++) {
                result.add(matrix[row][colPtrEnd]);
            }

            colPtrEnd--;

            for (int col = colPtrEnd; col >= colPtrStart && result.size() < size; col--) {
                result.add(matrix[rowPtrEnd][col]);
            }

            rowPtrEnd--;

            for (int row = rowPtrEnd; row >= rowPtrStart && result.size() < size; row--) {
                result.add(matrix[row][colPtrStart]);
            }

            colPtrStart++;
        }

        return result;
    }
}
