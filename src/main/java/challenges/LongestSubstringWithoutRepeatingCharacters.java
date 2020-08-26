package challenges;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters
{
    public int lengthOfLongestSubstring (String s)
    {
        if (s == null) {
            return 0;
        }

        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        int result = 0;
        while (left <= right && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            else {
                result = Math.max(result, set.size());
                set.remove(s.charAt(left));
                left++;
            }
        }

        result = Math.max(result, set.size());

        return result;
    }
}
