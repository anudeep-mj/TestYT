package challenges;

import java.util.Stack;

/**
 *  Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid.
 *  We define the validity of a string by these rules:
 *     Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 *     Any right parenthesis ')' must have a corresponding left parenthesis '('.
 *     Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 *     '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 *     An empty string is also valid.
 *
 * Example 1:
 * Input: "()"
 * Output: True
 *
 * Example 2:
 * Input: "(*)"
 * Output: True
 *
 * Example 3:
 * Input: "(*))"
 * Output: True
 */
public class ValidParenthesisStringWithStarWildCard {



    //wrong soln
    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int starCounter = 0;
        int extraCloses = 0;
        char popped;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if (c == '*') {
                starCounter++;
            }
            else if (c == ')') {
                if (!stack.isEmpty()) {
                    popped = stack.pop();
                } else {
                    extraCloses++;
                }
            }
        }

        if (stack.size() == 0 && extraCloses == 0) {
            return true;
        } else if (starCounter - stack.size() - extraCloses >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*");
    }
}
