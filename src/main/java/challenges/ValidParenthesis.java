package challenges;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 *
 * Constraints:
 *     1 <= s.length <= 104
 *     s consists of parentheses only '()[]{}'.
 */
public class ValidParenthesis
{
    public boolean isValid (String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.size() == 0) {
                    return false;
                }
                else {
                    Character popped = stack.pop();
                    if (!isValidOpen(popped, c)) {
                        return false;
                    }
                }
            }
        }
        return stack.size() != 0;
    }

    //Should have used a map here. wtf
    public boolean isValidOpen (Character fromStack, Character input)
    {
        if (fromStack == '(' && input == ')') {
            return true;
        }
        else if (fromStack == '[' && input == ']') {
            return true;
        }
        else if (fromStack == '{' && input == '}') {
            return true;
        }
        else {
            return false;
        }
    }

}
