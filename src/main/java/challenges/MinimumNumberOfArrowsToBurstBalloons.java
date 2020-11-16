package challenges;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons
{
    public static int findMinArrowShots(int[][] points) {
        int count = 1;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int endPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (Long.valueOf(points[i][0]) <= Long.valueOf(endPos)) {
                continue;
            }
            endPos = points[i][1];
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        findMinArrowShots(new int[][]{
            //{10, 16}, {2, 8}, {1, 6}, {7, 12}
            {-2147483646, -2147483645}, {2147483646, 2147483647}
        });
    }
}
