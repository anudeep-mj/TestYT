package challenges;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {
    public static double[] tribonacci(double[] s, int n) {
        if (n <= 0) {
            return new double[0];
        }

        double[] cache = new double[n];
        if (n > 3) {
            getTriboCache(cache, n, s);
        } else {
            for (int i = 0; i < n; i++) {
                cache[i] = s[i];
            }
        }

        return cache;
    }

    private static void getTriboCache(double[] cache, int n, double[] s) {
        cache[0] = s[0];
        cache[1] = s[1];
        cache[2] = s[2];
        for (int i = 3; i < n; i++) {
            cache[i] = cache[i-1] + cache[i-2] + cache[i-3];
        }
    }

//    public static int tribonacci(int n, int[] s) {
//        if (n <= 2) {
//            return s[n];
//        }
//        return memoizeTribo(n, s);
//    }
//
//    private static int memoizeTribo(int n, int[] s) {
//        int[] cache = new int[n];
//        cache[0] = s[0];
//        cache[1] = s[0];
//        cache[2] = s[1];
//        for (int i = 0; i <= n; i++) {
//            cache[i] = cache[i-1] + cache[i-2] + cache[i-3];
//        }
//        return cache[n];
//    }
//
//    public static int fibonacci(int n) {
//        return fibo(n);
//    }
//
//    private static int fibo(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        return memoizeFibo(n);
//    }
//
//    private static int memoizeFibo(int n) {
//        int[] cache = new int[n+1];
//        cache[0] = 0;
//        cache[1] = 1;
//        for (int i = 0; i <= n; i++) {
//            cache[i] = cache[i-1] + cache[i-2];
//        }
//        return cache[n];
//    }

    public static void main(String[] args) {
        tribonacci(new double []{0,0,1},10);
    }
}
