package challenges;

import java.util.HashMap;
import java.util.Map;

public class StockList {
    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (String str : lstOf1stLetter) {
            map.put(str.charAt(0), 0);
        }

        for (String str : lstOfArt) {
            Character c = str.charAt(0);
            if (map.containsKey(c)) {
                String[] strings = str.split(" ");
                int value = map.get(c);
                map.put(c, value + Integer.valueOf(strings[1]));
            }
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            stringBuilder.append("(").append(key).append(" : ").append(value).append(")").append(" - ");
        }
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 3);
    }

    public static void main(String[] args) {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[] {"A"};

        stockSummary(art, cd);
    }
}
