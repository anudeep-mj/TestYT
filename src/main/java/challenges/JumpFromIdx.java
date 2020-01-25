package challenges;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * at i = 3, jS = 0, length = 5. 3+0 < length - 1
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */

public class JumpFromIdx {
    public static boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        return canJumpRecursive(nums, 0);
    }

    private static boolean canJumpRecursive(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }

        int furthestJump = nums[i];

        for (int idx = i + 1; idx <= i + furthestJump; idx++) {
            if (canJumpRecursive(nums, idx)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        canJump(new int[]{3,8,1,0,4});
    }
}
