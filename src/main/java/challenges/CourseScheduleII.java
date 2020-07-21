package challenges;
/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 * <p>
 * Example 2:
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * <p>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] prereqArray = new int[numCourses];

        for (int[] prereq : prerequisites) {
            prereqArray[prereq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (prereqArray[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;


        while (!q.isEmpty()) {
            int course = q.poll();
            result[idx++] = course;

            for (int[] prereq : prerequisites) {
                if (prereq[1] == course) {
                    prereqArray[prereq[0]]--;
                    if (prereqArray[prereq[0]] == 0) {
                        q.offer(prereq[0]);
                    }
                }
            }
        }

        if (idx == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        findOrder(2, new int[][]{
                {0, 1},
                {1, 0}
        });
    }
}
