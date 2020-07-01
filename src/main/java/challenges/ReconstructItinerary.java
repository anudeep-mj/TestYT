package challenges;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 *     If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
 *     read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *     All airports are represented by three capital letters (IATA code).
 *     You may assume all tickets form at least one valid itinerary.
 *     One must use all the tickets once and only once.
 *
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            PriorityQueue<String> toQ = new PriorityQueue<>();
            if(map.containsKey(from)) {
                toQ = map.get(from);
            }

            toQ.offer(to);
            map.put(from, toQ);
        }

        List<String> result = new ArrayList<>();
        if(!map.containsKey("JFK")) {
            return result;
        }

        result.add("JFK");

        String dest = map.get("JFK").poll();
        result.add(dest);
        while(map.containsKey(dest)) {
            dest = map.get(dest).poll();
            result.add(dest);
        }

        return result;
    }

    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("B");
        pq.add("A");

        List<List<String>> input = new ArrayList<>();
        List<String> list1 = Arrays.asList("MUC","LHR");
        List<String> list2 = Arrays.asList("JFK","MUC");
        List<String> list3 = Arrays.asList("SFO","SJC");
        List<String> list4 = Arrays.asList("LHR","SFO");

        input.add(list1);
        input.add(list2);
        input.add(list3);
        input.add(list4);
        findItinerary(input);
    }
}
