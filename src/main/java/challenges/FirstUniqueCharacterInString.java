package challenges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        Queue<qObj> q = new LinkedList<>();

        int idx = 0;
        for(char c : s.toCharArray()) {
            if(!freqMap.containsKey(c)) {
                freqMap.put(c, 1);
                q.offer(new qObj(c, idx));
            } else {
                freqMap.put(c, freqMap.get(c) + 1);
            }
            idx++;
        }

        while(!q.isEmpty()) {
            qObj obj = q.poll();
            if(freqMap.get(obj.val) == 1) {
                return obj.idx;
            }
        }
        return -1;
    }

    class qObj {
        char val;
        int idx;

        public qObj(char c, int idx) {
            this.val = c;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();
        firstUniqueCharacterInString.firstUniqChar("leetcode");
    }
}
