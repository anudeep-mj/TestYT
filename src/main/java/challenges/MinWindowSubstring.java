package challenges;
/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubstring {

    static Map<Character, Integer> freqMap;
    static Set<Character> charSet;
    static int resultSize = Integer.MAX_VALUE;
    static String result = "";

    static String getShortestUniqueSubstring(char[] arr, String str) {
        freqMap = new HashMap<>();
        charSet = new HashSet<>();
        for(char c : arr) {
            charSet.add(c);
        }

        int left = 0;
        int right = 0;


        while(right < str.length()) {
            char c = str.charAt(right++);
            if(charSet.contains(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            int mapSize = freqMap.size();

            if(mapSize == arr.length) {

                if(right - left + 1 < resultSize) {
                    resultSize = right - left;
                    result = str.substring(left, right);
                }


                while(freqMap.size() >= arr.length) {
                    char cLeft = str.charAt(left);
                    if(freqMap.containsKey(cLeft)) {
                        freqMap.put(cLeft, freqMap.get(cLeft) - 1);
                        if(freqMap.get(cLeft) == 0) {
                            freqMap.remove(cLeft);
                        }
                    }
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        getShortestUniqueSubstring(new char[]{'x', 'y', 'z'}, "xxyzz");
    }


    public Integer minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int counter = t.length();
        int minWindowLength = Integer.MAX_VALUE;

        while (end < s.length()) {
            Character c = s.charAt(end++);

            //if character is in t
            if (tmap.containsKey(c)) {
                counter--;
            }

            tmap.put(c, tmap.getOrDefault(c, 0) - 1);

            while (counter == 0) {
                minWindowLength = Math.min(minWindowLength, end - start + 1);
                Character chatAtStart = s.charAt(start);
                tmap.put(chatAtStart, tmap.get(chatAtStart) + 1);
                if (tmap.get(chatAtStart) > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minWindowLength;
    }
}
