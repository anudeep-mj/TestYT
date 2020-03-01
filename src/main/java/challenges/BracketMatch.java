package challenges;
/**
 * A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa.
 * For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t.
 * For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.
 *
 * Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input
 * and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.
 *
 * Explain the correctness of your code, and analyze its time and space complexities.
 *
 * input:  text = “())(”
 * output: 2
 */

import java.util.Stack;

public class BracketMatch {
    static int bracketMatch(String text) {
        Stack<Character> charStack = new Stack<>();
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(') {
                charStack.push(c);
            } else {
                if (!charStack.isEmpty()) {
                    char poppedChar = charStack.pop();
                    if (!(poppedChar == '(')) {
                        count++;
                    }
                } else {
                    count++;
                }
            }
        }

        System.out.println("charStack.size():" + charStack.size());
        //increment the leftover characters in the stack to count
        count = count + charStack.size();
        System.out.println("count -> " + count);
        return count;
    }

    public static void main(String[] args) {
        String str = "())(";
        bracketMatch(str);

    }
}
