package challenges;

import java.util.HashSet;

/**
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the
 * leftmost number of the array.
 *
 * Example 1:
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation:
 * The first missing number is 5.
 *
 * Example 2:
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 *
 * Example 3:
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation:
 * The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 */
public class MissingElementInSortedArray
{

    public int missingElement (int[] nums, int k)
    {
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1] - 1;
            if (diff >= k) {
                return nums[i - 1] + k;
            }
            k = k - diff;
        }

        return nums[nums.length - 1] + k;
    }

    public int missingElementInEff (int[] nums, int k)
    {

        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) {
            hs.add(i);
        }

        for (int i = nums[0]; i < nums[nums.length - 1]; i++) {
            if (!hs.contains(i)) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }

        return nums[nums.length - 1] + k;
    }
}
