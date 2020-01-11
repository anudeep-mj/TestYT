package challenges;

public class FairIndex {
    public int getFairIndex(int[] input1, int[] input2) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i<input1.length; i++) {
            sumA = sumA + input1[i];
            sumB = sumB + input2[i];
        }

        int result = 0;
        int tempSumA = 0, tempSumB = 0;
        for (int i = 0; i < input1.length; i++) {
            tempSumA = tempSumA + input1[i];
            tempSumB = tempSumB + input2[i];
            if ((tempSumA * 2 == sumA) && (tempSumB * 2 == sumB) && tempSumA == tempSumB) {
                result++;
            }
        }
        return result;
    }
}
