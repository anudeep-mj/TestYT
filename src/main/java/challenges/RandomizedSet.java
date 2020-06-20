package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer, Integer> valToIdxMap;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToIdxMap = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!valToIdxMap.containsKey(val)) {
            valToIdxMap.put(val, list.size());
            list.add(val);
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valToIdxMap.containsKey(val)) {
            //if the value to be deleted is not at the index of last element in "list"
            if (valToIdxMap.get(val) < list.size() - 1) {
                //get the last element in list and put it at the index of the element to be deleted and update its index value in the valToIdx map.
                list.set(valToIdxMap.get(val), list.get(list.size() - 1));
                valToIdxMap.put(list.get(list.size() - 1), valToIdxMap.get(val));
            }
            //remove the val from map and clear out the last element in the list
            valToIdxMap.remove(val);
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int min = 0;
        int max = list.size();
        int randomInInterval = new Random().nextInt((max - min) + 1) + min;
        return list.get(randomInInterval);

        //since the min is always 0 here, you can just use new Random().nextInt(list.size());
    }
}
