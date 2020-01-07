package challenges;

public class GCD {
    public static int compute(int x, int y) {
        int smaller = 0;
        if (x < y) {
            smaller = x;
        } else {
            smaller = y;
        }

        for (int i = smaller; i > 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        compute(30,12);
    }
}
