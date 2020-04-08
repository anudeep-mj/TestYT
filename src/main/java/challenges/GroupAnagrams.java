package challenges;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] sortedStr = string.toCharArray();
            Arrays.sort(sortedStr);

            if (map.containsKey(String.valueOf(sortedStr))) {
                ArrayList<String> list = map.get(String.valueOf(sortedStr));
                list.add(string);
                map.put(String.valueOf(sortedStr), list);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(string);
                map.put(String.valueOf(sortedStr), temp);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
