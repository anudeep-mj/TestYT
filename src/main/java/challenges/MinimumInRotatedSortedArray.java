package challenges;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * [4,5,6,7,0,1,2]
 * [4,5,6,7,8,9,2]
 * [7,0,1,2,3,4,5]
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class MinimumInRotatedSortedArray
{
    public int findMin (int[] nums)
    {
        int left = 0;
        int right = nums.length - 1;

        //should have added this in the begoomgom
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            //didnt think of this..
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] < nums[left]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
