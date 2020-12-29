package challenges;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays
{
    static int count = 0;

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() +1];

        //what this basically means is that there is 1 way of decoding a string of size = 0;
        dp[0] = 1;

        //basically means if the first char is 0, we dont have a mapping for it.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigits = Integer.valueOf(s.substring(i-2, i));
            if (oneDigit >= 1) {
                dp[i] = dp[i] + dp[i-1];
            }
            if (twoDigits > 9 && twoDigits < 27) {
                dp[i] = dp[i] + dp[i-2];
            }
        }

        return dp[s.length()];
    }


    public static int numDecodingsRecursive (String s) {
        return s.length() == 0 ? 0 : decodingRecHelper(0, s);
    }

    private static int decodingRecHelper(int idx, String s) {
        int len = s.length();
        if (idx == len) {
            return 1;
        }

        if (s.charAt(idx) == '0') {
            return 0;
        }

        int res = decodingRecHelper(idx + 1, s);

        if (idx < len - 1 && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7'))) {
            res = res + decodingRecHelper(idx + 2, s);
        }

        return res;
    }

    public static void main(String[] args) {
        numDecodingsRecursive("123");
    }
}
