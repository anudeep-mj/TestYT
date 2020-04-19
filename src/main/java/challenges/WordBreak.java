package challenges;
/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 * Note:
 *     The same word in the dictionary may be reused multiple times in the segmentation.
 *     You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple". Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    //right way: https://www.youtube.com/watch?v=hLQYQ4zj0qg
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        return wbRecursiveWithSet(s, wordDictSet);
    }

    private static boolean wbRecursiveWithSet(String s, HashSet<String> wordDictSet) {
        if (s.length() == 0) {
            return true;
        }

        for (int i = 0; i <= s.length(); i++) {
            if (wordDictSet.contains(s.substring(0, i))) {
                if (wbRecursiveWithSet(s.substring(i), wordDictSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    //wrong. fails for => ("bbcc", ["bc", "cb"])
    public static boolean wordBreakWrong(String s, List<String> wordDict) {
        boolean result = wbRecursive(s, wordDict);
        return result;
    }

    private static boolean wbRecursive(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        for (String dictWord : wordDict) {
            if (s.contains(dictWord)) {
                String t = s.replace(dictWord, "");
                if (wbRecursive(t, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        wordBreak("leetcode", Arrays.asList("leet", "code"));
    }
}
