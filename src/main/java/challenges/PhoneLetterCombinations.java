package challenges;
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

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


    //second time
    List<String>result;

    public List<String> letterCombinations2(String digits) {
        result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }

        for(int i = 0; i < digits.length(); i++) {
            letterComboCreator(digits, i, "");
        }

        return result;
    }

    private void letterComboCreator(String digits, int i, String combo) {
        if(combo.length() == digits.length()) {
            result.add(combo);
            return;
        }
        if(i >= digits.length()) {
            return;
        }

        char digitAtIndex = digits.charAt(i);
        String combinationForDigit = phone.get("" + digitAtIndex);

        for(int idx = 0; idx < combinationForDigit.length(); idx++) {
            letterComboCreator(digits, i + 1, combo + combinationForDigit.charAt(idx));
        }
    }
}
