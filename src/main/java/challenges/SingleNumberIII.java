package challenges;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII
{
    //InEff
    public int[] singleNumberInEff(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int idx = 0;
        int[] res = new int[2];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
}
