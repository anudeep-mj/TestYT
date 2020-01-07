package challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Basically we have a string without spaces. We need to find the maximum number of
 */

public class MaxMatch {
    private static HashSet<String> hashSet = new HashSet<>();

    static {
        hashSet.add("hello");
        hashSet.add("happy");
        hashSet.add("world");
    }


    public static List<String> maxMatch(String sentence){
        List<String> result = new ArrayList<>();
        // Preloaded.VALID_WORDS.contains("happy") == true
        if (sentence.length() == 0) {
            return result;
        }

        findWord(sentence, result);

        return result;
    }

    private static void findWord(String sentence, List<String> result) {
        int i = sentence.length();
        while (i >= 1) {
            String checkedWord = sentence.substring(0, i);
            if (hashSet.contains(checkedWord) || i == 1) {
                result.add(checkedWord);
                findWord(sentence.substring(i), result);
                break;
            }
            i--;
        }
    }

    public static void main(String[] args) {

        maxMatch("asdfhappyq");
    }
}
