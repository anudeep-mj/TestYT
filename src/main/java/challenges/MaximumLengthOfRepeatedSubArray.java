package challenges;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 */
public class MaximumLengthOfRepeatedSubArray {

    /*
    Interesting part here is that we should only focust on the letters before. So the dp condition is only on the diagonal previous in the matrix
     */
    public int findLength(int[] A, int[] B) {
        int[][] dpMatrix = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    dpMatrix[i][j] = dpMatrix[i-1][j-1] + 1;
                    max = Math.max(max, dpMatrix[i][j]);
                }
            }
        }

        return max;
    }
}
