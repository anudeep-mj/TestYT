package challenges;

import utils.ListNode;

import java.util.*;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * In one step you can jump from index i to index:
 *     i + 1 where: i + 1 < arr.length.
 *     i - 1 where: i - 1 >= 0.
 *     j where: arr[i] == arr[j] and i != j.
 *
 * Return the minimum number of steps to reach the last index of the array.
 * Notice that you can not jump outside of the array at any time.
 *
 * Example 1:
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 *
 * Example 2:
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You don't need to jump.
 *
 * Example 3:
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 *
 * Example 4:
 *
 * Input: arr = [6,1,9]
 * Output: 2
 *
 * Example 5:
 * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 * Output: 3
 *
 * Constraints:
 *     1 <= arr.length <= 5 * 10^4
 *     -10^8 <= arr[i] <= 10^8
 */
public class JumpGameIV {

    static Map<Integer, ArrayList<Integer>> jumpMap = new HashMap<>();
    static int minCount = Integer.MAX_VALUE;

    public static int minJumps(int[] arr) {
        jumpMap = new HashMap<>();
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!jumpMap.containsKey(arr[i])) {
                jumpMap.put(arr[i], new ArrayList<>());
            }
            ArrayList<Integer> list = jumpMap.get(arr[i]);
            list.add(i);
            jumpMap.put(arr[i], list);
        }

        jumpHelper(arr, 0, visited, 0);
        return minCount;
    }

    private static void jumpHelper(int[] arr, int idx, boolean[] visited, int count) {
        if (idx == arr.length - 1) {
            minCount = Math.min(minCount, count);
            return;
        }

        if (idx < 0 || idx >= arr.length || visited[idx]) {
            return;
        }

        List<Integer> possibleChoices = new ArrayList<>();

        possibleChoices.add(idx + 1);
        possibleChoices.add(idx - 1);

        ArrayList<Integer> possibleJumps = jumpMap.get(arr[idx]);
        for (int possibleJumpIdx : possibleJumps) {
            if (possibleJumpIdx != idx && !possibleChoices.contains(possibleJumpIdx)) {
                possibleChoices.add(possibleJumpIdx);
            }
        }

        for (int possibleChoice : possibleChoices) {
            visited[idx] = true;
            jumpHelper(arr, possibleChoice, visited, count + 1);
            visited[idx] = false;
        }
    }

    public static void main(String[] args) {
        minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13});
    }


    //BFS. Not my code. But should have remembered to think of BFS when the requirement needed "shortest" path.
    public int minJumpsBFS(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; i++)
            indicesOfValue.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        boolean[] visited = new boolean[n]; visited[0] = true;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.poll();
                if (i == n - 1) return step; // Reached to last index
                List<Integer> next = indicesOfValue.get(arr[i]);
                next.add(i - 1); next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear(); // avoid later lookup indicesOfValue arr[i]
            }
            step++;
        }
        return 0;
    }
}
