package challenges;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange
{

    public int coinChange (int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange2 (int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != -1) {
                    //min = Math.min(dp[i], dp[i - coin] + 1);

                    int temp = dp[i - coin] + 1;
                    if (min < 0 || temp < min) {
                        min = temp;
                    }
                }
            }
            dp[i] = min;
        }

        return dp[amount];
    }

    /*
    This will not work... because say you have 4 coins, if the combo with 4 doesnt work, you throw away the 4th. 
    This will work if you somehow be able to get results such as ones which will work with 1,3,4 etc types... prob not a good idea.
     */
    int minCount = Integer.MAX_VALUE;

    public int coinChangeWrong (int[] coins, int amount)
    {
        Arrays.sort(coins);
        if (amount <= 0) {
            return -1;
        }

        int right = coins.length - 1;

        while (right >= 0) {
            coinsHelper(coins, amount, right);
            right--;
        }

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }
        return minCount;
    }

    void coinsHelper (int[] coins, int amount, int right)
    {
        int count = 0;

        while (right >= 0) {
            int rightMostCoin = coins[right];
            while (amount >= rightMostCoin) {
                amount -= rightMostCoin;
                count++;
            }
            right--;
        }

        if (amount == 0) {
            minCount = Math.min(minCount, count);
        }
    }

    public static void main (String[] args)
    {
        CoinChange coinChange = new CoinChange();

        coinChange.coinChange(new int[] { 2 }, 3);
    }
}
