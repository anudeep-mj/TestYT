package challenges;
/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * Constraints:
 *     0 <= nums.length <= 2 * 104
 *     -231 <= nums[i] <= 231 - 1
 *     0 <= k <= 104
 *     0 <= t <= 231 - 1
 */

import java.util.TreeSet;

public class ContainsDuplicateIII {

    //forgot to make the tree set long. Not handling the case where nums could be [Int.MX_VAL, Int.MIN_VAL]
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            long curr = nums[i];
            Long floor = set.floor(curr);
            //check if curr-lowest value more than it is less than or eq to t
            if (floor != null && curr - floor <= t) {
                return true;
            }

            Long ceiling = set.ceiling(curr);
            if (ceiling != null && ceiling - curr <= t) {
                return true;
            }

            set.add(curr);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}