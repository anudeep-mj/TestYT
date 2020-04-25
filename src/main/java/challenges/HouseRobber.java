package challenges;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {

    /*
    A robber has 2 options: a) rob current house i; b) don't rob current house.
    If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
    If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
    So it boils down to calculating what is more profitable:

    robbery of current house + loot from houses before the previous
    loot from the previous house robbery and any loot captured before that

    rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
     */
    public static int rob2(int[] nums) {
        return robHelper2(nums, nums.length - 1);
    }

    //you can memoize it by storing the max value in an array to make it O(n)
    private static int robHelper2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(robHelper2(nums, i-1), robHelper2(nums, i-2) + nums[i]);
    }

    public int robRecursiveToIterative(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }

    //too long
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return robHelper(nums);
    }

    private static int robHelper(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int[] maxHelper = new int[nums.length];
        maxHelper[0] = nums[0];
        maxHelper[1] = nums[1];

        for (int leftPtr = 2; leftPtr < nums.length; leftPtr++) {
            int rightPtr = leftPtr - 2;
            int maxAtRight = 0;
            while (rightPtr >= 0) {
                maxAtRight = Math.max(maxAtRight, maxHelper[rightPtr] + nums[leftPtr]);
                rightPtr--;
            }
            maxHelper[leftPtr] = maxAtRight;
            max = Math.max(max, maxAtRight);
        }
        return max;
    }

    public static void main(String[] args) {
        //[9,2,3,7] -> 16
        rob(new int[]{9,2});
    }
}
