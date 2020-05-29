package challenges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Constraints:
 *     The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *     You may assume that there are no duplicate edges in the input prerequisites.
 *     1 <= numCourses <= 10^5
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] prereqArr = new int[numCourses];
        for(int[] prereq : prerequisites) {
            prereqArr[prereq[0]]++;
        }

        // for(int i : prereqArr) {
        //     System.out.print(i);
        // }

        //load the course which dont
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) {
            if(prereqArr[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        //System.out.println(" q=" + q);

        while(!q.isEmpty()) {
            int course = q.poll();
            count++;
            for(int[] relation : prerequisites) {
                if(relation[1] == course) {
                    prereqArr[relation[0]]--;
                    if(prereqArr[relation[0]] == 0) {
                        q.offer(relation[0]);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {

    }
}
