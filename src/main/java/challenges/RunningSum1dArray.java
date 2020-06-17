package challenges;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * Example 2:
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 * Example 3:
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 */
public class RunningSum1dArray
{

    //in-place
    public int[] runningSum (int[] nums)
    {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = temp + nums[i];
            temp = nums[i];
        }

        return nums;
    }

    public int[] runningSum2 (int[] nums)
    {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i] = temp[i - 1] + nums[i];
        }
        return temp;
    }
}
