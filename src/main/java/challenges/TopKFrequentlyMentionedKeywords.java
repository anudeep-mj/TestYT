package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
 *
 * The comparison of strings is case-insensitive.
 * Multiple occurances of a keyword in a review should be considred as a single mention.
 * If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 *
 * Example 1:
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = [
 *   "Anacell provides the best services in the city",
 *   "betacellular has awesome services",
 *   "Best services provided by anacell, everyone should use anacell",
 * ]
 *
 * Output:
 * ["anacell", "betacellular"]
 *
 * Explanation:
 * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 *
 * Example 2:
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
 * reviews = [
 *   "I love anacell Best services; Best services provided by anacell",
 *   "betacellular has great services",
 *   "deltacellular provides much better services than betacellular",
 *   "cetracular is worse than anacell",
 *   "Betacellular is better than deltacellular.",
 * ]
 *
 * Output:
 * ["betacellular", "anacell"]
 *
 * Explanation:
 * "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller
 */
public class TopKFrequentlyMentionedKeywords
{
    public static List<String> solve (List<String> reviews, List<String> keywords, int k)
    {
        List<String> result = new ArrayList<>();

        Map<String, Integer> freqMap = new HashMap<>();
        for (String review : reviews) {
            String[] strings = review.split("\\s+");
            for (String keyword : strings) {
                freqMap.put(keyword, freqMap.getOrDefault(keyword, 0) + 1);
            }
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) == freqMap.get(b) ?
                a.compareTo(b) :
                freqMap.get(b) - freqMap.get(a));
        priorityQueue.addAll(keywords);

        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll());
        }

        return result;
    }

    public static void main (String[] args)
    {
        solve(Arrays.asList("abc", "cab", "bcd", "bcd"), new ArrayList<>(), 1);
    }
}
