package challenges;

import java.util.HashMap;
import java.util.Map;

public class Beggars {
    public static int[] beggars(int[] values, int n) {
        // show me the code!
        int valueIdx = 0;
        int numValues = values.length;
        int[] result = new int[n];

        if (n == 0 || numValues == 0) {
            return result;
        }

        int beggarIdx = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i  = 0; i<n; i++) {
            map.put(i, 0);
        }

        while (valueIdx < numValues) {
            int val = values[valueIdx++];

            if (beggarIdx >= n) {
                beggarIdx = 0;
            }
            map.put(beggarIdx, map.get(beggarIdx) + val);
            beggarIdx++;
        }

        int idx = 0;
        for (Integer key : map.values()) {
            result[idx++] = key;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        beggars(test, 1);
        beggars(test, 2);
        beggars(test, 3);
        beggars(test, 6);
        beggars(test, 0);
    }
}
