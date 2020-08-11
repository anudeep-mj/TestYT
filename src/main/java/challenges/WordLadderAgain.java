package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderAgain
{
    static int result = Integer.MAX_VALUE;

    /**
     * BFS Approach
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null) {
            return 0;
        }

        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> seenSet = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                List<String> wordsOneDistanceAway = getWordsOneDistanceAway(s, wordList, seenSet);
                for (String word : wordsOneDistanceAway) {
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    queue.offer(word);
                    seenSet.add(word);
                }
            }
            level++;
        }

        return 0;
    }

    /**
     * DFS Approach
     */
    public static int ladderLengthDFS(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null) {
            return 0;
        }

        buildLadderRecursivelyDFS(beginWord, endWord, 0, wordList, new HashSet<>());
        return result;
    }

    private static void buildLadderRecursivelyDFS(String beginWord, String endWord, int level, List<String> wordList, Set<String> seenSet) {
        if (beginWord.equals(endWord)) {
            result = Math.min(result, level);
            return;
        }

        if(wordList.isEmpty())
            return;

        List<String> wordsOneDistAway = getWordsOneDistanceAway(beginWord, wordList, seenSet);

        for(String s : wordsOneDistAway) {
            HashSet<String> seen = new HashSet<>(seenSet);
            seen.add(s);
            buildLadderRecursivelyDFS(s, endWord, level+1, wordList, seen);
        }
    }


    private static List<String> getWordsOneDistanceAway (String source, List<String> wordsList, Set<String> seenSet)
    {
        List<String> result = new ArrayList<>();

        for (String word : wordsList) {
            if(distanceBetweenWord(source, word) == 1 && !seenSet.contains(word))
                result.add(word);
        }
        return result;
    }

    private static int distanceBetweenWord (String source, String word)
    {
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != word.charAt(i))
                count++;
        }
        return count;
    }

    public static void main (String[] args)
    {
        ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }
}
