package challenges;

public class DFSGridBaseline {
    public static int solveGrid(int[][] grid) {
        for (int row = 0; row<grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                evaluateGrid(grid, row, col);
            }
        }
        return -1;
    }

    private static void evaluateGrid(int[][] grid, int row, int col) {
        //check conditions

        //process cell

        //call dfs recursively by going left, right, bottom, top.
    }
}
