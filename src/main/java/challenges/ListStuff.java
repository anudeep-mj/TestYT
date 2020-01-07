package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListStuff {

//    public static int countPairs(List<Integer> arr, long k) {
//        //Clear out the duplicates
//        Set<Integer> set = new HashSet<Integer>(arr);
//        arr.clear();
//        arr.addAll(set);
//
//        //Sort the list
//        Collections.sort(arr);
//    }

    public static int numberOfPairs(Integer[] array, int sum) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(array));

        // this set will keep track of the unique pairs.
        Set<String> uniquePairs = new HashSet<String>();

        for (int i : array) {
            int x = sum - i;
            if (set.contains(x)) {
                int[] y = new int[] { x, i };
                Arrays.sort(y);
                uniquePairs.add(Arrays.toString(y));
            }
        }

        //System.out.println(uniquePairs.size());
        return uniquePairs.size();
    }

    static String findNumber(List<Integer> arr, int k) {
        for(Integer i : arr) {
            if(i == k) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void test() {

    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        test();
        findNumber(integerList, 2);
    }
}
