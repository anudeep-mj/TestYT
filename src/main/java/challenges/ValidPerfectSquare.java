package challenges;

/**
 * Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        double left = 0;
        double right = num;

        while(left <= right) {
            //int mid = low + ((high - low) / 2);
            double mid = Math.floor(left + ((right - left) / 2));
            if(mid*mid == num) {
                return true;
            }

            double midSquare = mid * mid;
            if(midSquare > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        isPerfectSquare(16);
    }
}
