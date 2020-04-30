package challenges;

/**
 * given string and deletion of a char in the string at index i is shown in cost[]. Find min cost of deletion from the string so that the string has no adjacent equal chars
 */
public class MinCostGetStringWithout2IdenticalConsecutiveLetters {
    public static int getMinCost(String chars, int[] cost) {
        int i = 0;
        int j = 1;
        int minCost = 0;
        while(j < chars.length()) {
            if (chars.charAt(i) == chars.charAt(j)) {
                minCost = minCost + Math.min(cost[i], cost[j]);
            }
            i++;
            j++;
        }
        return minCost;
    }

    public static void main(String[] args){
        getMinCost("abccbd", new int[]{0,1,2,3,4,5});
    }
}
