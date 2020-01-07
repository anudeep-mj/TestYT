package challenges;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] a) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : a) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                count = count + 1;
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 != 0) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
