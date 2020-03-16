package challenges;
/**
 * https://leetcode.com/problems/zigzag-iterator/
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagIterator {
    Queue<Iterator<Integer>> iteratorQueue = new LinkedList<>();

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()) {
            iteratorQueue.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            iteratorQueue.add(v2.iterator());
        }
    }

    public int next() {
        if (!iteratorQueue.isEmpty()) {
            Iterator<Integer> iterator = iteratorQueue.poll();
            int result = iterator.next();
            if (iterator.hasNext()) {
                iteratorQueue.offer(iterator);
            }
            return result;
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        return iteratorQueue.isEmpty();
    }
}
