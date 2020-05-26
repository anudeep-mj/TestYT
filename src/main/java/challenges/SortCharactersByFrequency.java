package challenges;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        /*
        This priority queue was not implemented right.. for one thing, we could have just added to queue based on map value
        PriorityQueue<Character> pq = new PriorityQueue(new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                if (map.get(a) > map.get(b)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        **(OR)**
        PriorityQueue<Character> pq = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        and then
        pq.addAll(map.keySet());
         */

        PriorityQueue<FreqObj> pq = new PriorityQueue<>(new Comparator<FreqObj>() {
            @Override
            public int compare(FreqObj a, FreqObj b) {
                if(a.freq > b.freq) {
                    return 1;
                }
                return -1;
            }
        });

        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Character, Integer> pair = (Map.Entry)it.next();
            pq.offer(new FreqObj(pair.getKey(), pair.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            FreqObj fo = pq.poll();
            for(int i = 0; i < fo.freq; i++) {
                sb.append(fo.c);
            }
        }
        return sb.toString();
    }

    private class FreqObj {
        char c;
        int freq;
        FreqObj(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
