package challenges;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * <p>
 * Example 1:
 * Input: "USA"
 * Output: True
 * <p>
 * Example 2:
 * Input: "FlaG"
 * Output: False
 */
public class DetectCapital {
    //mistake done: didnt understand question properly. Any string with all lowercase is a valid string too.
    // Also didnt realize strings like "ABssss" is not a valid input. Should ask more questions.

    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) {
            return true;
        }

        int leftPtr = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c - 'a' < 0) {
                leftPtr++;
            } else {
                break;
            }
        }

        if (leftPtr > 1) {
            if (leftPtr == word.length()) {
                return true;
            } else {
                return false;
            }
        }

        for (int j = word.length() - 1; j >= leftPtr; j--) {
            if (word.charAt(j) - 'a' < 0) {
                return false;
            }
        }

        return true;
    }
}
