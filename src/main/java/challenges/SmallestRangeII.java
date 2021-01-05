package challenges;

import java.util.Arrays;

/**
 * Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 * Example 1:
 * Input: A = [1], K = 0
 * Output: 0
 * Explanation: B = [1]
 *
 * Example 2:
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 *
 * Example 3:
 * Input: A = [1,3,6], K = 3
 * Output: 3
 * Explanation: B = [4,6,3]
 */
public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        int len = A.length;
        int result = A[len - 1] - A[0];

        for (int i = 0; i < len - 1; i++) {

            int max = Math.max(A[i] + K, A[len - 1] - K);
            int min = Math.min(A[0] + K, A[i + 1] - K);

            result = Math.min(result, max - min);
        }

        return result;
    }
}
