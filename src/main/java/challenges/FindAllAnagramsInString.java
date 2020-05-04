package challenges;
/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//pattern to use here: sliding window. https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        int counter = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        counter = freqMap.size();

        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                char cAtBegin = s.charAt(start);
                if (freqMap.containsKey(cAtBegin)) {
                    freqMap.put(cAtBegin, freqMap.get(cAtBegin) + 1);
                    if (freqMap.get(cAtBegin) > 0) {
                        counter++;
                    }
                }

                if (end - start == p.length()) {
                    result.add(start);
                }

                start++;
            }
        }

        return result;
    }
}


