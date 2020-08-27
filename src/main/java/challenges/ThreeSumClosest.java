package challenges;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Constraints:
 *     3 <= nums.length <= 10^3
 *     -10^3 <= nums[i] <= 10^3
 *     -10^4 <= target <= 10^4
 */
public class ThreeSumClosest
{
    public int threeSumClosest (int[] nums, int target)
    {
        if (nums.length < 3) {
            return -1;
        }
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int secondIdx = i + 1;
            int thirdIdx = nums.length - 1;
            while (secondIdx < thirdIdx) {
                int sum = first + nums[secondIdx] + nums[thirdIdx];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum <= target) {
                    secondIdx++;
                }
                else {
                    thirdIdx--;
                }
            }
        }
        return result;
    }
}
