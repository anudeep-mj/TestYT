package challenges;
/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the
 * result of a sequence of push and pop operations on an initially empty stack.
 * <p>
 * Example 1:
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * Example 2:
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * <p>
 * Note:
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 */

import java.util.Stack;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int poppedIdx = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < pushed.length; i++) {
            int toPush = pushed[i];
            s.push(toPush);
            if (!s.isEmpty() && s.peek() == popped[poppedIdx]) {
                while (!s.isEmpty() && poppedIdx < popped.length && s.peek() == popped[poppedIdx]) {
                    s.pop();
                    poppedIdx++;
                }
            }
        }

        return s.isEmpty();
    }

    public static void main(String[] args) {
        validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
