package challenges;

import java.util.HashMap;
import java.util.Map;

public class GetShortestUniqueSubstring {
    static String getShortestUniqueSubstring(char[] arr, String str) {

        if (arr.length == 0 ||
                str.length() == 0 ||
                arr.length > str.length()) {
            return "";
        }

        String shortestString = "";


        Map<Character, Integer> arrMap = new HashMap<>();
        for (char c : arr) {
            arrMap.put(c, 0);
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int counter = 0;

        for (rightIdx = 0; rightIdx < str.length(); rightIdx++) {

            char rightIdxChar = str.charAt(rightIdx);
            if (!arrMap.containsKey(rightIdxChar)) {
                continue;
            }
            if (arrMap.get(rightIdxChar) == 0) {
                counter++;
            }

            arrMap.put(rightIdxChar, arrMap.get(rightIdxChar) + 1);


            while (counter == arrMap.size()) {
                int shortSize = shortestString.length();
                int substrSize = str.substring(leftIdx, rightIdx).length();
                if (substrSize < shortSize) {
                    shortestString = str.substring(leftIdx, rightIdx + 1);
                }

                if (arrMap.containsKey(str.charAt(leftIdx))) {
                    int leftIdxValDecremented = arrMap.get(str.charAt(leftIdx) - 1);
                    arrMap.put(str.charAt(leftIdx), leftIdxValDecremented);
                    if (leftIdxValDecremented == 0) {
                        counter--;
                    }
                }

                leftIdx++;
            }
        }

        return shortestString;
    }

    public static void main(String[] args) {

    }
}
