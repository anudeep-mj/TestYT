package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
    static List<String> result;

    public static List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        wbRecursive(s, wordDict, new StringBuilder());
        return result;
    }

    private static void wbRecursive(String s, List<String> dict, StringBuilder current) {
        if(s.length() == 0) {
            result.add(current.toString().trim());
            return;
        }

        for(int i = 0; i <= s.length(); i++) {
            String subs = s.substring(0, i);
            if(dict.contains(subs)) {
                wbRecursive(s.substring(i), dict, new StringBuilder(current.append(subs + " ")));
            }
        }
    }

    public static void main(String[] args) {
        wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
    }
}
