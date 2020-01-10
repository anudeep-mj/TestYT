package challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringArrayIntersection {
    public String[] getIntersection(String[] input1, String[] input2) {
        int length1 = input1.length;
        int length2 = input2.length;

        if (length1 == 0 || length2 == 0) {
            return new String[0];
        }

        Set<String> set1 = new HashSet<>(Arrays.asList(input1));
        Set<String> set2 = new HashSet<>(Arrays.asList(input2));

        set1.retainAll(set2);

        return (String[]) set1.toArray();
    }
}
