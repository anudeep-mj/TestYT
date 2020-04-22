package challenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousWithEqual01Array {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int count = 0;
        int idx = 0;
        Map<Integer, Integer> countMap = new HashMap<>(Collections.singletonMap(0, 0));
        for (int num : nums) {
            idx++;
            if (num == 0) {
                count--;
            } else {
                count++;
            }

            if (countMap.containsKey(count)) {
                maxLen = Math.max(maxLen, idx - countMap.get(count));
            } else {
                countMap.put(count, idx);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
