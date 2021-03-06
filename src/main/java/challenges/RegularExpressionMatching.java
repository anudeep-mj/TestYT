package challenges;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *     s could be empty and contains only lowercase letters a-z.
 *     p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 *
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching
{
    public static boolean isMatch (String s, String p)
    {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //a* a*b*
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                char cs = s.charAt(row - 1);
                char cp = p.charAt(col - 1);

                if (cs == cp || cp == '.') {
                    dp[row][col] = dp[row - 1][col - 1];
                }
                else if (cp == '*') {
                    dp[row][col] = dp[row][col - 2];
                    if (s.charAt(row - 1) == p.charAt(col - 2) || p.charAt(col - 2) == '.') {
                        dp[row][col] = dp[row][col] || dp[row - 1][col];
                    }
                }
                else {
                    dp[row][col] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main (String[] args)
    {
        isMatch("", "*");
    }
}
