package challenges;

import java.util.*;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */
public class PermutationInString {

    Map<Character, Integer> s2Map = null;

    public boolean checkInclusion(String s1, String s2) {
        if(s2.contains(s1)) {
            return true;
        }

        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i <= s2.length()-s1.length(); i++) {
            String s2Temp = s2.substring(i, i+s1.length());
            HashMap<Character, Integer> s1MapTemp = new HashMap<>();
            s1MapTemp.putAll(s1Map);

            if(permutation(s1MapTemp, s2Temp)) {
                return true;
            }
        }

        return false;
    }

    //rather than using a hashmap please use an array here. Its way more simpler and more importantly efficient
    private boolean permutation(HashMap<Character, Integer> s1Map, String s2) {
        for(char c : s2.toCharArray()) {
            if (s1Map.containsKey(c)) {
                s1Map.put(c, s1Map.get(c) - 1);
                if (s1Map.get(c) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusionBF(String s1, String s2) {
        if(s2.contains(s1)) {
            return true;
        }

        GenerateAllPermutationsOfString generateAllPermutationsOfString = new GenerateAllPermutationsOfString();
        List<String> permutations = generateAllPermutationsOfString.generatePermutations(s1);
        for (String s : permutations) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        permutationInString.checkInclusion("adc", "dcda");
    }

    public boolean checkIfTwoStringArePermutations(String s1, String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean checkIfTwoStringArePermutationsSort(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        return s2Arr.toString().contains(s1Arr.toString());
    }
}
