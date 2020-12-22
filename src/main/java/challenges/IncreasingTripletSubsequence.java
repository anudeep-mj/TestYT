package challenges;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
 * nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 *
 * Example 2:
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 * Example 3:
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 * Constraints:
 *     1 <= nums.length <= 105
 *     -231 <= nums[i] <= 231 - 1
 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 */
public class IncreasingTripletSubsequence {/*
    BF: basically from every idx, traverse right. When you get a val greater than current, set current to it and traverse right again and increase count till the end of the array.
    if count == 2 anywhere, return true. O(n^2)
    */

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }


        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= lowest) {
                lowest = n;
            } else if (n <= secondLowest) {
                secondLowest = n;
            } else {
                return true;
            }
        }

        return false;
    }
}