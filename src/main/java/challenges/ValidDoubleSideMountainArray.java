package challenges;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 *
 *     arr.length >= 3
 *     There exists some i with 0 < i < arr.length - 1 such that:
 *         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * The array should have a peak and slopes on either side of it.
 *
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 *
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 * Constraints:
 *     1 <= arr.length <= 104
 *     0 <= arr[i] <= 104
 */
public class ValidDoubleSideMountainArray {
    public static boolean validDoubleSideMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int idx = 0;
        boolean foundPeak = false;

        while (idx < arr.length - 1) {
            int curr = arr[idx];
            int next = arr[idx + 1];

            if (curr == next) {
                return false;
            }

            if (next < curr) {
                foundPeak = true;
                break;
            }

            idx++;
        }

        if (!foundPeak) {
            return false;
        }


        while (idx < arr.length - 1) {
            int curr = arr[idx];
            int next = arr[idx + 1];

            if (curr == next || next > curr) {
                return false;
            }

            idx++;
        }

        return true;
    }

    public static void main(String[] args) {
        validDoubleSideMountainArray(new int[]{1,2,1});
    }
}