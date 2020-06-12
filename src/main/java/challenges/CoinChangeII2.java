package challenges;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of
 * combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
/*
https://www.youtube.com/watch?v=jaNZ83Q3QGc
 think one thing you didn't explain is that why the outer loop is the coins, not the amount. The reason behind that is that as you mentioned,
 the problem is to find the total number of combinations, not the permutations.
 If the outer loop is the amount, then the same combination will be counted multiple times because they can come in in different orders.
 By letting the coins to be the outer loops, one assures that for any valid combination, the order of each coin will always be the same as their order in coins, so there can be no duplicates.
 */
public class CoinChangeII2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i < dp.length; i++) {
                if (i >= coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        return dp[amount];
    }
}