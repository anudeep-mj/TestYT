package challenges;

public class TargetSum {

    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {

        helper(nums, S, 0);

        return count;
    }

    public void helper(int[] nums, int S, int idx) {
        if(idx == nums.length) {
            if(S == 0) {
                count++;
            }
            return;
        }
        int num = nums[idx];

        int num1 = num * 1;
        int num2 = num * -1;

        helper(nums, S + num1, idx+1);
        helper(nums, S + num2, idx+1);
    }
}
