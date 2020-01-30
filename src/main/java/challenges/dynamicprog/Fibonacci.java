package challenges.dynamicprog;
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

public class Fibonacci {
    public static int getFibonacciAtIndex(int N) {
        if(N <= 1) {
            return N;
        }
        return fibo(N);
    }

    static int fibo(int N) {
        int[] cache = new int[N + 1];
        cache[0] = 0;
        cache[1] = 1;
        for(int i = 2; i <= N; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[N];
    }

    public static void main(String[] args) {
        getFibonacciAtIndex(5);
    }

}
