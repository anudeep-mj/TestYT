package challenges;
/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 *     Each word after the identifier will consist only of lowercase letters, or;
 *     Each word after the identifier will consist only of digits.
 *
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles
{
    Comparator<String> logsComparator = new Comparator<String>()
    {
        @Override public int compare (String s1, String s2)
        {
            int s1SpaceIndex = s1.indexOf(' ');
            int s2SpaceIndex = s2.indexOf(' ');
            char s1FirstChar = s1.charAt(s1SpaceIndex + 1);
            char s2FirstChar = s2.charAt(s2SpaceIndex + 1);
            if (s1FirstChar <= '9') {
                if (s2FirstChar <= '9') {
                    return 0;
                }
                else {
                    return 1;
                }
            }

            if (s2FirstChar <= '9') {
                return -1;
            }

            int precompute =
                s1.substring(s1SpaceIndex + 1).compareTo(s2.substring(s2SpaceIndex + 1));
            if (precompute == 0) {
                precompute = s1.substring(0, s1SpaceIndex).compareTo(s2.substring(0, s2SpaceIndex));
            }
            return precompute;
        }
    };

    public String[] reorderLogFiles (String[] logs)
    {
        Arrays.sort(logs, logsComparator);
        return logs;
    }
}
