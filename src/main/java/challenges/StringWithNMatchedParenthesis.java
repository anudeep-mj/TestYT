package challenges;

import java.util.ArrayList;
import java.util.List;

public class StringWithNMatchedParenthesis {
    public static List<String> generateStringWithNMatchedParenthesis(Integer N) {
        List<String> result = new ArrayList<>();
        if (N <= 0) {
            return result;
        }
        int leftOutLEFTParenthesis = N;
        int leftOutRIGHTParenthesis = N;
        String stringInProgress = "";
        generateRecursively(result, leftOutLEFTParenthesis, leftOutRIGHTParenthesis, stringInProgress);
        return result;
    }

    private static void generateRecursively(List<String> result, int leftOutLEFTParenthesis, int leftOutRIGHTParenthesis, String stringInProgress) {
        if (leftOutLEFTParenthesis == 0 && leftOutRIGHTParenthesis == 0) {
            result.add(stringInProgress);
            return;
        }

        if (leftOutLEFTParenthesis > 0) {
            generateRecursively(result, leftOutLEFTParenthesis - 1, leftOutRIGHTParenthesis, stringInProgress + "(");
        }

        if (leftOutLEFTParenthesis < leftOutRIGHTParenthesis) {
            generateRecursively(result, leftOutLEFTParenthesis, leftOutRIGHTParenthesis - 1, stringInProgress + ")");
        }
    }

    public static void main(String[] args) {
        generateStringWithNMatchedParenthesis(3);
    }
}
