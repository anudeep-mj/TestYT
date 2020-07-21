package challenges;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence
 * from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder
{

    static int result = Integer.MAX_VALUE;

    /**
     * Recursive soln. Takes too much stack size but good way of understanding recursive calls
     */
    public static int ladderLength (String beginWord, String endWord, List<String> wordList)
    {
        recurLadder(beginWord, endWord, wordList, new HashSet<String>(), 0);
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    private static void recurLadder (
        String beginWord,
        String endWord,
        List<String> wordList,
        HashSet<String> seenSet,
        int count)
    {
        if (beginWord.equals(endWord)) { //mistake done here using == to equate string
            result = Math.min(result, count);
        }

        List<String> paths = getPossiblePaths(beginWord, wordList, seenSet);

        /*
        System.out.println("beginWord: " + beginWord);
        System.out.println("PossiblePaths: " + Arrays.toString(paths.toArray()));
         */
        if (paths.isEmpty()) { return;}

        for (String s : paths) {
            HashSet<String> seen = new HashSet<>(seenSet);
            seen.add(s);
            /*
            System.out.println("path taken: " + s);
            System.out.println("seen: " + Arrays.toString(seen.toArray()));
            System.out.println("---");
             */
            recurLadder(s, endWord, wordList, seen, count + 1);
        }
    }

    private static List<String> getPossiblePaths (
        String origin,
        List<String> wordList,
        HashSet<String> seenSet)
    {
        List<String> result = new ArrayList<>();
        for (String s : wordList) {
            if (diffBetweenWords1(s, origin) && !seenSet.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    private static boolean diffBetweenWords1 (String word1, String word2)
    {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    public static void main (String[] args)
    {
        ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        /*
        "qa"
"sq"
["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
         */
    }

    /**
     * BFS solution.
     */
    public int ladderLengthBFS (String beginWord, String endWord, List<String> wordList)
    {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        int len = beginWord.length();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i));
                sb.append("*");
                sb.append(word.substring(i + 1, len));
                String newWord = sb.toString();
                ArrayList<String> transforms = map.getOrDefault(newWord, new ArrayList<String>());
                transforms.add(word);
                map.put(newWord, transforms);
            }
        }

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!q.isEmpty()) {
            //removes first added
            Pair<String, Integer> node = q.remove();
            String key = node.getKey();
            int value = node.getValue();
            for (int i = 0; i < len; i++) {
                String intermediateWordForCurr =
                    key.substring(0, i) + "*" + key.substring(i + 1, len);
                ArrayList<String> list =
                    map.getOrDefault(intermediateWordForCurr, new ArrayList<String>());

                for (String str : list) {
                    if (str.equals(endWord)) {
                        return value + 1;
                    }
                    if (!visited.containsKey(str)) {
                        visited.put(str, true);
                        q.add(new Pair(str, value + 1));
                    }
                }
            }
        }
        return 0;
    }
}
