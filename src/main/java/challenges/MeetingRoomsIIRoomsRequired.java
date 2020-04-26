package challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
 * [[0,30][5,10][15,20]] -> 2
 * [[7,10][2,4]] -> 1
 */
public class MeetingRoomsIIRoomsRequired {
    public static int minMeetingRooms(MeetingRooms.Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<MeetingRooms.Interval>() {
            @Override
            public int compare(MeetingRooms.Interval interval1, MeetingRooms.Interval interval2) {
                return interval1.start - interval2.start;
            }
        });

        int meetingRooms = 0;

        PriorityQueue<MeetingRooms.Interval> intervalPriorityQueue = new PriorityQueue<>(new Comparator<MeetingRooms.Interval>() {
            @Override
            public int compare(MeetingRooms.Interval interval1, MeetingRooms.Interval interval2) {
                return interval1.end - interval2.end;
            }
        });
        intervalPriorityQueue.add(intervals[0]);
        for (MeetingRooms.Interval interval : intervals) {

            MeetingRooms.Interval meetingEndingEarliest = intervalPriorityQueue.poll();
            if (interval.start >= meetingEndingEarliest.end) {
                meetingEndingEarliest.end = interval.end;
            } else {
                intervalPriorityQueue.add(interval);
                meetingRooms++;
            }

            intervalPriorityQueue.add(meetingEndingEarliest);
        }

        return meetingRooms;
    }
}
