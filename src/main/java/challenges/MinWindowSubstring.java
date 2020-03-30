package challenges;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public Integer minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int counter = t.length();
        int minWindowLength = Integer.MAX_VALUE;

        while (end < s.length()) {
            Character c = s.charAt(end++);

            //if character is in t
            if (tmap.containsKey(c)) {
                counter--;
            }

            tmap.put(c, tmap.getOrDefault(c, 0) - 1);

            while (counter == 0) {
                minWindowLength = Math.min(minWindowLength, end - start + 1);
                Character chatAtStart = s.charAt(start);
                tmap.put(chatAtStart, tmap.get(chatAtStart) + 1);
                if (tmap.get(chatAtStart) > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minWindowLength;
    }
}
