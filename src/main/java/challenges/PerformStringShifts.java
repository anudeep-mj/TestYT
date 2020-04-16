package challenges;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *     direction can be 0 (for left shift) or 1 (for right shift).
 *     amount is the amount by which string s is to be shifted.
 *     A left shift by 1 means remove the first character of s and append it to the end.
 *     Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 * Example 1:
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 */
public class PerformStringShifts {
    public static String stringShift(String s, int[][] shifts) {
        for (int[] shift : shifts) {
            int direction = shift[0];
            int numOfShifts = shift[1];
            s = shiftAround(s, numOfShifts, direction);
        }
        return s;
    }

    private static String shiftAround(String s, int numOfShifts, int direction) {
        int timesToMultipleS = numOfShifts / s.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        for (int i = 0; i < timesToMultipleS + 1; i++) {
            stringBuilder.append(s);
        }
        if (direction == 0) {
            return stringBuilder.substring(numOfShifts, s.length() + numOfShifts);
        } else {
            return stringBuilder.substring(stringBuilder.length() - s.length() - numOfShifts, stringBuilder.length() - numOfShifts);
        }
    }

    public static void main(String[] args) {
        stringShift("abcdefg", new int[][]{{1,1}, {1,1}, {0, 2}, {1, 3}});
    }
}
