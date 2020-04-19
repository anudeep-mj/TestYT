package challenges;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * [10, 9, 2, 5, 3, 7, 101, 18]
 * [1,  1, 1, 2, 2, 3, 4,  4]
 *
 * https://www.youtube.com/watch?v=fV-TF4OvZpk&t=641s
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int result = Integer.MIN_VALUE;
        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);

        for (int right = 1; right < nums.length; right++) {
            for (int left = 0; left < right; left++) {
                if (nums[left] < nums[right]) {
                    int cacheAtLeft = cache[left];
                    cache[right] = Math.max(cache[right], cacheAtLeft + 1);

                    //update result everytime we update cache.
                    result = Math.max(cache[right], result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
