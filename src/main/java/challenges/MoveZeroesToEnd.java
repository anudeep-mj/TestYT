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

    public void moveZeroes(int[] nums) {
        int numOfZeroes = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 0) {
                numOfZeroes++;
            } else {
                nums[i - numOfZeroes] = nums[i];
            }
        }

        for (int i = nums.length - numOfZeroes; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private void processNumIfNecessary(int[] nums, int i, int numOfZeroes) {
        nums[i - numOfZeroes] = nums[i];
    }

    static int[] exchangeIndexes(int[] arr, int i, int j) {
        arr[i] = arr[j];
        arr[j] = 0;
        return arr;
    }

    public static void main(String[] args) {

    }
}
