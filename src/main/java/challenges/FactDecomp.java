package challenges;

import java.util.HashMap;
import java.util.Map;

public class FactDecomp {
    public static String decomp(int n) {
        Map<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
        //get all prime factors for the number

        int number = n;
        for (int i = 2; i < n; i++) {
            while (number % i == 0) {
                number = number / 2;
                primeFactors.put(number, 0);
            }
        }


        for (int i = n; i > 1; i--) {

        }
        return "";
    }

    public static void main(String[] args) {
        decomp(22);
    }
}
