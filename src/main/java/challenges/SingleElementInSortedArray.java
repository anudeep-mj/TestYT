package challenges;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 */
public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length -1;

        while(left < right) {
            int mid = left + ((right - left)/2);

            if(nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]) {
                return nums[mid];
            }

            if(mid %2 == 1) {
                mid--;
            }

            if(nums[mid] != nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
    }
}
