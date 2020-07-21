package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print longest possible substring that has exactly K unique characters.
 * If there are more than one substring of longest possible length, then print any one of them.
 */
public class LongestSubstringWhichContainsKUniqueCharacters
{
    static String kUniques (String input, int k)
    {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        String result = "";

        while (left <= right && right != input.length()) {
            if (map.size() <= k) {
                char rc = input.charAt(right);
                map.put(rc, map.getOrDefault(rc, 0) + 1);
                if (map.size() <= k) {
                    if (right - left + 1 > max) {
                        result = input.substring(left, right + 1);
                    }
                }
                right++;
            }
            else {
                char lc = input.charAt(left);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) {
                    map.remove(lc);
                }
                left++;
            }
        }
        return result;
    }

    public static void main (String[] args)
    {
        kUniques("aaabbxxxxxv", 1);
    }
}
