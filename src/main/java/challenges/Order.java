package challenges;

import java.util.TreeMap;

public class Order {
    public static String order(String words) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        String[] strings = words.split(" ");
        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (Character.isDigit(c)) {
                    map.put(Integer.valueOf(c), string);
                }
            }
        }


        StringBuilder stringBuilder = new StringBuilder();

        for (String string : map.values()) {
            stringBuilder.append(string);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        order("is2 Thi1s T4est 3a");
    }
}
