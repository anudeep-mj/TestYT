package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array arr of distinct integers and a nonnegative integer k,
 * write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k.
 * If no such pairs exist, return an empty array.
 *
 * Note: the order of the pairs in the output array should maintain the order of the y element in the original array.
 *
 * Examples:
 * input:  arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 *
 * input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
 * output: []
 *
 * Constraints:
 *     [time limit] 5000ms
 *     [input] array.integer arr
 *         0 ≤ arr.length ≤ 100
 *     [input]integer k
 *         k ≥ 0
 *     [output] array.array.integer
 */
public class PairsWithSpecificKDifference
{
    /*
    x - y = k => x - k = y
     */
    static int[][] findPairs(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x - k, x);
        }
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int y = arr[i];
            if (map.containsKey(y)) {
                int[] temp = new int[2];
                temp[0] = map.get(y);
                temp[1] = y;
                resultList.add(temp);
            }
        }
        int idx = 0;
        int[][] result = new int[resultList.size()][2];
        for (int[] res : resultList) {
            result[idx] = res;
        }
        return result;
    }
    /*
    element - y = k; => element - k = y
     */
    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (set.contains(element - k)) {
                int[] temp = new int[2];
                temp[0] = element;
                temp[1] = element - k;
                resultList.add(temp);
            }
        }

        int idx = 0;
        int[][] result = new int[resultList.size()][2];
        for (int[] res : resultList) {
            result[idx] = res;
        }
        return result;
    }

    public static void main(String[] args) {
        findPairsWithGivenDifference(new int[]{0, -1, -2, 2, 1}, 1);
    }
}
