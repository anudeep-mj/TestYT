package challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generateIterative(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Collections.singletonList(0));
        for (int i = 1; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            List<Integer> prevRow = result.get(numRows - i);

            for (int j = 1; j < i; j++) {
                rowList.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            rowList.add(1);
            result.add(rowList);
        }

        return result;
    }
}
