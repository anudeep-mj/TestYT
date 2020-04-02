package challenges;

import java.util.HashMap;
import java.util.Map;

public class SumOfDigitsWithEqualSum {
    public int getDigitSum(Integer input) {
        input = Math.abs(input);
        int sum = 0;
        while(input > 0) {
            int remainder = input % 10;
            input = input / 10;
            sum = sum + remainder;
        }
        return sum;
    }

    public int getMaxSum(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (!map.containsKey(input[i])) {
                map.put(getDigitSum(input[i]), input[i]);
            } else {
                int ip = map.get(input[i]);
                max = Math.max(ip + input[i], max);
                if (input[i] > ip) {
                    map.put(getDigitSum(input[i]), input[i]);
                }
            }
        }
        return max;
    }
}
