package challenges;

import java.util.HashMap;
import java.util.Map;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        if (str1.length() < 1) {
            return true;
        }
        char[] charsStr2 = str2.toCharArray();
        Map<Character, Integer> str2Map = new HashMap<Character, Integer>();
        for (char c : charsStr2) {
            if (str2Map.containsKey(c)) {
                int count = str2Map.get(c);
                str2Map.put(c, count + 1);
            } else {
                str2Map.put(c, 1);
            }
        }

        char[] charsStr1 = str1.toCharArray();
        for (char c : charsStr1) {
            if (str2Map.containsKey(c)) {
                int count = str2Map.get(c);
                count = count -1;
                if (count == 0) {
                    str2Map.remove(c);
                } else {
                    str2Map.put(c, count);
                }
            }
        }
        return str2Map.size() == 0;
    }

    public static void main(String[] args) {
        scramble("rkqodlw","world");
    }

}
