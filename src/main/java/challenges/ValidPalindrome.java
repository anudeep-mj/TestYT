package challenges;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 */
public class ValidPalindrome {
    /**
     * Brute force way would involve sanitization of input removing special chars and space. Then basically have two pointers on each end and walk them both
     * till the middle of the string
     */
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while (start <= end) {
            Character cstart = s.charAt(start);
            Character cend = s.charAt(end);
            if (!Character.isLetterOrDigit(cstart)) {
                start++;
            } else if (!Character.isLetterOrDigit(cend)) {
                end--;
            } else if (cstart.equals(cend)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
