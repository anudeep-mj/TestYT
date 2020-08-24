package challenges;
/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

import java.util.PriorityQueue;

public class KthLargestElementInArray
{
    public static int findKthLargest (int[] nums, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        for (int i = 0; i < heap.size() - 1; i++) {
            heap.poll();
        }
        return heap.poll();
    }

    public static void main (String[] args)
    {
        findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4);
    }
}
