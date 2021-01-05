package challenges;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;

        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }

        int[] res = new int[]{-1, -1};

        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (target == nums[low]) {
            res[0] = low;
        }

        high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) / 2) + 1;    // +1 so that l = mid; doesn't result in an infinite loop when l + 1 == r.

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        if (target == nums[high]) {
            res[1] = high;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
