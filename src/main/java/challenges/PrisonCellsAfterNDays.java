package challenges;

import java.util.Arrays;
import java.util.HashSet;

/**
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 * <p>
 * Example 1:
 * <p>
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 * <p>
 * Example 2:
 * <p>
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 * Note:
 * cells.length == 8
 * cells[i] is in {0, 1}
 * 1 <= N <= 10^9
 */
public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {

        HashSet<String> hs = new HashSet<>();
        int count = 0;
        boolean hasCycle = false;

        for (int j = 0; j < N; j++) {
            int[] temp = cells.clone();

            //take care of mid
            for (int i = 1; i < cells.length - 1; i++) {
                if (cells[i - 1] == cells[i + 1]) {
                    temp[i] = 1;
                } else {
                    temp[i] = 0;
                }
            }
            temp[0] = 0;
            temp[cells.length - 1] = 0;

            String s = Arrays.toString(temp);

            if (!hs.contains(s)) {
                hs.add(s);
                count++;
            } else {
                hasCycle = true;
                break;
            }

            cells = temp;
        }

        if (hasCycle) {
            N = N % count;
            for (int j = 0; j < N; j++) {
                int[] temp = cells.clone();

                for (int i = 1; i < cells.length - 1; i++) {
                    if (cells[i - 1] == cells[i + 1]) {
                        temp[i] = 1;
                    } else {
                        temp[i] = 0;
                    }
                }
                temp[0] = 0;
                temp[cells.length - 1] = 0;

                cells = temp;
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] temp = new int[cells.length];
        temp[0] = 0;
        temp[cells.length - 1] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return temp;
    }

    //brute force
    public int[] prisonAfterNDaysBF(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }

        int[] temp = cells.clone();
        temp[0] = 0;
        temp[cells.length - 1] = 0;

        for (int j = 0; j < N; j++) {
            temp = cells.clone();

            //take care of mid
            for (int i = 1; i < cells.length - 1; i++) {
                if (cells[i - 1] == cells[i + 1]) {
                    temp[i] = 1;
                } else {
                    temp[i] = 0;
                }
            }

            cells = temp;
        }

        return cells;
    }

}
