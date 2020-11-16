package challenges;

/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 *     B.length >= 3
 *     There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain.
 * Return 0 if there is no mountain.
 *
 * Example 1:
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 *
 * Example 2:
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 * Note:
 *     0 <= A.length <= 10000
 *     0 <= A[i] <= 10000
 *
 * Follow up:
 *     Can you solve it using only one pass?
 *     Can you solve it in O(1) space?
 */
public class LongestMountainInArray
{
    /*
    BF: for every element in the array, check for length of descending order to the left and ascending order to right.
    */
    public static int longestMountainBF(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int mx = 0;
        for(int i = 1; i < A.length - 1; i++) {
            if(A[i] > A[i-1] && A[i] > A[i+1]) {
                mx = Math.max(mx, 1 + lenOfDescendingOrderToLeft(A, i) + lenOfAscendingOrderToRight(A, i));
            }
        }
        return mx == 1 ? 0 : mx;
    }

    private static int lenOfDescendingOrderToLeft(int[] A, int idx) {
        if (idx == 0) {
            return 0;
        }
        int count = 0;
        int upLimit = A[idx];
        for (int i = idx - 1; i >=0; i--) {
            if(A[i] < upLimit) {
                count++;
                upLimit = A[i];
            } else {
                return count;
            }
        }
        return count;
    }

    private static int lenOfAscendingOrderToRight(int[] A, int idx) {
        if (idx == A.length - 1) {
            return 0;
        }
        int count = 0;
        int lowLimit = A[idx];
        for (int i = idx + 1; i < A.length; i++) {
            if(A[i] > lowLimit) {
                count++;
                lowLimit = A[i];
            } else {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //longestMountain(new int[] {2,1,4,7,3,2,5});
    }
}
