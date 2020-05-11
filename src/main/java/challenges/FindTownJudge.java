package challenges;

import java.util.HashMap;
import java.util.HashSet;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 *     The town judge trusts nobody.
 *     Everybody (except for the town judge) trusts the town judge.
 *     There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 * Example 1:
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 */
public class FindTownJudge {

    public int findJudgeEfficient2ms(int N, int[][] trust) {
        if(trust.length == 0) {
            return -1;
        }
        if(trust.length == 1) {
            return trust[0][1];
        }

        int[] outEdges = new int[N+1];
        int[] inEdges = new int[N+1];

        for (int[] relation : trust) {
            inEdges[relation[1]]++;
            outEdges[relation[0]]++;
        }

        for(int i = 1; i <= N; i++) {
            if(inEdges[i] == N-1 && outEdges[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0) {
            return -1;
        }
        if(trust.length == 1) {
            return trust[0][1];
        }
        HashSet<Integer> pool = new HashSet<>();
        HashMap<Integer, HashSet> freqMap = new HashMap<>();

        for(int[] temp : trust) {
//            freqMap.put(temp[0], freqMap.getOrDefault(temp[0], new HashSet<Integer>()).add(temp[1]));
//            pool.add(temp[1]);
             if(!freqMap.containsKey(temp[0])) {
                 HashSet<Integer> set = new HashSet<>();
                 set.add(temp[1]);
                 freqMap.put(temp[0], set);
             } else {
                 HashSet<Integer> set = freqMap.get(temp[0]);
                 set.add(temp[1]);
                 freqMap.put(temp[0], set);
             }
        }

        for(HashSet<Integer> set : freqMap.values()) {
            pool.retainAll(set);
        }

        if(pool.size() > 1 || pool.size() == 0) {
            return -1;
        }

        if(freqMap.containsKey(pool.iterator().next())) {
            return -1;
        }


        return pool.iterator().next();
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(6);

        set1.retainAll(set2);
        System.out.println(set1);
    }
}
