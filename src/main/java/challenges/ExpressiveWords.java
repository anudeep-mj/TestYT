package challenges;
/**
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".
 * In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 *
 * For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications
 * of the following extension operation: choose a group consisting of characters c, and add some number of characters c
 * to the group so that the size of the group is 3 or more.
 *
 * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo",
 * but we cannot get "helloo" since the group "oo" has size less than 3.
 * Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".
 * If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.
 *
 * Given a list of query words, return the number of words that are stretchy.
 *
 * Example:
 * Input:
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 *
 * Constraints:
 *     0 <= len(S) <= 100.
 *     0 <= len(words) <= 100.
 *     0 <= len(words[i]) <= 100.
 *     S and all words in words consist only of lowercase letters
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords
{
    /*
    Another soln is to just iterate over each word and check if its a stretchy word of S.
    basically the same principle but you count everything dynamically with two pointers: https://leetcode.com/problems/expressive-words/discuss/121706/Java-Solution-using-Two-Pointers-with-Detailed-Explanation
     */
    public int expressiveWords (String S, String[] words)
    {
        WordMetadata sMetadata = new WordMetadata(S);

        int count = 0;
        s: for (String word : words) {
            WordMetadata wMetadata = new WordMetadata(word);
            if (!wMetadata.key.equals(sMetadata.key)) {
                continue;
            }

            for (int i = 0; i < wMetadata.counts.size(); i++) {
                int cS = sMetadata.counts.get(i);
                int cW = wMetadata.counts.get(i);

                if (cS < cW) {
                    continue s;
                }

                if (cS < 3 && cS != cW) {
                    continue s;
                }
            }
            count++;
        }

        return count;
    }

    public static void main (String[] args)
    {
        ExpressiveWords expressiveWords = new ExpressiveWords();
        expressiveWords.expressiveWords("heeellooo", new String[] { "hello", "hi", "helo" });
    }

    class WordMetadata
    {
        String key;
        List<Integer> counts;

        public WordMetadata (String s)
        {
            StringBuilder sb = new StringBuilder();
            counts = new ArrayList<>();
            int prev = -1;
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                    sb.append(s.charAt(i));
                    //sb.append(i - prev);
                    counts.add(i - prev);
                    prev = i;
                }
            }
            key = sb.toString();
        }
    }
}
