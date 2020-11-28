package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * Constraints:
 *     1 <= nums.length <= 200
 *     1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        // if the total sum is not even, then it cant be divided into two equal parts.
        int total = 0;
        for(int i : nums) {
            total += i;
        }
        if (total % 2 != 0) {
            return false;
        }

        Map<String, Boolean> memoMap = new HashMap<>();

        return canPartition(nums, 0, 0, total, memoMap);
    }

    private boolean canPartition(int[] nums, int idx, int currSum, int total, Map<String, Boolean> memoMap) {
        String memoKey = idx + "," + currSum;
        if (memoMap.containsKey(memoKey)) {
            return memoMap.get(memoKey);
        }

        if (currSum * 2 == total) {
            return true;
        }

        if (currSum > total || idx >= nums.length) {
            return false;
        }

        boolean found = canPartition(nums, idx + 1, currSum, total, memoMap) || canPartition(nums, idx + 1, currSum + nums[idx], total, memoMap);

        memoMap.put(memoKey, found);

        return found;
    }
}
