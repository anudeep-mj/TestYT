package challenges;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,0,0,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public static boolean canJumpBacktrack(int[] nums) {
        return canJumpBacktrackHelper(nums, 0);
    }

    private static boolean canJumpBacktrackHelper(int[] nums, int position) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = nums[position] + position;
        furthestJump = Math.min(furthestJump, nums.length - 1); //to prevent overflow

        for (int i = position + 1; i <= furthestJump; i++) {
            if (canJumpBacktrackHelper(nums, i)) {
                return true;
            }
        }

        return false;
    }


    public static boolean canJumpBackwardsSoln(int[] nums) {
        int goodIndex = nums.length - 1;
        for (int i = nums.length - 1; i >=0; i--) {
            if(nums[i] + i >= goodIndex) {
                goodIndex = i;
            }
        }
        return goodIndex == 0;
    }

    public static void main(String[] args) {

    }
}
