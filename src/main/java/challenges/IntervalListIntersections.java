package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 * Example 1:
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 * Note:
 *     0 <= A.length < 1000
 *     0 <= B.length < 1000
 *     0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class IntervalListIntersections {
    public static int[][] wrongXintervalIntersection(int[][] A, int[][] B) {
        List<int[]> resultList = new ArrayList<>();
        int[] cacheA = new int[A[A.length-1][1] + 1];
        int[] cacheB = new int[B[B.length-1][1] + 1];

        for(int[] arr : A) {
            for(int i = arr[0]; i <= arr[1]; i++) {
                cacheA[i] = 1;
            }
        }

        for(int[] arr : B) {
            for(int i = arr[0]; i <= arr[1]; i++) {
                cacheB[i] = 1;
            }
        }

        // printArr(cacheA);
        // printArr(cacheB);

        int i =0;
        int j = 0;
        boolean start = false;
        int[] R = new int[2];
        while(i < cacheA.length && i < cacheB.length) {
            if(cacheA[i] == 1 && cacheB[i] == 1) {
                if(!start) {
                    R[0] = i;
                    start = true;
                }
            } else {
                if(start) {
                    R[1] = i-1;
                    resultList.add(R);
                    R = new int[2];
                    start = false;
                }
            }
            i++;
        }

        System.out.println(resultList);

        return null;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0,2},
                {5,10},
                {13,23},
                {24,25}
        };
        int[][] B = new int[][]{
                {1,5},
                {8,12},
                {15,24},
                {25,26}
        };
        intervalIntersection(A, B);
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> resultList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length) {
            int maxStart = Math.max(A[i][0], B[j][0]);
            int minEnd = Math.min(A[i][1], B[j][1]);
            int[] temp = new int[2];
            if(maxStart <= minEnd) {
                temp[0] = maxStart;
                temp[1] = minEnd;
                resultList.add(temp);
            }

            if(A[i][1] > B[j][1]) {
                j++;
            } else {
                i++;
            }
        }

        int[][] result = new int[resultList.size()][2];

        int idx = 0;
        for(int[] temp : resultList) {
            result[idx] = resultList.get(idx);
            idx++;
        }

        return result;
    }
}
