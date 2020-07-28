package challenges;

import java.util.Arrays;

/**
 * Given an input string , reverse the string word by word.
 *
 * Example:
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * Note:
 *     A word is defined as a sequence of non-space characters.
 *     The input string does not contain leading or trailing spaces.
 *     The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInStringII {

    int left;
    int right;

    public void reverseWords(char[] s) {
        left = 0;
        right = 0;

        //first reverse
        reverse(s, 0, s.length - 1);

        while(right < s.length) {
            right = getEndOfWord(s, right);

            reverse(s, left, right);

            //mistake: if i want to change the left and right inside the function use "this." and not all static bs
            moveLR(s, right);
        }
    }

    private void moveLR(char[] s, int right) {
        right++;
        while(right < s.length && s[right] == ' ') {
            right++;
        }
        this.right = right;
        this.left = right;
    }

    private int getEndOfWord(char[] s, int right) {
        //small error: should not check for == ' '
        while(right < s.length && s[right] != ' ') {
            right++;
        }
        //small error. dont return right
        return right - 1;
    }

    private void reverse(char[] s, int left, int right) {
        while(left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInStringII reverseWordsInStringII = new ReverseWordsInStringII();
        reverseWordsInStringII.reverseWords("the sky is blue".toCharArray());
    }


    public static void reverseWordsBF(char[] s) {
        String str = Arrays.toString(s);
        //this func involves first splitting s by space .split("\\s+"), iterating from last element and
        // appending to string builder with trailing space and then returning the trimmed string.
        String result = ReverseWords.reverseStringByWords(str);
        s = result.toCharArray();
    }
}
