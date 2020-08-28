package challenges;
/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */

import java.util.*;

public class GroupAnagrams
{
    public static List<List<String>> groupAnagrams (String[] strs)
    {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] sortedStr = string.toCharArray();
            //user arr=int[26] to create a key to prevent sorting time complexity
            Arrays.sort(sortedStr);

            if (map.containsKey(String.valueOf(sortedStr))) {
                ArrayList<String> list = map.get(String.valueOf(sortedStr));
                list.add(string);
                map.put(String.valueOf(sortedStr), list);
            }
            else {
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

    public static void main (String[] args)
    {
        groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    }
}
