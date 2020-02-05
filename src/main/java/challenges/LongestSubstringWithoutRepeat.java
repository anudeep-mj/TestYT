package challenges;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        //remember to check for empty strings and for spaces in strings
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int sIdx = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                maxLen = Math.max(maxLen, i - sIdx);
                int idxOfFirstOccurrence = map.get(s.charAt(i));
                sIdx = idxOfFirstOccurrence + 1;
                clearHashMapOfCharactersBeforeIndex(map, idxOfFirstOccurrence);
                map.put(s.charAt(i), i);
            }
        }
        maxLen = Math.max(maxLen, s.length() - sIdx);
        return maxLen;
    }

    private static void clearHashMapOfCharactersBeforeIndex(Map<Character, Integer> map, int idxOfFirstOccurrence) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value <= idxOfFirstOccurrence) {
                map.remove(key);
            }
        }
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcddabcx");
    }
}
