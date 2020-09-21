package challenges;
/**
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
 *
 * Your class will have the method, book(int start, int end).
 * Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
 *
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully
 * without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * Example 1:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation:
 * The first event can be booked.  The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not including 20.
 *
 * Note:
 *     The number of calls to MyCalendar.book per test case will be at most 1000.
 *     In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarI
{
    List<int[]> bfList;
    TreeMap<Integer, Integer> calendarMap;

    public MyCalendarI ()
    {
        bfList = new ArrayList<>();
        calendarMap = new TreeMap<>();
    }

    // one thing i should have thought was: since we need to add an interval to the list of intervals,
    // the first step is to search for the place where to add. That means we could maybe do binary search for that.
    // need to have a balanced tree to search on with key, value. TreeMap will work.
    public boolean book (int start, int end)
    {
        Integer prev = calendarMap.floorKey(start);
        Integer next = calendarMap.ceilingKey(start);

        if ((prev == null || calendarMap.get(prev) <= start) && (next == null || end <= next)) {
            calendarMap.put(start, end);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean bookBF (int start, int end)
    {
        for (int[] interval : bfList) {
            //if (iv[0] < end && start < iv[1]) return false;
            if (start >= interval[0] && end <= interval[1]) {
                return false;
            }
        }
        bfList.add(new int[] { start, end });
        return true;
    }
}
