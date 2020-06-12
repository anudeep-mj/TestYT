package challenges;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int zidx = 0;
        int tidx = nums.length-1;

        int current = 0;

        while (current <= tidx) {
            if (nums[current] == 0) {
                swap(nums, current, zidx);
                zidx++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, tidx);
                tidx--;
            } else {
                current++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
