package challenges;

/**
 * Given a binary string s (a string consisting only of '0' and '1's).
 * Return the number of substrings with all characters 1's.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Example 1:
 * Input: s = "0110111"
 * Output: 9
 * Explanation: There are 9 substring in total with only 1's characters.
 * "1" -> 5 times.
 * "11" -> 3 times.
 * "111" -> 1 time.
 * <p>
 * Example 2:
 * Input: s = "101"
 * Output: 2
 * Explanation: Substring "1" is shown 2 times in s.
 * <p>
 * Example 3:
 * Input: s = "111111"
 * Output: 21
 * Explanation: Each substring contains only 1's characters.
 * <p>
 * Example 4:
 * Input: s = "000"
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * s[i] == '0' or s[i] == '1'
 * 1 <= s.length <= 10^5
 */
public class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        int mo = 1000000007;

        int count = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count = count + 1;
                //System.out.println(count);
                result = (result + count) % mo;
            } else {
                count = 0;
            }
        }
        return result;
    }
}
