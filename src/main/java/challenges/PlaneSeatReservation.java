package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/discuss/interview-question/492652/
 */
public class PlaneSeatReservation {
    public int soln(int N, String S) {
        int count = 0;
        HashMap<Integer, HashSet<Character>> hashMap = new HashMap<>();
        String[] splitS = S.split("\\s+");
        for (String split : splitS) {
            char[] chars = split.toCharArray();
            int splitKey = (int) chars[0];
            if (hashMap.containsKey(splitKey)) {
                HashSet<Character> hashSet = hashMap.get(splitKey);
                hashSet.add(chars[1]);
                hashMap.put(splitKey, hashSet);
            } else {
                HashSet<Character> hashSet = new HashSet<>();
                hashSet.add(chars[1]);
                hashMap.put(splitKey, hashSet);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!hashMap.containsKey(i)) {
                count = count + 2;
            } else {
                HashSet<Character> occupiedSet = hashMap.get(i);
                if (!occupiedSet.contains('B') && !occupiedSet.contains('C') && !occupiedSet.contains('D') && !occupiedSet.contains('E')) {
                    count++;
                    occupiedSet.add('D');
                    occupiedSet.add('E');
                    hashMap.put(i, occupiedSet);
                } else if (!occupiedSet.contains('F') && !occupiedSet.contains('G') && !occupiedSet.contains('H') && !occupiedSet.contains('J')) {
                    count++;
                    occupiedSet.add('F');
                    occupiedSet.add('G');
                    hashMap.put(i, occupiedSet);
                } else if (!occupiedSet.contains('D') && !occupiedSet.contains('E') && !occupiedSet.contains('F') && !occupiedSet.contains('G')) {
                    count++;
                }
            }
        }
        return count;
    }
}
