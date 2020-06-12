package challenges;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition
{
    public int searchInsertIteratively (int[] nums, int target)
    {
        int len = nums.length;
        if (target > nums[len - 1]) {
            return len;
        }
        if (target < nums[0]) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    /*
    Note: Dont use recursive. Use iterative approach to have simplicity
     */
    public int searchInsert (int[] nums, int target)
    {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return insertHelper(nums, 0, nums.length - 1, target);
    }

    private int insertHelper (int[] nums, int left, int right, int target)
    {
        System.out.println("left:" + left + " right:" + right);

        if (left > right) {
            return left;
        }

        int mid = left + ((right - left) / 2);

        System.out.println("mid:" + mid);

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target) {
            left = mid + 1;
            return insertHelper(nums, left, right, target);
        }
        else {
            right = mid - 1;
            return insertHelper(nums, left, right, target);
        }
    }
}
