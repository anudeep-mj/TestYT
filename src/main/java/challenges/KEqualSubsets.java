package challenges;

/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k
non-empty subsets whose sums are all equal.
 */
public class KEqualSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }

        if (k == 0 || sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        int startingIndex = 0;
        int targetSubsetSum = sum / k;
        int currentSubsetSum = 0;
        int subsetsLeftOver = k;

        return canPartition(startingIndex, visited, nums, targetSubsetSum, currentSubsetSum, subsetsLeftOver);
    }

    private boolean canPartition(int startingIndex, boolean[] visited, int[] nums, int targetSubsetSum, int currentSubsetSum, int subsetsLeftOver) {
        if (subsetsLeftOver == 1) {
            return true;
        }

        if (targetSubsetSum == currentSubsetSum) {
            return canPartition(0, visited, nums, targetSubsetSum, 0, subsetsLeftOver - 1);
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && currentSubsetSum + nums[i] <= targetSubsetSum) {
                visited[i] = true;
                if (canPartition(i + 1, visited, nums, targetSubsetSum, currentSubsetSum + nums[i], subsetsLeftOver)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

}
