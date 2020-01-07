package challenges;


import java.util.function.Function;

public class CompleteBinaryTree implements Function<int[], int[]> {

    public int[] apply(int[] ints) {

        return new int[0];
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 2, 6, 7, 5};
        new CompleteBinaryTree().apply(input);
    }
}
