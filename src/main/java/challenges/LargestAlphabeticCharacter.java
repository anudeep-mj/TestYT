package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, find the largest alphabetic character, whose both uppercase and lowercase appear in S.
 * The uppercase character should be returned. For example, for S = "admeDCAB", return "D". If there is no such character, return "NO".
 */
public class LargestAlphabeticCharacter {

    public static String largestCharacter(String s) {
        Map<Integer, Integer> lowerCaseMap = new HashMap<>();
        Map<Integer, Integer> upperCaseMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {

        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerCaseMap.put(c -'a', lowerCaseMap.getOrDefault(c, 0));
            } else {
                upperCaseMap.put(c -'A', upperCaseMap.getOrDefault(c, 0));
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lowerCaseMap.get(i) != null && upperCaseMap.get(i) != null) {
                return (char) i + 'A' + "";
            }
        }

        return "";
    }
}
