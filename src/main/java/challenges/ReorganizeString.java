package challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 */
public class ReorganizeString
{
    public static String reorganizeString (String input)
    {
        if (input == null) {
            return "";
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap =
            new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder stringBuilder = new StringBuilder();
        while (maxHeap.size() > 1) {
            char max = maxHeap.remove();
            char next = maxHeap.remove();
            stringBuilder.append(max);
            stringBuilder.append(next);
            freqMap.put(max, freqMap.get(max) - 1);
            freqMap.put(next, freqMap.get(next) - 1);
            if (freqMap.get(max) > 0) {
                maxHeap.offer(max);
            }
            if (freqMap.get(next) > 0) {
                maxHeap.offer(next);
            }
        }

        if (!maxHeap.isEmpty()) {
            char c = maxHeap.remove();
            if (freqMap.get(c) > 1) {
                return "";
            }
            else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    public static void main (String[] args)
    {
        reorganizeString("aaabbbcc");
    }
}
