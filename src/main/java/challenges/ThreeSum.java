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
import java.util.*;

public class ThreeSum {

    HashSet<List<Integer>> result;

    public List<List<Integer>> threeSumBF(int[] nums) {
        Arrays.sort(nums);
        result = new HashSet<>();
        int numsSz = nums.length;
        for(int i = 0; i < nums.length; i++) {
            get2Sum(nums[i], 0 - nums[i], Arrays.copyOfRange(nums, i+1, numsSz));
        }
        return new ArrayList<>(result);
    }

    private void get2Sum(int first, int sumToEqual, int[] subNums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int idx = 0; idx < subNums.length; idx++) {
            int num = subNums[idx];
            if(map.containsKey(sumToEqual - num)) {
                List<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(sumToEqual - num);
                list.add(num);
                result.add(list);
            } else {
                map.put(num, idx);
            }
        }
    }

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
