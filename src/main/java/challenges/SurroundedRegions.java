package challenges;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * <p>
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {

    static int rowLen;
    static int colLen;
    static int[][] directions = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public static void solve(char[][] board) {
        rowLen = board.length;
        colLen = board[0].length;

        for (int i = 0; i < colLen; i++) {
            if (board[0][i] == 'O') {
                fillWithI(board, 0, i);
            }
        }

        for (int i = 0; i < colLen; i++) {
            if (board[rowLen - 1][i] == 'O') {
                fillWithI(board, rowLen - 1, i);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            if (board[i][0] == 'O') {
                fillWithI(board, i, 0);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            if (board[i][colLen - 1] == 'O') {
                fillWithI(board, i, colLen - 1);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'I') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    private static void fillWithI(char[][] board, int row, int col) {
        if (col > colLen - 1 || col < 0 || row > rowLen - 1 || row < 0 || board[row][col] == 'X' || board[row][col] == 'I') {
            return;
        }

        board[row][col] = 'I';

        for (int[] dir : directions) {
            fillWithI(board, row + dir[0], col + dir[1]);
        }
    }


    public static void main(String[] args) {
        solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }
}