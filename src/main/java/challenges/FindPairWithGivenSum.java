package challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a "target - 30".
 *
 * Conditions:
 *     You will pick exactly 2 numbers.
 *     You cannot pick the same element twice.
 *     If you have muliple pairs, select the pair with the largest number.
 *
 * Example 1:
 *
 * Input: nums = [1, 10, 25, 35, 60], target = 90
 * Output: [2, 3]
 * Explanation:
 * nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
 *
 * Example 2:
 *
 * Input: nums = [20, 50, 40, 25, 30, 10], target = 90
 * Output: [1, 5]
 * Explanation:
 * nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30
 * nums[1] + nums[5] = 50 + 10 = 60 = 90 - 30
 * You should return the pair with the largest number.
 */
public class FindPairWithGivenSum
{
    public static List<Integer> findPair (List<Integer> nums, int target)
    {
        int newTarget = target - 30;
        List<Integer> result = Arrays.asList(-1, -1);

        int largest = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(newTarget - nums.get(i))) {
                if (largest < newTarget - nums.get(i) || largest < nums.get(i)) {
                    result.set(0, i);
                    result.set(1, map.get(newTarget - nums.get(i)));
                    largest = Math.max(nums.get(i), map.get(newTarget - nums.get(i)));
                }
            }
            else {
                map.put(nums.get(i), i);
            }
        }

        return result;
    }

    public static void main (String[] args)
    {
        findPair(Arrays.asList(20, 50, 40, 25, 30, 10), 90);
    }
}
