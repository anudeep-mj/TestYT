package challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array nums sorted in ascending order, return true if and only if you can split it into 1
 * or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.
 *
 *
 * Example 1:
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 *
 * Example 2:
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 * Example 3:
 * Input: [1,2,3,4,4,5]
 * Output: False
 */
public class SplitArrayIntoConsecutiveSubsequences
{
    public static void main (String[] args)
    {
        isPossible(new int[] { 1, 2, 3, 4, 4, 5 });
    }

    //https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/182460/Java-O(n)-Time-O(n)-Space-Solution-with-Detailed-Example
    private static boolean isPossible (int[] nums)
    {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);

        for (int i : nums) {
            if (freq.get(i) == 0)
                continue;
            else if (appendfreq.getOrDefault(i, 0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i + 1, appendfreq.getOrDefault(i + 1, 0) + 1);
            }
            else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                appendfreq.put(i + 3, appendfreq.getOrDefault(i + 3, 0) + 1);
            }
            else
                return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }

    private static boolean isPossibleWr (int[] nums)
    {
        Map<Integer, Integer> freqMap = new HashMap<>();

        //create count map for the nums.
        for (int i : nums)
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);

        if (freqMap.size() < 3) {
            return false;
        }

        int left = 0;
        int right = 0;
        int prev = nums[0] - 1;

        while (right < nums.length) {
            if (Math.abs(nums[right] - prev) == 1) {
                right++;
                prev = nums[right - 1];
            }
            else {
                if (right - left < 3) {
                    return false;
                }

                prev = nums[right] - 1;
                left = right;
            }
        }

        return right - left > 2;
    }

    public static boolean isPossibleWrong (int[] nums)
    {
        int counter = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        //create count map for the nums.
        for (int i : nums)
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);

        while (!freqMap.isEmpty()) {
            int prev = freqMap.keySet().iterator().next() - 1;

            if (freqMap.size() < 3) {
                return false;
            }

            for (int key : freqMap.keySet()) {
                //for every key, check the difference with the previous key.
                //if the (key - previous) == 1, increment counter and continue.
                //else, check counter >= 3 and set counter = 1.
                if (Math.abs(key - prev) == 1) {
                    counter++;
                }
                else {
                    if (counter < 3) {
                        return false;
                    }
                    counter = 1;
                }

                prev = key;

                freqMap.put(key, freqMap.get(key) - 1);
            }

            freqMap.entrySet().removeIf(e -> e.getValue() == 0);
            counter = 0;
        }

        return true;
    }
}
