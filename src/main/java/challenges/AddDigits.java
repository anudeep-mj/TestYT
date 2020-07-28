package challenges;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

    public int addDigitsBF(int input) {
        int temp = 0;
        while (input > 0) {
            temp = temp + (input % 10);
            input = input / 10;
            if (input == 0 && temp > 9) {
                input = temp;
                temp = 0;
            }
        }

        return temp;
    }
}
