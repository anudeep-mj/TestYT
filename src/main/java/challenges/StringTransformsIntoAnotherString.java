package challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
 * Return true if and only if you can transform str1 into str2.
 *
 * Example 1:
 *
 * Input: str1 = "aabcc", str2 = "ccdee"
 * Output: true
 * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
 *
 * Example 2:
 *
 * Input: str1 = "leetcode", str2 = "codeleet"
 * Output: false
 * Explanation: There is no way to transform str1 to str2.
 */
public class StringTransformsIntoAnotherString
{
    public boolean canConvert(String str1, String str2) {
        Map<Character, Character> map = new HashMap<>();
        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.equals(str2)) {
            return true;
        }

        for (int i = 0; i< str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            } else {
                map.put(c1, c2);
            }
        }

        //https://leetcode.com/problems/string-transforms-into-another-string/discuss/399352/Complete-Logical-Thinking-(This-is-why-only-check-if-str2-has-unused-character)
        return new HashSet<Character>(map.values()).size() < 26;
    }
}
