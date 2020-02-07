package challenges;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * Output: 2
 */
public class CountGraphComponents {
    public int countComponents(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List> nodeMap = new HashMap<>();
        int j = 0;
        while(j < n) {
            nodeMap.put(j, new ArrayList<>());
            j++;
        }
        for(int[] edge : edges) {
            List<Integer> tempList = nodeMap.get(edge[0]);
            tempList.add(edge[1]);
            nodeMap.put(edge[0], tempList);

            tempList = nodeMap.get(edge[1]);
            tempList.add(edge[0]);
            nodeMap.put(edge[1], tempList);
        }

        int count = 0, i = 0;
        while (i <= n)
        {
            List<Integer> vals = nodeMap.get(i);
            for(Integer key : vals) {
                if(!visited.contains(key)) {
                    visited.add(key);
                    dfsRecursive(visited, key, nodeMap);
                    count++;
                }
            }
            i++;
        }

        return count;
    }

    public void dfsRecursive(Set<Integer> visited, int key, Map<Integer, List> nodeMap) {
        List<Integer> nodes = nodeMap.get(key);
        for(Integer nodeval : nodes) {
            if(!visited.contains(nodeval)) {
                visited.add(nodeval);
                dfsRecursive(visited, nodeval, nodeMap);
            }
        }
    }

}
