package challenges;
/**
 * Given two words source and target, and a list of words words,
 * find the length of the shortest series of edits that transforms source to target.
 *
 * Each edit must change exactly one letter at a time, and each intermediate word (and the final target word) must exist in words.
 *
 * If the task is impossible, return -1.
 *
 * Examples:
 *
 * source = "bit", target = "dog"
 * words = ["but", "put", "big", "pot", "pog", "dog", "lot"]
 *
 * output: 5
 * explanation: bit -> but -> put -> pot -> pog -> dog has 5 transitions
 *
 * Mistakes done: Should have thought of bfs right away. And the part of bfs using a queue.
 * If you have a node class inside, have it static if you want to use it in static methods.
 * Dont get tensed. Visualize the solution before and move smoothly. Have good indentation
 *
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestWordEditPath {
    static int shortestWordEditPath(String source, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(source, 0));
        while (!queue.isEmpty()) {
            Node poppedNode = queue.poll();
            if (poppedNode.val.equals(target)) {
                return poppedNode.level;
            }

            for (String word : words) {
                if (!visited.contains(word)) {
                    if (stringDiffCounter(poppedNode.val, word)) {
                        Node node = new Node(word, poppedNode.level + 1);
                        queue.add(node);
                        visited.add(word);
                    }
                }
            }
        }

        return -1;
    }

    static boolean stringDiffCounter(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }
        int count = 0;

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        int level = shortestWordEditPath("bit", "bit", new String[]{"but", "put", "big", "pot", "pog", "dog", "lot"});
    }

    static class Node {
        String val;
        int level;

        Node(String val, int level) {
            this.val = val;
            this.level = level;
        }
    }
}
