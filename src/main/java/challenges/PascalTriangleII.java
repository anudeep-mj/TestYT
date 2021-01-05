package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 * Notice that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * Constraints:
 *     0 <= rowIndex <= 33
 */
public class PascalTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        Integer[] resultArray = new Integer[rowIndex + 1];

        result.add(1);
        for(int i = 1; i < rowIndex + 1; i++) {
            resultArray[0] = 1;

            for(int j = i; j >= 1; j--) {
                resultArray[j] = resultArray[j-1] + resultArray[j];
            }
        }

        return Arrays.asList(resultArray);
    }

    public static void main(String[] args) {
        getRow(2);
    }
}
