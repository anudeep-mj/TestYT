package challenges;

import java.util.HashMap;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int result = recursiveHelperSum(nums, target, cache);
        return result;
    }

    private int recursiveHelperSum(int[] nums, int target, HashMap<Integer, Integer> cache) {
        if (target == 0) {
            return 1;
        }

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        int count = 0;
        for (int num : nums) {
            if (num <= target) {
                count = count + recursiveHelperSum(nums, target - num, cache);
            }
        }

        cache.put(target, count);
        return count;
    }

    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        combinationSumIV.combinationSum4(new int[]{1,2,3}, 4);
    }
}
