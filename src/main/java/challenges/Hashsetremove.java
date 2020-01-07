package challenges;

import java.util.HashSet;
import java.util.Set;

public class Hashsetremove {

    public Boolean getRemoved(HashSet set1, HashSet set2) {
        boolean flag = set1.removeAll(set2);
        return flag;
    }

}
