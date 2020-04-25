package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalResult = new ArrayList<>();

        for (int[] interval : intervals) {
            //if the new interval's start is greater than the current interval end, add current interval to result
            if (newInterval == null || newInterval[0] > interval[1]) {
                intervalResult.add(interval);
            }
            //if the new interval's end is lesser than current interval start
            else if (newInterval[1] < interval[0]) {
                intervalResult.add(newInterval);
                intervalResult.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (newInterval != null) {
            intervalResult.add(newInterval);
        }
        int[][] result = new int[intervals.length+1][intervals.length+1];
        int idx = 0;
        for (int[] i : intervalResult) {
            result[idx++] = i;
        }
        return result;
    }
}


