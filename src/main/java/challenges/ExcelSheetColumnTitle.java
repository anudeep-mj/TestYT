package challenges;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1:
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle
{
    public static String convertToTitle (int n)
    {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            //this is because, you can associate a number to character based on mod 26.
            n = n - 1;
            int modn = n % 26;
            sb.append((char) ('A' + modn));
            n = n / 26;

        }

        sb.reverse();
        return sb.toString();
    }

    public static void main (String[] args)
    {
        convertToTitle(1000);
    }
}
