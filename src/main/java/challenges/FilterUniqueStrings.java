package challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FilterUniqueStrings {
    public String[] getUniqueStrings(String[] input) {
        HashSet<String> hashSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i<input.length; i++) {
            if (!hashSet.contains(input[i])) {
                hashSet.add(input[i]);
                list.add(input[i]);
            }
        }
        String[] result = new String[list.size()];

        int idx = 0;
        for (String s : list) {
            result[idx++] = s;
        }
        return result;
    }
}
