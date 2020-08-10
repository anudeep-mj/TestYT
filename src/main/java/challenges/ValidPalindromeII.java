package challenges;

import java.util.HashMap;

/**
 *  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 *  Example 1:
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindromeII {
    public static boolean validPalindrome (String s) {
        if (s == null) {
            return false;
        }
        for (int left = 0; left < s.length() / 2; left++) {
            int right = s.length() - 1 - left;
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    public static boolean isPalindrome (String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean validPalindromeBF(String s) {
        if(!sanitize(s)) {
            return false;
        }

        if(isPalindrome(s, -1)) {
            return true;
        } else {
            for(int i = 0; i < s.length(); i++) {
                if(isPalindrome(s, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean sanitize(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
                if(map.get(c) == 2) {
                    map.remove(c);
                }
            }
        }

        if(map.size() > 2) {
            return false;
        }
        return true;
    }

    public boolean isPalindrome(String s, int indexToJumpOver) {
        int left = 0;
        int right = s.length()-1;
        while(left <= right) {
            if(left == indexToJumpOver) {
                left++;
            }
            if(right == indexToJumpOver) {
                right--;
            }
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        validPalindrome("abca");
    }
}
