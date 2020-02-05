package challenges;

import java.util.ArrayList;
import java.util.List;

public class GenerateNMatchedParenStrings {

    public static List<String> generateNMatchedParenStrings(int n){
        List<String> result = new ArrayList<>();
        generateNPairsStrings(result, n, n, "");
        return result;
    }

    static void generateNPairsStrings(List<String> result, int leftOverLeftParen, int leftOverRightParen, String str) {
        if(leftOverLeftParen == 0 && leftOverRightParen == 0) {
            result.add(str);
            return;
        }
        if(leftOverLeftParen > 0) {
            generateNPairsStrings(result, leftOverLeftParen - 1, leftOverRightParen, str + "(");
        }

        if(leftOverLeftParen < leftOverRightParen) {
            generateNPairsStrings(result, leftOverLeftParen, leftOverRightParen - 1, str + ")");

        }
    }


    public static void main(String[] args) {

    }
}
