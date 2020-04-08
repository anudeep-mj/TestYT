package challenges;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * If there're duplicates in arr, count them seperately.
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 */
public class CountingElements {

    public static int countElements(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : arr) {
            priorityQueue.add(i);
        }

        int dup = 0;
        int count = 0;
        int first = priorityQueue.poll();
        for (int i = 0; i < arr.length - 1; i++) {
            int second = priorityQueue.poll();
            if (second - first == 0) {
                dup++;
            } else if (second - first == 1) {
                count = count + dup + 1;
                dup = 0;
            } else {
                dup = 0;
            }
            first = second;
        }
        return count;
    }

    public static int countElementsWaaayyBetterOneWhichICouldntThinkOfToSaveMyLife(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int count = 0;
        for (int i : arr) {
            if (set.contains(i+1)) {
                count++;
            }
        }
        return count;
    }

    public static int countElementsWrong(int[] arr) {
        int count = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : arr) {
            treeSet.add(i);
        }
        int size = treeSet.size();

        int first = treeSet.pollFirst();
        for (int i = 0; i < size-1; i++) {
            int second =  treeSet.pollFirst();
            if (second - first == 1) {
                count++;
            }
            first = second;
        }
        return count;
    }
    public static void main(String[] args) {
        countElements(new int[]{2,2,1,1});
    }
}
