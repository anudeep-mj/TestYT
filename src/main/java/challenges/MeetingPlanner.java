package challenges;

/**
 * Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur,
 * returns the earliest time slot that works for both of them and is of duration dur.
 * If there is no common time slot that satisfies the duration requirement, return an empty array.
 */
public class MeetingPlanner {
    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int xA = 0;
        int xB = 0;
        while(xA < slotsA.length && xB < slotsB.length){
            int start = Math.max(slotsA[xA][0], slotsB[xB][0]);
            int end = Math.min(slotsA[xA][1],slotsB[xB][1]);
            if(start + dur <= end) {
                return new int[]{start, end};
            }
            if(slotsA[xA][1] < slotsB[xB][1]) {
                xA++;
            } else {
                xB++;
            }
        }
        return new int[0];
    }
}
