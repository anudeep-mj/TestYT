package challenges;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * Example 1:
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToEnglishWords
{
    private static final String[] belowTen =
        new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] belowTwenty =
        new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] belowHundred =
        new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety" };

    public static String integerToWords (int num)
    {
        if (num == 0) {
            return "zero";
        }
        return intToWordsHelper(num);
    }

    private static String intToWordsHelper (int num)
    {
        String result = "";
        if (num < 10) {
            result = belowTen[num];
        }
        else if (num < 20) {
            result = belowTwenty[num - 10];
        }
        else if (num < 100) {
            result = belowHundred[num / 10] + intToWordsHelper(num % 10);
        }
        else if (num < 1000) {
            result = belowTen[num / 100] + " Hundred " + intToWordsHelper(num % 100);
        }
        else if (num < 1000000) {
            result = integerToWords(num / 1000) + " Thousand " + integerToWords(num % 1000);
        }
        else if (num < 1000000000) {
            result = integerToWords(num / 1000000) + " Million " + integerToWords(num % 1000000);
        }
        else {
            result =
                integerToWords(num / 1000000000) + " Billion " + integerToWords(num % 1000000000);
        }

        return result.trim();
    }
}
