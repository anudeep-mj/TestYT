package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences == 0) {
            return new int[0];
        }
        System.out.println();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        for (int i = 0; i<elements.length; i++) {
            int element = elements[i];
            if (freqMap.containsKey(element)) {
                int numOfOccurrence = freqMap.get(element);
                if (numOfOccurrence < maxOccurrences) {
                    freqMap.put(element, numOfOccurrence + 1);
                    resList.add(element);
                }
            } else {
                freqMap.put(element, 1);
                resList.add(element);
            }
        }

        return convertIntegers(resList);
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static void main(String[] args) {
        deleteNth( new int[] { 20, 37, 20, 21 }, 1 );
    }
}
