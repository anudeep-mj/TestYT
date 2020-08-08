package challenges;

import java.util.PriorityQueue;

/**
 * Given an array of integers arr where each element is at most k places away from its sorted position,
 * code an efficient function sortKMessedArray that sorts arr.
 * For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the
 * sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
 * Analyze the time and space complexities of your solution.
 * Example:
 * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
 * output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Constraints:
 * [time limit] 5000ms
 * [input] array.integer arr
 * 1 ≤ arr.length ≤ 100
 * [input] integer k
 * 0 ≤ k ≤ 20
 * [output] array.integer
 */
public class KMessedArraySort
{
    static int[] sortKMessedArray (int[] arr, int k)
    {
        if (arr.length == 0) {
            return arr;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            while (minHeap.size() <= k + 1 && j < arr.length) {
                minHeap.offer(arr[j++]);
            }

            int minValueInHeap = minHeap.poll();

            arr[i] = minValueInHeap;
        }

        //System.out.println(Arrays.toString(arr));

        return arr;
    }

    public static void main (String[] args)
    {
        //[0,1,2,3,4,5,6,7,8]
        sortKMessedArray(new int[] { 1, 0, 3, 2, 4, 5, 7, 6, 8 }, 1);
    }
}
