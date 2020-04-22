package challenges;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int result = -1;

        if (nums[0] < nums[nums.length - 1]) {
            return binSrch(nums, target, 0, nums.length - 1);
        }

        //first get pivot -> log(n)
        int pivot = getPivot(nums);

        //get the target in the array -> log(n)

        if (target <= nums[nums.length - 1] && target >= nums[pivot]) {
            result = binSrch(nums, target, pivot, nums.length - 1);
        } else {
            result = binSrch(nums, target, 0, pivot - 1);
        }
        return result;
    }

    private static int binSrch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left)/ 2);
            int numAtMid = nums[mid];
            if (numAtMid == target) {
                return mid;
            } else if (target < numAtMid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int getPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int numAtMid = nums[mid];
            if (numAtMid > nums[mid + 1]) {
                return mid + 1;
            } else if (numAtMid < nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search(new int[]{3,1}, 1);
    }
}
