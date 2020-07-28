package challenges;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchA2DMatrix
{
    public boolean searchMatrix (int[][] matrix, int target)
    {
        int[] cols = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            cols[i] = matrix[i][0];
        }

        int rowIdx = getRowIdx(cols, target);

        int[] row = getRow(matrix, rowIdx);

        return binSearchOnArray(row, target);
    }

    private int[] getRow (int[][] matrix, int rowIdx)
    {
        int[] row = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            row[i] = matrix[rowIdx][i];
        }
        return row;
    }

    private int getRowIdx (int[] cols, int target)
    {
        for (int i = 0; i < cols.length - 1; i++) {
            if ((cols[i] < target) && (cols[i + 1] >= target)) {
                return i;
            }
        }
        return -1;
    }

    private boolean binSearchOnArray (int[] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
