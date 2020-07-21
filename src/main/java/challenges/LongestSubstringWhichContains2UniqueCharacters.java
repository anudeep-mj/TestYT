package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the longest substring that contains at most only two unique characters.
 * For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
 */
public class LongestSubstringWhichContains2UniqueCharacters
{
    public static int lengthOfLongestSubstringTwoDistinct (String input)
    {
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (left <= right && right != input.length()) {

            if (freqMap.size() <= 2) {
                char rc = input.charAt(right);
                freqMap.put(rc, freqMap.getOrDefault(rc, 0) + 1);
                if (freqMap.size() <= 2) {
                    max = Math.max(max, right - left + 1);
                }
                right++;
            } else {
                char lc = input.charAt(left);
                freqMap.put(lc, freqMap.get(lc) - 1);
                if (freqMap.get(lc) == 0) {
                    freqMap.remove(lc);
                }
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstringTwoDistinct("abc");
    }
}
