package challenges;
/**
 * You are given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where each letter represents a different task.
 * Tasks could be done without the original order of the array. Each task is done in one unit of time.
 * For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks
 * (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * You need to return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskSchedulerWithoutOrderingReq
{
    /**
     * Greedy approach
     * @param tasks list of tasks
     * @param n cool down period
     * @return least intervals needed to complete all tasks
     */
    public int leastInterval (char[] tasks, int n)
    {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(freqMap.values());

        int cycles = 0;

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            for (int l : list) {
                l = l - 1;
                if (l > 0) {
                    pq.add(l);
                }
            }

            if (pq.isEmpty()) {
                cycles += list.size();
            }
            else {
                cycles += n + 1;
            }
        }

        return cycles;
    }

    /**
     * Long approach uses multipl DS
     */
    HashMap<Character, Integer> coolmap;
    int resultTime = 0;

    public int leastIntervalFromMap (char[] tasks, int n)
    {
        coolmap = new HashMap<>();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        LinkedHashSet<Character> taskQ = new LinkedHashSet<>();

        for (char c : tasks) {
            coolmap.put(c, 0);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : freqMap.keySet()) {
            taskQ.add(c);
        }

        while (!freqMap.isEmpty()) {
            if (!taskQ.isEmpty()) {
                char task = taskQ.iterator().next();

                taskQ.remove(task);

                reduceCoolDown();

                freqMap.put(task, freqMap.get(task) - 1);
                if (freqMap.get(task) == 0) {
                    freqMap.remove(task);
                    coolmap.remove(task);
                }
                else {
                    resetCoolDown(task, n);
                }

                taskQ = updateQ(taskQ);
            }
            else {
                reduceCoolDown();
                taskQ = updateQ(taskQ);
            }

            resultTime++;
        }

        return resultTime;
    }

    private LinkedHashSet<Character> updateQ (LinkedHashSet<Character> taskSetQ)
    {
        for (Map.Entry<Character, Integer> entry : coolmap.entrySet()) {
            if (entry.getValue() == 0) {
                taskSetQ.add(entry.getKey());
            }
        }
        return taskSetQ;
    }

    private void reduceCoolDown ()
    {
        for (Map.Entry<Character, Integer> entry : coolmap.entrySet()) {
            if (entry.getValue() > 0) {
                coolmap.put(entry.getKey(), entry.getValue() - 1);
            }
        }
    }

    private void resetCoolDown (char task, int val)
    {
        coolmap.put(task, val);
    }

    public static void main (String[] args)
    {
        TaskSchedulerWithoutOrderingReq t = new TaskSchedulerWithoutOrderingReq();
        t.leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' },
            2);
    }
}
