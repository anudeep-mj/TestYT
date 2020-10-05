package challenges;

import java.util.*;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1.
 * Also it's guaranteed that the subordination relationships have a tree structure.
 * <p>
 * The head of the company wants to inform all the employees of the company of an urgent piece of news. He will inform his direct subordinates and
 * they will inform their subordinates and so on until all employees know about the urgent news.
 * <p>
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).
 * Return the number of minutes needed to inform all the employees about the urgent news.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
 * Output: 0
 * Explanation: The head of the company is the only employee in the company.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * Output: 1
 * Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
 * The tree structure of the employees in the company is shown.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 7, headID = 6, manager = [1,2,3,4,5,6,-1], informTime = [0,6,5,4,3,2,1]
 * Output: 21
 * Explanation: The head has id = 6. He will inform employee with id = 5 in 1 minute.
 * The employee with id = 5 will inform the employee with id = 4 in 2 minutes.
 * The employee with id = 4 will inform the employee with id = 3 in 3 minutes.
 * The employee with id = 3 will inform the employee with id = 2 in 4 minutes.
 * The employee with id = 2 will inform the employee with id = 1 in 5 minutes.
 * The employee with id = 1 will inform the employee with id = 0 in 6 minutes.
 * Needed time = 1 + 2 + 3 + 4 + 5 + 6 = 21.
 * <p>
 * Example 4:
 * <p>
 * Input: n = 15, headID = 0, manager = [-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6], informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
 * Output: 3
 * Explanation: The first minute the head will inform employees 1 and 2.
 * The second minute they will inform employees 3, 4, 5 and 6.
 * The third minute they will inform the rest of employees.
 * <p>
 * Example 5:
 * <p>
 * Input: n = 4, headID = 2, manager = [3,3,-1,2], informTime = [0,0,162,914]
 * Output: 1076
 * <p>
 * Constraints:
 * 1 <= n <= 10^5
 * 0 <= headID < n
 * manager.length == n
 * 0 <= manager[i] < n
 * manager[headID] == -1
 * informTime.length == n
 * 0 <= informTime[i] <= 1000
 * informTime[i] == 0 if employee i has no subordinates.
 * It is guaranteed that all the employees can be informed.
 */
public class TimeNeededToInformAllEmployees
{

    public static int numOfMinutes2 (int n, int headID, int[] manager, int[] informTime)
    {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (manager[i] != -1)
                graph[manager[i]].add(i);
        Queue<int[]> q = new LinkedList<>(); // Since it's a tree, we don't need `visited` array
        q.offer(new int[] { headID, 0 });
        int ans = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int u = top[0], w = top[1];
            ans = Math.max(w, ans);
            for (int v : graph[u])
                q.offer(new int[] { v, w + informTime[u] });
        }
        return ans;
    }

    public static int numOfMinutes (int n, int headID, int[] manager, int[] informTime)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(manager[i])) {
                list = map.get(manager[i]);
            }

            list.add(i);
            map.put(manager[i], list);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { headID, 0 });

        int maxAtLevel = 0;
        while (!q.isEmpty()) {
            int[] polled = q.poll();

            int managerAtLevel = polled[0];
            int cost = polled[1];

            maxAtLevel = Math.max(maxAtLevel, cost);

            List<Integer> employeesUnder = map.get(managerAtLevel);
            if (employeesUnder != null) {
                for (int i : employeesUnder) {
                    // core logic below..
                    q.offer(new int[] { i, cost + informTime[managerAtLevel] });
                }
            }
        }
        return maxAtLevel;
    }

    /*
    fails because we didnt consider the following case:
                                  ---> 1(213) -> 7(0)
                                /
    4(686)->10(337)->3(253)->9(309)->6(975) -> 2(0)
                                \
                                  ---> 8(261) -> 5(170) -> 0(0)

    wrong: 686+337+253+309+975+170 = 2730
    correct: 686+337+253+309+975 = 2560

     975 > (261 + 170), 8(261) -> 5(170), so no need to add 170.
    */
    public static int numOfMinutesWrongApproach (int n, int headID, int[] manager, int[] informTime)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(manager[i])) {
                list = map.get(manager[i]);
            }

            list.add(i);
            map.put(manager[i], list);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(headID);

        int result = 0;

        while (!q.isEmpty()) {
            int qsize = q.size();

            int tempMax = 0;
            for (int i = 0; i < qsize; i++) {
                int popped = q.poll();
                tempMax = Math.max(tempMax, informTime[popped]);

                List<Integer> employeesUnder = map.get(popped);
                System.out.println("popped:" + popped);
                if (employeesUnder != null) {
                    for (Integer e : employeesUnder) {
                        q.offer(e);
                    }
                }
            }

            result = result + tempMax;
        }

        return result;
    }

    public static void main (String[] args)
    {
        numOfMinutes(11, 4, new int[] { 5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4 },
            new int[] { 0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337 });
    }
}










