package challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] < b[0]) {
                return -1;
            } else {
                if (a[0] == b[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static int[][] mergeIntervals(int[][] input) {
        Arrays.sort(input, new IntervalComparator());
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] interval : input) {
            if (result.isEmpty() || result.getLast()[1] > interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return (int[][]) result.toArray();
    }

    public static void main(String[] args) {

    }

}
