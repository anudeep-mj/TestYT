package challenges;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 *
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII
{
    public static int rob (int[] nums)
    {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob0(nums), rob1(nums));
    }

    //eg: 10 houses. houses are numbered 0-9. If the user picks up 0th house, he can go upto 8. If not, he can start from 1 and go upto 9.
    //the max of the two is the answer.
    private static int rob0 (int[] nums)
    {
        int currentMax = 0;
        int prevMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //first store the currentMax so that it can become prevMax
            int temp = currentMax;
            currentMax = Math.max(prevMax + nums[i], currentMax);
            prevMax = temp;
        }

        return currentMax;
    }

    private static int rob1 (int[] nums)
    {
        int currentMax = 0;
        int prevMax = 0;
        for (int i = 1; i < nums.length; i++) {
            //first store the currentMax so that it can become prevMax
            int temp = currentMax;
            currentMax = Math.max(prevMax + nums[i], currentMax);
            prevMax = temp;
        }

        return currentMax;
    }

    public static void main (String[] args)
    {
        rob(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }
}
