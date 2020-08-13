package challenges;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * Input: [1,3,5]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [2,2,2,0,1]
 * Output: 0
 */
public class MinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }


        while (left <= right) {
            int mid = left + ((right -  left) / 2);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                //this is a place where you might make mistakes..
                right = mid;
            } else {
                right--;
            }
        }

        //this one too...
        return nums[left];
    }

    public static void main(String[] args) {
        findMin(new int[]{3,3,3,3,1});
    }
}
