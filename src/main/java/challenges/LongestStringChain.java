package challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of words, each word consists of English lowercase letters.
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter
 * anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1,
 * where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 * Example 1:
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 *
 * Note:
 *     1 <= words.length <= 1000
 *     1 <= words[i].length <= 16
 *     words[i] only consists of English lowercase letters.
 */
public class LongestStringChain
{
    public static int longestStrChain (String[] words)
    {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String w : words) {
            map.put(w, 1);
            for (int i = 0; i < w.length(); i++) {
                StringBuilder sb = new StringBuilder(w);
                sb.deleteCharAt(i);

                String previous = sb.toString();
                if (map.containsKey(previous)) {
                    if (map.get(previous) + 1 > map.get(w)) {
                        map.put(w, map.get(previous) + 1);
                    }
                }
                result = Math.max(result, map.get(w));
            }
        }

        return result;
    }

    public static int longestStrChainBF (String[] words)
    {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            int count = 0;
            for (int j = i; j < words.length; j++) {
                if (words[j + 1].length() - words[j].length() == 1
                    && diff(words[j], words[j + 1]) == 1)
                {
                    count++;
                    result = Math.max(result, count);
                }
                else {
                    break;
                }
            }
        }
        return result;
    }

    private static int diff (String w1, String w2)
    {
        int count = 0;
        char[] w1arr = w1.toCharArray();
        Arrays.sort(w1arr);
        char[] w2arr = w2.toCharArray();
        Arrays.sort(w2arr);

        w1 = String.valueOf(w1arr);
        w2 = String.valueOf(w2arr);

        for (int i = 0; i < w2.length() - 1; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
        }
        return count + 1;
    }

    public static void main (String[] args)
    {
        longestStrChain(new String[] { "a", "b", "ba", "bda", "bca", "bdca" });
    }
}
