package challenges;

import java.util.TreeMap;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 *
 * Example 1:
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 *
 * Example 2:
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 *
 * Example 3:
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 *
 * Example 4:
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 */
public class DivideArrayInSetsOfKConsecutiveNumbers
{
    public boolean isPossibleDivide (int[] nums, int k)
    {
        if (nums.length < k) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //challenges/HandOfStraights.java is simpler.. no tempK business jus a simple loop to check if the tbd variable exists or not.
        while (!map.isEmpty()) {
            int firstKey = map.firstKey();
            int tempK = k;

            while (tempK != 0 && !map.isEmpty()) {
                int tbd = firstKey + tempK;
                if (!map.containsKey(tbd)) {
                    return false;
                }
                else {
                    map.put(tbd, map.get(tbd) - 1);
                    if (map.get(tbd) == 0) {
                        map.remove(tbd);
                    }
                }
                tempK--;
            }

            if (tempK > 0) {
                return false;
            }
        }

        return true;
    }
}
