package challenges;

/**
 * you have an one-dimension array, how to count number of all 1 submetrics (size is 1 * X)
 */

public class CountSubmatricesWithAllOnesIn1DArray
{
    public static void main(String[] args) {
        numSubmat(new int[]{0,1,1,1,0,0});
    }
    public static int numSubmat(int[] mat) {
        int count = 0;

        int tempCt = 0;
        for (int value : mat) {
            if (value == 0) {
                tempCt = 0;
            }
            else {
                tempCt++;
            }
            count = count + tempCt;
        }


        return count;
    }
}
