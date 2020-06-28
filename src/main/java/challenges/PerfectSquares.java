package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int temp = 1;
        while (temp * temp <= n) {
            list.add(temp * temp);
            temp++;
        }

        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        memo[1] = 1;

        for (int idx = 2; idx <= n; idx++) {
            /**
             * should have done this better. There is no need for the square list.
             * Rather than iterating over the list,
             * we could have had a while loop which could be like: i = 1, while(i * i <= idx) { i++ }
             */
            for (int i = 0; i < list.size(); i++) {
                int candidate = list.get(i);
                if (candidate <= idx) {
                    memo[idx] = Math.min(memo[idx], memo[idx - candidate]);
                }
            }
            memo[idx]++;
        }

        return memo[n];
    }

}
