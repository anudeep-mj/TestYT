package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 *
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 *
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean foundMid = false;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (foundMid) {
                    return false;
                } else {
                    foundMid = true;
                }
            }
        }

        return true;
    }
}
