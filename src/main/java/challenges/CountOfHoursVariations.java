package challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a generic digital clock, having h number of hours and m number of minutes, the task is to find how many times the clock shows identical time.
 * The parameters were 4 integers A,B,C,D. The valid time should be somewhere between 00:00 and 24:00.
 * If the integers don't fulfil the requirements the function should return 0.
 * Restrictions: A,B,C,D are integers between [0,9]
 *
 * public static int solve(int A, int B, int C, int D) {
 * //return the count of how many variants are there to combine the four integers so its a valid hour
 * // from 00:00 to 24:00
 * }
 *
 * Testcase#1 (1,0,0,2) => (00:12) (00:21) (01: 02) (01:20) (02:10) (02:01) (10:02) (10:20) (12:00) (20:01) (20:10) (21:00) => should return 12
 * Testcase#2 (2,1,2,1) => should return 6
 * Testcase#3 (1,4,8,2) => should return 5
 * Testcase#4 (4,4,4,4) => should return 0
 */
public class CountOfHoursVariations {

    static int result = 0;
    static List<List<Integer>> resultVariations;

    public static int solve(int A, int B, int C, int D) {
        resultVariations = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);
        Collections.sort(list);
        if (!isCorrectTime(list)) {
            return result;
        }

        countVariations(list, new ArrayList<>(), 0, new boolean[list.size()]);
        return result;
    }

    private static void countVariations(List<Integer> list, ArrayList<Integer> currentPermutation, int idx, boolean[] visited) {
        if (idx == list.size()) {
            if (isCorrectTime(currentPermutation)) {
                result++;
                resultVariations.add(new ArrayList<>(currentPermutation));
                return;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            //this needs to looked at again to re understand
            if (visited[i] || (i > 0 && list.get(i).equals(list.get(i - 1)) && !visited[i-1])) {
                continue;
            }

            visited[i] = true;
            currentPermutation.add(list.get(i));
            countVariations(list, currentPermutation, idx + 1, visited);
            visited[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }


    private static boolean isCorrectTime(List<Integer> arr) {
        int hours = arr.get(0) * 10 + arr.get(1);
        int mins = arr.get(2) * 10  +arr.get(3);
        if (hours < 0 || hours > 23) {
            return false;
        }

        if (mins < 0 || mins > 59) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        solve(1,1,1,1);
    }
}
