package challenges;

import java.util.List;

/**
 * You are given a data structure of employee information,
 * which includes the employee's unique id, his importance value and his direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3.
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]],
 * and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []].
 * Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 *
 * Example 1:
 *
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 */
public class EmployeeImportance {

    /*
    Idea is as follows:
    1. Create a map of employee id and his importance
    2. Create another map of employee id and value is a list of subordinates
    3. you know the starting point as id
    4. Do a BFS from id using a queue where you would iterate over the subordinate values while adding the importance of the nodes to result
    5. return result
     */
    public int getImportance(List<Employee> employees, int id) {
        return -1;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
