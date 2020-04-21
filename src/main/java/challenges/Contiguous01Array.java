package challenges;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class Contiguous01Array {
    public static int findMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int[] ctr = new int[2];
        int zeroCtr = 0;
        int oneCtr = 0;
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;

        for (; right < nums.length; right++) {
            int num = nums[right];
            ctr[num]++;

            if (ctr[0] == ctr[1]) {
                maxLen = Math.max(maxLen, right - left + 1);
                left = moveLeft(left, nums, ctr);
            }
        }
        return maxLen;
    }

    private static int moveLeft(int left, int[] nums, int[] ctr) {
        int numAtLeft = nums[left];
        int i = left++;
        while (i < nums.length) {
            if (nums[i] != numAtLeft) {
                return i;
            } else {
                ctr[numAtLeft]--;
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findMaxLength(new int[]{1, 1, 0, 0, 0, 1, 1, 1});
    }

}




