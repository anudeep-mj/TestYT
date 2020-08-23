package challenges;
/**
 * A string S of lowercase English letters is given. We want to partition this string into as many
 * parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 * Note:
 *     S will have length in range [1, 500].
 *     S will consist of lowercase English letters ('a' to 'z') only.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels
{
    public static List<Integer> partitionLabels (String S)
    {
        Map<Character, Integer> lastIdxforCharMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            lastIdxforCharMap.put(S.charAt(i), i);
        }

        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIdxforCharMap.get(S.charAt(i)));
            if (i == end) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }

    public static void main (String[] args)
    {
        partitionLabels("abcccccca");
    }
}
