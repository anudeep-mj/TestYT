package challenges;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPermutationsOfString {

    List<String> result;

    public List<String> generatePermutations(String s) {
        result = new ArrayList<>();
        permutationsHelper("", s);
        return result;
    }

    private void permutationsHelper(String prefix, String s) {
        int len = s.length();
        if (len == 0) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < len; i++) {
            permutationsHelper(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, len));
        }
    }

    public static void main(String[] args) {
        GenerateAllPermutationsOfString generateAllPermutationsOfString = new GenerateAllPermutationsOfString();
        generateAllPermutationsOfString.generatePermutations("abc");
    }
}
