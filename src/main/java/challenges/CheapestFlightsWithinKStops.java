package challenges;

import java.util.*;

public class CheapestFlightsWithinKStops {
    Map<Integer, List<DestObj>> flightsMap;
    int minResult = Integer.MAX_VALUE;

    //smart usage of q
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(n <= 0) {
            return - 1;
        }

        flightsMap = new HashMap<>();

        //or you can just do getordefault later on
        for(int i = 0 ; i < n; i++) {
            flightsMap.put(i, new ArrayList<>());
        }

        for(int[] flight : flights) {
            List<DestObj> list = flightsMap.get(flight[0]);
            list.add(new DestObj(flight[1], flight[2]));
            flightsMap.put(flight[0], list);
        }


        PriorityQueue<int[]> mappingQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        mappingQ.offer(new int[]{0, src, -1});

        while(!mappingQ.isEmpty()) {
            int[] popped = mappingQ.poll();

            int cost = popped[0];
            int city = popped[1];
            int tempK = popped[2];

            if(city == dst) {
                return cost;
            }

            List<DestObj> destinations = flightsMap.get(city);
            for(DestObj dobj : destinations) {
                if(tempK+1 <= K) {
                    mappingQ.offer(new int[] {cost + dobj.cost, dobj.val, tempK + 1});
                }
            }
        }

        return -1;
    }

    //inefficient
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        if(n <= 0) {
            return - 1;
        }

        //forgot to initialize
        flightsMap = new HashMap<>();

        //or you can just do getordefault later on
        for(int i = 0 ; i < n; i++) {
            flightsMap.put(i, new ArrayList<>());
        }

        for(int[] flight : flights) {
            List<DestObj> list = flightsMap.get(flight[0]);
            list.add(new DestObj(flight[1], flight[2]));
            flightsMap.put(flight[0], list);
        }

        calculateMinCost(flightsMap, src, dst, K);

        if(minResult != Integer.MAX_VALUE) {
            return minResult;
        }
        return -1;
    }


    private void calculateMinCost(Map<Integer, List<DestObj>> flightsMap,
                                  int src,
                                  int dst,
                                  int k) {
        if(!flightsMap.containsKey(src)) {
            return;
        }

        Stack<Integer> flightStack = new Stack<>();
        Stack<Integer> costStack = new Stack<>();
        Stack<Integer> kStack = new Stack<>();

        //List<Integer> costs = new ArrayList<>();

        flightStack.push(src);
        costStack.push(0);
        kStack.push(-1);

        while(!flightStack.isEmpty()) {

            int curr = flightStack.pop();
            int tempCost = costStack.pop();
            int tempK = kStack.pop();

            if(curr == dst && tempK <= k) {
                //costs.add(tempCost);
                minResult = Math.min(tempCost, minResult);
            }

            List<DestObj> list = flightsMap.get(curr);

            for(DestObj destObj : list) {
                int node = destObj.val;

                if (tempK + 1 <= k) {
                    flightStack.push(node);
                    costStack.push(tempCost + destObj.cost);
                    //shouldnt have done --tempK because that would change the behaviour for the current loop
                    kStack.push(tempK + 1);
                }
            }
        }

//        for (Integer cost : costs) {
//            minResult = Math.min(cost, minResult);
//        }
    }

    //forgot static
    static class DestObj {
        int val;
        int cost;

        DestObj(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {

        /*
        5
{{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}}
0
4
1
         */
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        cheapestFlightsWithinKStops.findCheapestPrice(5,
                new int[][]{
                        {0,2,500},
                        {0,1,100},
                        {1,2,100}
                },0,2, 1);
    }
}
