package challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
 * [[0,30][5,10][15,20]] -> 2
 * [[7,10][2,4]] -> 1
 */
public class MeetingRoomsIIRoomsRequired {

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        //sort on starting times.
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);


        //have a queue which has the fastest meeting finishing at the top.
        PriorityQueue<int[]> roomQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        //add first started meeting to the queue
        roomQ.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] meeting = intervals[i];

            //since the queue has meetings based on ending first, it will poll out the first ending meeting
            int[] meetingEndingEarliest = roomQ.poll();

            if(meeting[0] >= meetingEndingEarliest[1]) {
                //this means, the previous meeting has ended. so basically you just extend that meeting.
                meetingEndingEarliest[1] = meeting[1];
            } else {
                roomQ.offer(meeting);
            }

            roomQ.offer(meetingEndingEarliest);
        }

        return roomQ.size();
    }

    ////
    public static int minMeetingRooms(MeetingRooms.Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        //could have done Arrays.sort(intervals, (interval1, interval2) -> interval1.start - interval2.start);
        Arrays.sort(intervals, new Comparator<MeetingRooms.Interval>() {
            @Override
            public int compare(MeetingRooms.Interval interval1, MeetingRooms.Interval interval2) {
                return interval1.start - interval2.start;
            }
        });

        int meetingRooms = 0;

        //could have just used something like: PriorityQueue<MeetingRooms.Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        PriorityQueue<MeetingRooms.Interval> intervalPriorityQueue = new PriorityQueue<>(new Comparator<MeetingRooms.Interval>() {
            @Override
            public int compare(MeetingRooms.Interval interval1, MeetingRooms.Interval interval2) {
                return interval1.end - interval2.end;
            }
        });
        intervalPriorityQueue.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            MeetingRooms.Interval interval = intervals[i];

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

    public static void main(String[] args) {

        minMeetingRooms(new int[][] {
            {0, 30}, {5, 10}, {15, 20}
        });
        //[[1,5],[8,9],[8,9]]
//        MeetingRooms.Interval[] intervals = new MeetingRooms.Interval[] {
//            new MeetingRooms.Interval(1, 5), new MeetingRooms.Interval(8, 9), new MeetingRooms.Interval(8, 9)
//        };

        //minMeetingRooms(intervals);


    }
}
