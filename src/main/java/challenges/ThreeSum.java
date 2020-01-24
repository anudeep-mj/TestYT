package challenges;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Given array nums = [-1, 0, 1, 2, -1, -4], A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int sum = -nums[i];
                int low = i+1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low + 1] == nums[low]) {
                            low++;
                        }
                        while (low < high && nums[high - 1] == nums[high]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(test);
    }
}
