package challenges;

/**
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j],
 * there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 *
 * Example 1:
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 *
 * Example 2:
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 * Example 3:
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 *
 * Example 4:
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 *
 * Example 5:
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 */
public class MaximumSumCircularSubarray {

    public static int maxSubarraySumCircular(int[] A) {

        int maxSoFar = A[0];
        int minSoFar = A[0];
        int maxMaxSoFar = A[0];
        int minMinSoFar = A[0];
        int sum = A[0];

        for(int i = 1; i < A.length; i++) {
            int numAtIdx = A[i];
            //maxSoFar basically is the Kadane's subarray max at every idx. same for minSoFar
            maxSoFar = Math.max(numAtIdx, maxSoFar + numAtIdx);
            minSoFar = Math.min(numAtIdx, minSoFar + numAtIdx);

            maxMaxSoFar = Math.max(maxMaxSoFar, maxSoFar);
            minMinSoFar = Math.min(minMinSoFar, minSoFar);
            sum += numAtIdx;
        }

        if (sum-minMinSoFar == 0) {
            return maxMaxSoFar;
        }

        return Math.max(sum-minMinSoFar, maxMaxSoFar);
    }

    public static int maxSubarraySumCircularBF(int[] A) {
        int max = Integer.MIN_VALUE;
        int len = A.length;
        for (int left = 0; left < len; left++) {
            int right = left;
            int tempSum = 0;
            int count = 0;
            while(count < len) {
                if(right == len) {
                    right = 0;
                }

                tempSum = tempSum + A[right];
                max = Math.max(max, tempSum);

                count++;
                right++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        maxSubarraySumCircular(new int[]{-2,-3,-5});
    }
}
