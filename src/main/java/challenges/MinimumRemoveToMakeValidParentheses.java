package challenges;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
 * the resulting parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class MinimumRemoveToMakeValidParentheses
{
    //super intuitive with usage of indexes of '('s
    public String minRemoveToMakeValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                stringBuilder.append(c);
            } else {
                if(c == '(') {
                    stack.push(i);
                    stringBuilder.append(c);
                } else {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        stringBuilder.append(c);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            stringBuilder.setCharAt(stack.pop(), '*');
        }

        return stringBuilder.toString().replaceAll("\\*", "");
    }

    //Works but takes extra stack space and also messy in the end when handling string with only '('s
    public String minRemoveToMakeValidMessyAndMoreSpace (String s)
    {
        Stack<Character> outputStack = new Stack<>();
        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                outputStack.push(c);
            }
            else {
                if (c == '(') {
                    bracketStack.push(c);
                    outputStack.push(c);
                }
                else {
                    if (!bracketStack.isEmpty() && bracketStack.peek() == '(') {
                        bracketStack.pop();
                        outputStack.push(c);
                    }
                }
            }
        }

        boolean hasLeftOverBrackets = false;
        int size = bracketStack.size();

        if (!bracketStack.isEmpty()) {
            hasLeftOverBrackets = true;
        }

        String sb = "";
        while (!outputStack.isEmpty()) {
            char c = outputStack.pop();
            if (hasLeftOverBrackets && c == '(') {
                size--;
                if (size == 0) {
                    hasLeftOverBrackets = false;
                }
                continue;
            }
            sb = c + sb;
        }
        return sb;
    }
}
