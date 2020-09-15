package challenges;
/**
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
 * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
 * Reconstruction means building a shortest common supersequence of the sequences in seqs
 * (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
 * Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 *
 *
 * Example 1:
 * Input: org = [1,2,3], seqs = [[1,2],[1,3]]
 * Output: false
 * Explanation: [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence
 * that can be reconstructed.
 *
 * Example 2:
 * Input: org = [1,2,3], seqs = [[1,2]]
 * Output: false
 * Explanation: The reconstructed sequence can only be [1,2].
 *
 * Example 3:
 * Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 * Output: true
 * Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 *
 * Example 4:
 * Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * Output: true
 *
 *
 * Constraints:
 *     1 <= n <= 10^4
 *     org is a permutation of {1,2,...,n}.
 *     1 <= segs[i].length <= 10^5
 *     seqs[i][j] fits in a 32-bit signed integer.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction
{
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> seqMap = new HashMap<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        //create indegree map and create seq map which links sequences.
        for (List<Integer> list : seqs) {
            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                seqMap.putIfAbsent(list.get(i), new HashSet<>());
                indegreeMap.putIfAbsent(list.get(i), 0);
                if (i > 0) {
                    if (!seqMap.get(list.get(i - 1)).contains(list.get(i))) {
                        seqMap.get(list.get(i - 1)).add(list.get(i));
                        indegreeMap.put(list.get(i), indegreeMap.get(list.get(i)) + 1);
                    }
                }
            }
        }

        //populate queue with 0 indeg nodes.
        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegreeMap.keySet()) {
            if (indegreeMap.get(key) == 0) {
                queue.offer(key);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int curr = queue.poll();
            if (org[idx++] != curr) {
                return false;
            }

            Set<Integer> mapping = seqMap.get(curr);
            for (int mapp : mapping) {
                indegreeMap.put(mapp, indegreeMap.get(mapp) - 1);
                if (indegreeMap.get(mapp) == 0) {
                    queue.offer(mapp);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(1, 2, 3));
        seqs.add(Arrays.asList(2, 3, 4));
        //seqs.add(Arrays.asList(2, 3));
        sequenceReconstruction(new int[]{1,2,3,4}, seqs);
    }
}
