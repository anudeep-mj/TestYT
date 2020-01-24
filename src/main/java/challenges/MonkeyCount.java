package challenges;

public class MonkeyCount {
    public static int[] monkeyCount(final int n){
        int[] result = new int[n];
        int idx = n - 1;
        for (int i = n; i > 0; i--) {
            result[idx--] = i;
        }
        return result;
    }
}
