package challenges;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class BackspaceStringCompare {

    public static boolean backspaceCompareStack(String S, String T) {
        Stack<Character> stackS = processStack(S);
        Stack<Character> stackT = processStack(T);
        return String.valueOf(stackS).equals(String.valueOf(stackT));
    }

    private static Stack<Character> processStack(String t) {
        Stack<Character> stack = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack;
    }

    public static boolean backspaceCompareBruteForce(String S, String T) {
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder tBuilder = new StringBuilder();

        sBuilder = processString(S, sBuilder);
        tBuilder = processString(T, tBuilder);

        return sBuilder.toString().equals(tBuilder.toString());
    }

    private static StringBuilder processString(String S, StringBuilder sBuilder) {
        for (char c : S.toCharArray()) {
            if (c != '#') {
                sBuilder.append(c);
            } else {
                if (sBuilder.length() != 0) {
                    sBuilder.deleteCharAt(sBuilder.length() - 1);
                }
            }
        }
        return sBuilder;
    }

    public static void main(String[] args) {
        backspaceCompareBruteForce("ab#f", "c#d#");
    }
}
