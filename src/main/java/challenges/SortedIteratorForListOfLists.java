package challenges;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedIteratorForListOfLists implements Iterator<Integer>
{
    private PriorityQueue<Integer> pq;

    public SortedIteratorForListOfLists (List<List<Integer>> list)
    {
        pq = new PriorityQueue<>();
        for (List<Integer> l : list) {
            pq.addAll(l);
        }
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override public boolean hasNext ()
    {
        return !pq.isEmpty();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override public Integer next ()
    {
        if (hasNext()) {
            return pq.poll();
        }
        else {
            return null;
        }
    }
}
