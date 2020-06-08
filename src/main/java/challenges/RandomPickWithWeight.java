package challenges;


import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *     1 <= w.length <= 10000
 *     1 <= w[i] <= 10^5
 *     pickIndex will be called at most 10000 times.
 *
 * Example 1:
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 *
 * Example 2:
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 *
 * Explanation of Input Syntax:
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w.
 * pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 *
 * https://stackoverflow.com/questions/6409652/random-weighted-selection-in-java
 */
public class RandomPickWithWeight {
    NavigableMap<Double, Integer> navigableMap;
    private final Random random;
    double total = 0;

    public RandomPickWithWeight(int[] w) {
        this.random = new Random();
        navigableMap = new TreeMap<>();
        int idx = 0;
        for (int wt : w) {
            add(wt, idx++);
        }
        System.out.println("123");
    }

    private void add(double weight, int idx) {
        total += weight;
        navigableMap.put(total, idx);
    }

    public int pickIndex() {
        double value = random.nextDouble() * total;
        return navigableMap.higherEntry(value).getValue();
    }

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{1,3});
        randomPickWithWeight.pickIndex();
    }
}
