package challenges;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                } else {
                    Character popped = stack.pop();
                    if (!isValidOpen(popped, c)) {
                        return false;
                    }
                }
            }
        }
        return stack.size() != 0;
    }

    public boolean isValidOpen(Character fromStack, Character input) {
        if (fromStack == '(' && input == ')') {
            return true;
        }
        else if (fromStack == '[' && input == ']') {
            return true;
        }
        else if (fromStack == '{' && input == '}') {
            return true;
        } else {
            return false;
        }
    }

}
