package challenges;

import javafx.util.Pair;

import java.util.*;

/**
 * Given a list of k sorted iterators. Implement MergingIterator to merge them.
 * <p>
 * class MergingIterator implements Iterator<Integer> {
 * public MergingIterator(List<Iterator<Integer>> iterators) {
 * }
 * <p>
 * public boolean hasNext() {
 * }
 * <p>
 * public Integer next() {
 * }
 * }
 * <p>
 * Example:
 * <p>
 * MergingIterator itr = new MergingIterator([[2, 5, 9], [], [4, 10]]);
 * itr.hasNext(); // true
 * itr.next(); // 2
 * itr.next(); // 4
 * itr.next(); // 5
 * itr.next(); // 9
 * itr.next(); // 10
 * itr.hasNext(); // false
 * itr.next(); // error
 */
public class MergeKSortedIterators implements Iterator<Integer> {

    PriorityQueue<Pair<Iterator<Integer>, Integer>> priorityQueue;

    public MergeKSortedIterators(List<Iterator<Integer>> iterators) {
        priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        initPriorityQueue(iterators, priorityQueue);
    }

    private void initPriorityQueue(List<Iterator<Integer>> iterators, PriorityQueue<Pair<Iterator<Integer>, Integer>> priorityQueue) {
        for (Iterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                Pair<Iterator<Integer>, Integer> pair = new Pair<>(iterator, iterator.next());
                priorityQueue.offer(pair);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return priorityQueue.size() != 0;
    }

    @Override
    public Integer next() {
        Pair<Iterator<Integer>, Integer> popped = priorityQueue.poll();
        if (popped != null && popped.getKey().hasNext()) {
            priorityQueue.offer(new Pair<>(popped.getKey(), popped.getKey().next()));
        }
        assert popped != null;
        return popped.getValue();
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2, 5, 9);
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = Arrays.asList(4, 10);

        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        Iterator<Integer> iterator3 = list3.iterator();

        MergeKSortedIterators itr = new MergeKSortedIterators(Arrays.asList(iterator1, iterator2, iterator3));
        System.out.println("hmmm");
    }
}
