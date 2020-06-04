package challenges;
/**
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 * Example 1:
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 * Note:
 *     1 <= costs.length <= 100
 *     It is guaranteed that costs.length is even.
 *     1 <= costs[i][0], costs[i][1] <= 1000
 */

import java.util.ArrayList;
import java.util.Collections;

public class TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        ArrayList<diffObj> list = new ArrayList<>();

        int totalCost = 0;
        for(int[] cost : costs) {
            int diff  = cost[0] - cost[1];
            list.add(new diffObj(cost, diff));
        }

        Collections.sort(list, (a, b) -> a.difference - b.difference);

        for (int i = 0; i < list.size() / 2; i++) {
            totalCost += list.get(i).cost[0];
        }

        for (int i = list.size() - 1; i >= list.size() / 2; i--) {
            totalCost += list.get(i).cost[1];
        }

        return totalCost;
    }

    static class diffObj {
        int difference;
        int[] cost;

        //did mistake here by forgetting to put "this."
        diffObj(int[] cost, int diff) {
            this.difference = diff;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int[][] cost = new int[][]{
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };
        twoCitySchedCost(cost);
    }
}
