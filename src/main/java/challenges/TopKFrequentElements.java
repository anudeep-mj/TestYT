package challenges;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 *     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *     Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *     It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 *     You can return the answer in any order.
 */
public class TopKFrequentElements
{
    //nlogk
    public static int[] topKFrequent (int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            if (!pq.isEmpty()) {
                result[i] = pq.poll();
            }
        }

        return result;
    }

    public static void main (String[] args)
    {
        topKFrequent(new int[] { 1, 2 }, 2);
    }
}
