package challenges;
/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Example:
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */

import java.util.LinkedList;

public class MovingAverageFromDataStream
{
    LinkedList<Integer> linkedList;
    int listSize;
    int currSum;
    double result;

    /**
     * Initialize your data structure here.
     */
    public MovingAverageFromDataStream (int size)
    {
        linkedList = new LinkedList<>();
        listSize = size;
        currSum = 0;
        result = 0;
    }

    //another approach is to just use a queue. pop the element when size of q is over limit and subtract it from the currsum.
    public double next (int val)
    {
        if (linkedList.size() == listSize) {
            //decrement currsum and remove from list
            currSum = currSum - linkedList.get(0);
            linkedList.removeFirst();
        }

        //add new element to list and update currsum
        linkedList.addLast(val);
        currSum += val;

        result = (double) currSum / linkedList.size();

        return result;
    }
}
