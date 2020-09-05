package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 *
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 */
public class LargestTimeGivenDigits
{
    final int MAX_HR = 24;
    final int MAX_MINS = 60;

    public String largestTimeFromDigits (int[] A)
    {
        List<String> permutations = getAllPermutations(A);
        String result = "";

        for (String s : permutations) {
            int hour = Integer.parseInt(s.substring(0, 1));
            int mins = Integer.parseInt(s.substring(2));

            if (result.compareTo(hour + ":" + mins) < 0) {
                result = hour + ":" + mins;
            }
        }

        return result;
    }

    private List<String> getAllPermutations (int[] a)
    {
        String s = "";
        for (int i : a) {
            s = s + i;
        }

        List<String> resultList = new ArrayList<String>();

        getAllPermutationsRecursive(s, "", resultList);
        return resultList;
    }

    private void getAllPermutationsRecursive (
        String leftOver,
        String curr,
        List<String> strings)
    {
        if (leftOver.length() == 0) {
            if (Integer.parseInt(curr.substring(2)) < MAX_MINS) {
                strings.add(curr);
            }
            return;
        }

        if (curr.length() == 2 && Integer.parseInt(curr) >= MAX_HR) {
            return;
        }

        for (int i = 0; i < leftOver.length(); i++) {
            getAllPermutationsRecursive(leftOver.substring(0, i) + leftOver.substring(i + 1),
                curr + leftOver.charAt(i), strings);
        }
    }
}
