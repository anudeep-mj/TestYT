package challenges;

import utils.TrieConstructor;
import utils.TrieNodeMap;

/**
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
 * Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
 * <p>
 * Example 1:
 * Input: "banana"
 * Output: "ana"
 * <p>
 * Example 2:
 * Input: "abcd"
 * Output: ""
 */
public class LongestDuplicateSubstring {

    public static String longestDupSubstring(String S) {
        int left = 0;
        int right = S.length() - 1;
        TrieNodeMap root = new TrieNodeMap();
        TrieConstructor trieConstructor = new TrieConstructor();
        int max = -1;
        String result = "";
        boolean found = false;

        while (left <= right) {
            int mid = (left + (right - left) / 2);
            for (int i = 0; i <= S.length() - mid; i++) {
                String str = S.substring(i, i + mid);
                if (!trieConstructor.insertString(str, root)) {
                    if (mid > max) {
                        max = mid;
                        result = str;
                    }
                    found = true;
                    break;
                }
            }
            if (found) {
                left = mid + 1;
                found = false;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        longestDupSubstring("banana");
    }
}