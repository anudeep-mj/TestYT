package challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersOnKRemovals
{
    public int findLeastNumOfUniqueInts (int[] arr, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        //count have replaced this with pq.addAll(map.keySet())
        for (int key : map.keySet()) {
            pq.offer(key);
        }

        while (k != 0) {
            int popped = pq.poll();
            while (map.containsKey(popped) && k != 0) {
                map.put(popped, map.get(popped) - 1);
                k--;
                if (map.get(popped) == 0) {
                    map.remove(popped);
                }
            }
        }

        return map.size();
    }
}
