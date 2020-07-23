package challenges;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * Constraints:
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //forgot to make this condition which should be basic
                if (board[row][col] == word.charAt(0)) {
                    if (checkBoard(board, word, 0, row, col)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean checkBoard(char[][] board, String word, int idx, int row, int col) {
        //this should be first
        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        char cRC = board[row][col];
        char cIdx = word.charAt(idx);
        if (cIdx != cRC) {
            return false;
        }

        //forgot to make sure the same cell is not called again
        board[row][col] = ' ';

        boolean flag =
                checkBoard(board, word, idx + 1, row + 1, col) ||
                        checkBoard(board, word, idx + 1, row - 1, col) ||
                        checkBoard(board, word, idx + 1, row, col + 1) ||
                        checkBoard(board, word, idx + 1, row, col - 1);

        board[row][col] = cRC;

        return flag;
    }
}
