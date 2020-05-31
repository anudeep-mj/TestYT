package challenges;

import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        if(K == 0) {
            return new int[0][2];
        }
        PriorityQueue<DistanceObject> pq = new PriorityQueue<>((a, b) -> b.distance-a.distance);


        for(int[] point : points) {
            if(pq.size() == K) {
                int distanceToOrigin = distanceToOrigin(point);
                DistanceObject d = pq.peek();
                if(d.distance > distanceToOrigin) {
                    pq.add(new DistanceObject(distanceToOrigin, point));
                    pq.poll();
                }
            } else {
                pq.offer(new DistanceObject(distanceToOrigin(point), point));
            }
        }

        int[][] result = new int[K][2];
        int idx = 0;
        while(!pq.isEmpty()) {
            int[] point = pq.poll().point;
            result[idx++] = point;
        }

        return result;
    }

    private static int distanceToOrigin(int[] point) {
        int a = point[0] * point[0];
        int b = point[1] * point[1];
        return a + b;
    }

    static class DistanceObject {
        int distance;
        int[] point;
        DistanceObject(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public static void main(String[] args) {
        int[][] ip = new int[][] {
                {3,3},
                {5,-1},
                {-2,4}
        };
        kClosest(ip, 2);
    }
}
