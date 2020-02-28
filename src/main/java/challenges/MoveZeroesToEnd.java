package challenges;

/**
 * Given a static-sized array of integers arr, move all zeroes in the array to the end of the array. You should preserve the relative order of items in the array.
 *
 * We should implement a solution that is more efficient than a naive brute force.
 * Examples:
 * input:  arr = [1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0]
 * output: [1, 10, 2, 8, 3, 6, 4, 5, 7, 0, 0, 0, 0, 0]
 *
 * Constraints:
 *
 *     [time limit] 5000ms
 *     [input] array.integer arr
 *         0 ≤ arr.length ≤ 20
 *     [output] array.integer
 */
public class MoveZeroesToEnd {
    static int[] moveZerosToEnd(int[] arr) {
        int lastFirstZeroIndex = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                exchangeIndexes(arr, lastFirstZeroIndex, j);
                lastFirstZeroIndex++;
            }
        }
        return arr;
    }

    static int[] exchangeIndexes(int[] arr, int i, int j) {
        arr[i] = arr[j];
        arr[j] = 0;
        return arr;
    }

    public static void main(String[] args) {

    }
}
