package challenges;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] tree) {
        int length = tree.length;
        if(length == 1) {
            return 1;
        }

        int start = 0;
        int end = 0;
        int result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while(end < tree.length) {
            int fruit = tree[end];
            freqMap.put(fruit, freqMap.getOrDefault(fruit, 0) + 1);
            end++;

            if(freqMap.size() <= 2) {
                int totalFruits = 0;
                for(int value: freqMap.values()) {
                    totalFruits += value;
                }
                result = Math.max(result, totalFruits);
            }

            while(freqMap.size() > 2) {
                int fruitAtStart = tree[start];
                freqMap.put(fruitAtStart, freqMap.get(fruitAtStart) - 1);
                if(freqMap.get(fruitAtStart) == 0) {
                    freqMap.remove(fruitAtStart);
                }
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        totalFruit(new int[]{0,1,0,2,1});
    }



    int result = 0;

    public int totalFruitsBF(int[] tree) {
        if (tree.length == 1) {
            return 1;
        }
        for (int i = 0; i < tree.length - 1; i++) {
            int[] start = new int[2];
            start = getStart(i, start, tree);
            startFrom(i, start, tree);
        }
        return result;
    }

    private int[] getStart(int idx, int[] uniques, int[] tree) {
        uniques[0] = tree[idx];

        for (int i = idx; i < tree.length; i++) {
            if (tree[i] != tree[idx]) {
                uniques[1] = tree[i];
                return uniques;
            }
        }
        return uniques;
    }

    private void startFrom(int idx, int[] fruits, int[] tree) {
        Map<Integer, Integer> fruitMap = new HashMap<>();

        for (int i = idx; i < tree.length; i++) {
            int fruit = tree[i];
            if (fruit == fruits[0] || fruit == fruits[1]) {
                fruitMap.put(fruit, fruitMap.getOrDefault(fruit, 0) + 1);
            } else {
                break;
            }
        }
        int tempFruits = 0;
        for (int value : fruitMap.values()) {
            tempFruits += value;
        }
        result = Math.max(result, tempFruits);
    }

}
