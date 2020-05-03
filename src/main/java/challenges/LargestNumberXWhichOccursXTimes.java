package challenges;

import java.util.*;

/**
 * Given an array A consisting of N integers, return the biggest value X, which occurs X times in A.
 * eg: A=[3,8,2,3,3,2], op = 3.
 * N is in range of [1...100,000]. each element is in range of [1 ... 1,000,000,000]
 */
public class LargestNumberXWhichOccursXTimes {
    //from the assumption we can assume, the result element cannot be more than 100,000 since n can only have that much max.

    public int largestNumberX(int[] A) {
        HashSet<Integer> excluded = new HashSet<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 100000 && !excluded.contains(A[i])) {
                treeMap.put(A[i], treeMap.getOrDefault(A[i], 0) + 1);
                if (treeMap.get(A[i]) > A[i]) {
                    excluded.add(A[i]);
                    treeMap.remove(A[i]);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
