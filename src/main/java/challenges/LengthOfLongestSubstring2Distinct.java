package challenges;
/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 */

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring2Distinct {
    public int lengthOfLongestSubstringTwoDistinct(String input) {
        int length = input.length();
        if (length == 0) {
            return 0;
        }
        int end = 0;
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        while (end < input.length()) {
            char c = input.charAt(end);
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
            end++;
            maxLen = Math.max(maxLen, end - start);
            while (freqMap.size() > 2) {
                char charToRemove = input.charAt(start);
                freqMap.put(charToRemove, freqMap.get(charToRemove) - 1);
                start++;
            }
        }
        return maxLen;
    }
}
