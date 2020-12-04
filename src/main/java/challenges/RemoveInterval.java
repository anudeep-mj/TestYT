package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a sorted list of disjoint intervals, each interval intervals[i] = [a, b] represents the
 * set of real numbers x such that a <= x < b.
 *
 * We remove the intersections between any interval in intervals and the interval toBeRemoved.
 * Return a sorted list of intervals after all such removals.
 *
 * Example 1:
 * Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
 * Output: [[0,1],[6,7]]
 *
 * Example 2:
 * Input: intervals = [[0,5]], toBeRemoved = [2,3]
 * Output: [[0,2],[3,5]]
 *
 * Example 3:
 * Input: intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]
 * Output: [[-5,-4],[-3,-2],[4,5],[8,9]]
 */
public class RemoveInterval
{
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i< intervals.length; i++) {
            int[] curr = intervals[0];

            //if the toBeRemoved is in the left side or right side, add the result.
            if(curr[0] >= toBeRemoved[1] || curr[1] <= toBeRemoved[0]) {
                result.add(Arrays.asList(curr[0], curr[1]));
            } else {
                //if the current interval is engulfed inside the toberemoved boundaries, swallow it.
                if (curr[0] >= toBeRemoved[0] && curr[1] <= toBeRemoved[1]) {
                    continue;
                }

                //if the left side of the curr is in the intervals to remove. eg toBeRemoved = (5, 8) and curr = (6, 10)

            }

            return result;
        }

        return result;
    }
}
