package challenges;
/**
 * Given a string s and a string t, check if s is subsequence of t.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence.
 * In this scenario, how would you change your code?
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */

import java.util.Arrays;

public class isSubsequence
{
    public static boolean isSubsequence (String s, String t)
    {
        if (s.equals("")) {
            return true;
        }
        if (t.equals("")) {
            return false;
        }

        int sidx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(sidx) == t.charAt(i)) {
                sidx++;
            }

            if (sidx == s.length()) {
                return true;
            }
        }
        return false;
    }

    /*
    Missed the case of "aaaaaa", "bbaaaa". The mistake i did was didnt consider duplicate characters.

    Keep it simple. This was overcomplicated too much.
     */
    public static boolean isSubsequenceWrong (String s, String t)
    {

        if (s.equals("")) {
            return true;
        }
        if (t.equals("")) {
            return false;
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1000);

        for (int j = s.length() - 1; j >= 0; j--) {
            char schar = s.charAt(j);
            for (int i = t.length() - 1; i >= 0; i--) {
                char tchar = t.charAt(i);
                if (tchar == schar) {
                    dp[j] = i;
                    break;
                }
            }
        }

        if (dp.length == 1) {
            return dp[0] > 0;
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] < dp[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main (String[] args)
    {
        isSubsequence("abc", "");
    }
}
