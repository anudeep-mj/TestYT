package challenges;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and
 * must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2 (K) 	-3 	3
 * -5 	-10 	1
 * 10 	30 	-5 (P)
 * <p>
 * Note:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame {
    int rows;
    int cols;

    public int calculateMinimumHP(int[][] dungeon) {
        rows = dungeon.length;
        if (rows == 0) {
            return 1;
        }
        cols = dungeon[0].length;

        dungeonHelper(dungeon);

        return dungeon[0][0];
    }

    private void dungeonHelper(int[][] dungeon) {
        //solve for goal
        if (dungeon[rows - 1][cols - 1] < 0) {
            dungeon[rows - 1][cols - 1] = 1 - (dungeon[rows - 1][cols - 1]);
        } else {
            dungeon[rows - 1][cols - 1] = 1;
        }

        //System.out.println(dungeon[rows-1][cols-1]);


        //solve for last col
        for (int row = rows - 2; row >= 0; row--) {
            dungeon[row][cols - 1] = dungeon[row + 1][cols - 1] - dungeon[row][cols - 1];
            if (dungeon[row][cols - 1] <= 0) {
                dungeon[row][cols - 1] = 1;
            }
            //System.out.println(dungeon[row][cols-1]);
        }

        //solve for last row
        for (int col = cols - 2; col >= 0; col--) {
            dungeon[rows - 1][col] = dungeon[rows - 1][col + 1] - dungeon[rows - 1][col];
            if (dungeon[rows - 1][col] <= 0) {
                dungeon[rows - 1][col] = 1;
            }
            //System.out.println(dungeon[rows-1][col]);
        }

        //solve leftover
        for (int row = rows - 2; row >= 0; row--) {
            for (int col = cols - 2; col >= 0; col--) {
                int right = dungeon[row + 1][col] - dungeon[row][col];
                int down = dungeon[row][col + 1] - dungeon[row][col];
                dungeon[row][col] = Math.min(right, down);
                if (dungeon[row][col] < 0) {
                    dungeon[row][col] = 1;
                }
            }
        }
    }
}
