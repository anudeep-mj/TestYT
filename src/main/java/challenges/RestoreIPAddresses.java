package challenges;
/**
 * Given a string s containing only digits. Return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single points and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * Example 3:
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 *
 * Example 4:
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 *
 * Example 5:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * Constraints:
 * 0 <= s.length <= 3000
 * s consists of digits only.
 */

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=KU7Ae2513h0
public class RestoreIPAddresses
{
    public List<String> restoreIpAddresses (String s)
    {
        List<String> result = new ArrayList<>();
        int[] path = new int[4];
        snapShotIPs(s, path, 0, result, 0);
        return result;
    }

    private void snapShotIPs (
        String s,
        int[] path,
        int pathIdx,
        List<String> result,
        int currentIdx)
    {
        if (pathIdx == 4 && currentIdx == s.length()) {
            result.add(getIpFromPath(path));
        }

        if (pathIdx == 4 || currentIdx == s.length()) {
            return;
        }

        //each segment can have max 4 ints.
        for (int i = 0; i < 4; i++) {
            path[i] = Integer.parseInt(s.substring(currentIdx, currentIdx + i));
            //forgot this condition
            if (path[i] < 0 || path[i] > 255) {
                break;
            }
            snapShotIPs(s, path, i, result, i + currentIdx);
            path[i] = -1;
        }
    }

    private String getIpFromPath (int[] path)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int p : path) {
            stringBuilder.append(p);
            stringBuilder.append(".");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
