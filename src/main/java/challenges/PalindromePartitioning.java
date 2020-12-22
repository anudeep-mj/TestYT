package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 *     1 <= s.length <= 16
 *     s contains only lowercase English letters.
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }

        partitionHelper(0, s, result, new ArrayList<>());
        return result;
    }

    private static void partitionHelper(int currPtr, String s, List<List<String>> result, List<String> current) {
        if(currPtr == s.length()) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = currPtr; i < s.length(); i++) {
                if (isPalindrome(s, currPtr, i)) {
                    String palindromeSnippet = s.substring(currPtr, i + 1);
                    current.add(palindromeSnippet);
                    partitionHelper(i + 1, s, result, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        partition("aab");
    }
}
