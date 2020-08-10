package challenges;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromeSubstring
{

    String result = "";
    int maxLen = Integer.MIN_VALUE;
    int lo = 0;

    public String longestPalindrome (String s)
    {
        if (s.length() <= 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            expandFromIndex(s, i, i);
            expandFromIndex(s, i, i + 1);
        }

        result = s.substring(lo, lo + maxLen);

        return result;
    }

    private void expandFromIndex (String s, int leftIdx, int rightIdx)
    {
        while (leftIdx >= 0 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {
            leftIdx--;
            rightIdx++;
        }

        if (rightIdx - leftIdx - 1 > maxLen) {
            maxLen = rightIdx - leftIdx - 1;
            // remember to do + 1 cause low is -1 in the above loop
            lo = leftIdx + 1;
        }
    }

    public static int longestPalindromeBF (String s)
    {
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

    public static boolean isPalindrome (String s)
    {
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

    public static void main (String[] args)
    {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        longestPalindromeSubstring.longestPalindrome("abba");
    }
}
