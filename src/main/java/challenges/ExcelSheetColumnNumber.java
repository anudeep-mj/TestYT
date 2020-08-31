package challenges;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber
{
    /*
    For a title "LEET":
    L = 12
    E = (12 x 26) + 5 = 317
    E = (317 x 26) + 5 = 8247
    T = (8247 x 26) + 20 = 214442
    */

    public int titleToNumber (String s)
    {
        int result = 0;
        int idx = 0;
        while (idx < s.length()) {
            result = result * 26;

            char c = s.charAt(idx++);
            int val = (int) c - 'A' + 1;
            result = result + val;
        }

        return result;
    }
}
