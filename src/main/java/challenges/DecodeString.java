package challenges;
/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 * Example 4:
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        if (s == null) {
            return null;
        }

        Stack<Integer> countstk = new Stack<>();
        Stack<String> tempStk = new Stack<>();

        String tempRes = "";

        for (int i = 0; i < s.length(); ) {

            if (Character.isDigit(s.charAt(i))) {
                String dig = "";
                while (Character.isDigit(s.charAt(i))) {
                    dig += s.charAt(i);
                    i++;
                }
                countstk.push(Integer.valueOf(dig));
            } else if (s.charAt(i) == '[') {
                tempStk.push(tempRes);
                tempRes = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder popped = new StringBuilder(tempStk.pop());
                int ct = countstk.pop();

                for (int j = 0; j < ct; j++) {
                    popped.append(tempRes);
                }

                tempRes = popped.toString();
                i++;
            } else {
                tempRes = tempRes + s.charAt(i++);
            }
        }

        return tempRes.toString();
    }

    public static void main(String[] args) {
        decodeString("3[a2[c]]");
    }
}
