package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * Constraints:
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * Each element of candidate is unique.
 * 1 <= target <= 500
 *
 * https://www.youtube.com/watch?v=irFtGMLbf-s
 */
public class CombinationSum
{
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum (int[] candidates, int target)
    {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        Arrays.sort(candidates);

        List<Integer> combination = new ArrayList<>();
        getCombinationToTargetRecursively(candidates, combination, target, 0);

        return result;
    }

    private void getCombinationToTargetRecursively (
        int[] candidates,
        List<Integer> combination,
        int targetSum,
        int startIdx)
    {
        if (targetSum == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            if (candidates[i] > targetSum) {
                break;
            }
            combination.add(candidates[i]);
            getCombinationToTargetRecursively(candidates, combination, targetSum - candidates[i],
                i);
            combination.remove(combination.size() - 1);
        }
    }
}
