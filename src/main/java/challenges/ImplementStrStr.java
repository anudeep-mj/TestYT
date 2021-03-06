package challenges;

/**
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Constraints:
 *     haystack and needle consist only of lowercase English characters.
 */
public class ImplementStrStr
{
    //BF
    public static int strStr (String haystack, String needle)
    {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int idx = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(idx++) == needle.charAt(j) && j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main (String[] args)
    {
        strStr("hello", "lo");
    }
}
