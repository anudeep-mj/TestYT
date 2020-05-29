package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 * Example 1:
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 *
 * Example 2:
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Example 3:
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 * Note:
 *     1 <= N <= 2000
 *     0 <= dislikes.length <= 10000
 *     1 <= dislikes[i][j] <= N
 *     dislikes[i][0] < dislikes[i][1]
 *     There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class PossibleBipartition {
    //uses dfs. basically:
    //first: you have a map which has the target and its relationships
    //second you create a map of nodes and its groups. the group can be 0 or 1.
    /*
    idea: basically now you iterate over the dislikes and get the first person and put him in a group. Once you do that, get all his dislikes from the previous map and dfs on them recursively to put them in the other group. Now say one of the disliked person is already in the map in group 0. Now if the first person was already in group 0 and if the disliked person is also in group 0, that means there is a collision since we cant put him in both group 0 and group 1. So thats the breaking case.
    */
    static Map<Integer, Integer> keyToGroupMap;
    static Map<Integer, List<Integer>> relationMap;

    public static boolean possibleBipartition(int N, int[][] dislikes) {

        relationMap = getRelationMap(dislikes, N);
        keyToGroupMap = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            //done mistake here with understanding that once you add a node to a group, you dont need to check again
            if(!keyToGroupMap.containsKey(i) && !dfs(i, 0)) {
                return false;
            }
        }
        return true;
    }


    private static boolean dfs(int person, int group) {
        if(keyToGroupMap.containsKey(person)) {
            return group == keyToGroupMap.get(person);
        }

        keyToGroupMap.put(person, group);

        List<Integer> dislikes = relationMap.get(person);
        for (int i : dislikes) {
            if(!dfs(i, group ^ 1)) {
                return false;
            }
        }
        return true;
    }


    private static Map<Integer, List<Integer>> getRelationMap(int[][] dislikes, int N) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] rel : dislikes) {
            //1st relation
            List<Integer> list = map.get(rel[0]);
            list.add(rel[1]);
            map.put(rel[0], list);

            //dont forget to add this
            //2nd relation
            list = map.get(rel[1]);
            list.add(rel[0]);
            map.put(rel[1], list);
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] dislikes = new int[][]{
            {1,2},
            {1,3},
            {2,4}
        };
        possibleBipartition(4, dislikes);
    }
}
