package challenges;

/**
 * There are N bulbs, numbered from 1 to N, arranged in a row. Initially, all the bulbs are turned off.
 * At moment K (for K from 0 to N - 1), we turn on the A[K]-th bulb. A bulb shines if it is on and all the previous bulbs are turned on too.
 * Return the number of moments for which every turned on bulb shines.
 *
 * Example 1:
 * Input: A = [2, 1, 3, 5, 4]
 * Output: 3
 *
 * Example 2:
 * Input: A = [2, 3, 4, 1, 5]
 * Output: 2
 */
public class BulbSwitcherEveryShine {

    public static int numTimesShinesOptimal(int[] light) {
        return -1;
    }



    static int allShiningTill = 0;

    public static int numTimesShinesBF(int[] light) {
        boolean[] lightStatus = new boolean[light.length];
        int count = 0;
        for (int bulbLighted : light) {
            lightStatus[bulbLighted - 1] = true;
            if(checkForShines(bulbLighted, lightStatus)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkForShines(int bulbLighted, boolean[] lightStatus) {
        int idx = bulbLighted - 1;
        for(int i = idx; i >= allShiningTill; i--) {
            if (!lightStatus[i]) {
                return false;
            }
        }
        allShiningTill = idx;
        return true;
    }

    public static void main(String[] args) {
        //numTimesShinesBF(new int[]{2, 1, 3, 5, 4});
    }
}
