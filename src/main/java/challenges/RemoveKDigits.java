package challenges;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if(k == num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        int index = 0;
        while (index < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(index));
            index++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        stringBuilder.reverse();

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        removeKdigits("14345", 2);
    }
}
