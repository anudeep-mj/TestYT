package challenges;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static int maxSubArrayKadane(int[] num) {
        int maxSum = num[0];
        for(int i = 1; i < num.length; i++) {
            int numAtIdx = num[i];
            if(numAtIdx < num[i] + num[i-1]) {
                num[i] = num[i] + num[i-1];
            } else {
                num[i] = numAtIdx;
            }

            maxSum = Math.max(maxSum, num[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
