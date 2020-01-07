package challenges;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicates {
    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        int result = 0;
        if (text == null) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int ct = map.get(c);
                ct = ct + 1;
                map.put(c, ct);
            }
        }
        for (Integer value : map.values()) {
            if (value > 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        duplicateCount("indivisibility");
    }
}
