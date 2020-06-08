package challenges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A sequence of task given where each task identified by a unique id. There is cool down period to be observed before executing same task again. Find the execution time for the task sequence.
 *
 * Example:
 * Task sequence: 1 2 1 2
 * cool-down period: 3
 *
 * Execution time: 6 (o/p seq: 1 2 . . 1 2)
 */

/*
Idea is to have a taskQ and a coolDownMap which holds the current value of cooldown for a task.
If task cooldown is 0, we update cooldown or else we add the task back to queue. During every iteration, we reduce the cooldowns.
 */
public class TaskScheduler {

    static HashMap<Integer, Integer> coolDownMap;

    public static int scheduler(int[] tasks, int coolDown) {
        coolDownMap = new HashMap<>();
        Queue<Integer> taskQ = new LinkedList<>();
        for (int task : tasks) {
            coolDownMap.put(task, 0);
            taskQ.offer(task);
        }

        int executionTime = 0;

        while (!taskQ.isEmpty()) {
            int task = taskQ.poll();

            if (coolDownMap.get(task) == 0) {
                reduceCoolDownForAll();
                executionTime++;
            } else {
                while (coolDownMap.get(task) != 0) {
                    reduceCoolDownForAll();
                    executionTime++;
                }
            }
            coolDownMap.put(task, coolDown);
        }

        return executionTime;
    }

    private static void reduceCoolDownForAll() {
        coolDownMap.replaceAll((k,v) -> v > 0 ? v-1 : v);
    }

    public static void main(String[] args) {
        scheduler(new int[]{1,2,1,3,4}, 3);
    }
}
