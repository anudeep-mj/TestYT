package challenges;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        int maxLen = 0;
        return "";
    }

    public static int longestPalindromeBF(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substringOfS = s.substring(i, j);
                if (isPalindrome(substringOfS)) {
                    maxLen = Math.max(maxLen, substringOfS.length());
                }
            }
        }
        return maxLen;
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            /*
            we can have a dp matrix of size main string here and verify if the smaller string is a palindrome and store the cache.
             */
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
