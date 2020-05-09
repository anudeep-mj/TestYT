package challenges;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 * Example 1:
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Example 2:
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 */
public class CheckIfStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length < 3) {
            return true;
        }

        for (int i = 0, j = 1, k = 2; k < coordinates.length; i++, j++, k++) {
            if(!checkIfSlopeBetweenPoints(coordinates[i], coordinates[j], coordinates[2])) {
                return false;
            }
        }
        return true;
    }

    public double distanceBetweenTwoPoints(int[] point1, int[] point2) {
        int xDelta = point2[0] - point1[0];
        int yDelta = point2[1] - point1[1];
        return xDelta * xDelta + yDelta * yDelta;
    }

    public boolean checkIfSlopeBetweenPoints(int[] point1, int[] point2, int[] point3) {
        //(y3 - y2) / (x3 - x2) = (y2 - y1) / (x2 - x1)
        int temp1 = (point3[1] - point2[1]) * (point2[0] - point1[0]);
        int temp2 = (point2[1] - point1[1]) * (point3[0] - point2[0]);

        return temp1 == temp2;
    }

    public static void main(String[] args) {
        CheckIfStraightLine checkIfStraightLine = new CheckIfStraightLine();
        //checkIfStraightLine.checkStraightLine(new int[][]{{1,2}, {2,3}, {3,4}, {4,5}, {5,6}, {6,7}});
                checkIfStraightLine.checkStraightLine(new int[][]{{-3,-2}, {-1,-2}, {2,-2}, {-2,-2}, {0,-2}});
    }
}
