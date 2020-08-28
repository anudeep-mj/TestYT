package challenges;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber
{
    //BF would be to just sort the numbers and get the interval which doesnt have the difference 1.
    //O(n) space
    public int missingNumber(int[] nums) {
        //one approach is to have boolean[] temp = new boolean[nums.length+1];
        //iterate over nums and set that idx as true in temp.
        //iterate over temp again and return the idx which is false.
        return -1;
    }

    public static int missingNumberCT(Integer[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != nums.length) {
                swap(nums, i, nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }


    public static int missingNumberBS(Integer[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + (right - left)/2);
            if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        missingNumberCT(new Integer[]{9,6,4,2,3,5,7,0,1});
    }
}
