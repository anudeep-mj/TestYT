package challenges;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * <p>
 * Example 2:
 * <p>
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        //1 + 2 + 3 + ... + n = (n(n + 1)) / 2;

        long left = 0;
        long right = n;
        long mid = 0;

        while (left <= right) {
            mid = left + ((right - left) / 2);
            long totalCoinsInArrangementWithMidNumOfRows = (mid * (mid + 1)) / 2;

            if (totalCoinsInArrangementWithMidNumOfRows == n) {
                return (int) mid;
            }

            if (totalCoinsInArrangementWithMidNumOfRows > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) right;
    }

    public int arrangeCoinsBF(int n) {
        int leftOverCoins = n;
        int row = 1;
        //int count = 0;

        while (leftOverCoins / row >= 1) {
            leftOverCoins = leftOverCoins - row;
            row++;
        }

        return row - 1;
    }
}
