package challenges;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 *
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays.
 * For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).
 * Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 *
 *
 * Example 1:
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 *
 * Example 2:
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 *
 * Constraints:
 *     1 <= schedule.length , schedule[i].length <= 50
 *     0 <= schedule[i].start < schedule[i].end <= 10^8
 */
public class EmployeeFreeTime
{
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();

        if(schedule == null) {
            return allIntervals;
        }

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.start - b.start);

        for(List<Interval> list : schedule) {
            pq.addAll(list);
        }

        Interval prev = pq.poll();
        while(!pq.isEmpty()) {
            Interval interval = pq.poll();
            if (prev.end < interval.start) {
                allIntervals.add(new Interval(new int[]{prev.end, interval.start}));
                prev = interval;
            } else {
                prev.end = Math.max(prev.end, interval.end);
            }
        }

        return allIntervals;
    }

    public static void main(String[] args) {
        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(new int[]{1,2}));
        list1.add(new Interval(new int[]{5,6}));

        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(new int[]{1,3}));


        List<Interval> list3 = new ArrayList<>();
        list3.add(new Interval(new int[]{4,10}));

        List<List<Interval>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);

        employeeFreeTime(input);

    }

}
