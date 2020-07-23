package challenges;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) { return 1; }
        if (n == 1) { return x; }

        if (x == 1) { return 1; }
        if (x == -1) {
            if(n % 2 == 0) { return 1; }
            else { return -1; }
        }

        if (n == Integer.MIN_VALUE) { return 0; }

        if (n < 0) { return myPow(1/x, -n); }

        double result = myPow(x * x, n/2);
        if(n % 2 != 0) {
            result = result * x;
        }
        return result;
    }

    public double myPowBF(double x, int n) {
        if (n == 0) { return 1; }
        if (n == 1) { return x; }
        if (n < 0) { return myPowBF(1/x, -n); }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }
}
