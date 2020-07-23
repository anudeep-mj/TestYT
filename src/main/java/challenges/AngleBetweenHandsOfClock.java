package challenges;

/**
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 * <p>
 * Example 1:
 * Input: hour = 12, minutes = 30
 * Output: 165
 * <p>
 * Example 2:
 * Input: hour = 3, minutes = 30
 * Output: 75
 * <p>
 * Example 3:
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 * <p>
 * Example 4:
 * Input: hour = 4, minutes = 50
 * Output: 155
 * <p>
 * Example 5:
 * Input: hour = 12, minutes = 0
 * Output: 0
 */
public class AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {
        // each hour is 12/360 => 30 degrees
        // each min is 60/360 => 6 degrees
        // the hour hand is affected by mins hand. Say the mins hand is at 30, the hr hand will be in the
        // middle between two hours.. So that means, 30 mins = 30/60 = 1/2. say time was 3 hr, now it will be 3+1/2

        double h = (double) hour % 12;
        double mins = (double) minutes;
        h = (h + (mins / 60)) * 30;
        mins = mins * 6;

        double angle = Math.abs(h - mins);

        if (angle > 180.0) {
            return 360.0 - angle;
        } else {
            return angle;
        }
    }
}
