package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String digitCombination = "";
        String leftoverDigits = digits;
        generateCombinationsRecursiveBackTracking(digitCombination, leftoverDigits, result, phone);
        return result;
    }

    private void generateCombinationsRecursiveBackTracking(String digitCombination, String leftoverDigits, List<String> result, Map<String, String> digitToCharMap) {
        if (leftoverDigits.length() == 0) {
            result.add(digitCombination);
            return;
        } else {
            String str = leftoverDigits.substring(0, 1);
            String charMapForDigitChar = digitToCharMap.get(str);

            for (int i = 0; i < charMapForDigitChar.length(); i++) {
                String nextLeftover = leftoverDigits.substring(1);
                String inProgressDigitCombination = digitCombination + charMapForDigitChar.charAt(i);
                generateCombinationsRecursiveBackTracking(
                        inProgressDigitCombination,
                        nextLeftover,
                        result,
                        digitToCharMap);
            }
        }
    }

    public static void main(String[] args) {
        PhoneLetterCombinations phoneLetterCombinations = new PhoneLetterCombinations();
        phoneLetterCombinations.letterCombinations("23");
    }
}
