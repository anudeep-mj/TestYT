package challenges;

public class Boggle {

    private char[][] board;
    private String word;
    private int rowsLen;
    private int colsLen;

    public Boggle(final char[][] board, final String word) {
        this.rowsLen = board.length;
        this.colsLen = board[0].length;
        this.word = word;
        this.board = board;
    }

    public boolean check() {
        for (int row = 0; row < rowsLen; row++) {
            for (int col = 0; col < colsLen; col++) {
                if (recursiveSearch(row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recursiveSearch(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        if (row >= rowsLen || col >= colsLen || row < 0 || col < 0) {
            return false;
        }

        if (board[row][col] == word.charAt(index)) {
            board[row][col] = '0';
            index++;

            boolean check = recursiveSearch(row - 1, col, word, index) ||
                    recursiveSearch(row, col - 1, word, index) ||
                    recursiveSearch(row + 1, col, word, index) ||
                    recursiveSearch(row, col + 1, word, index) ||
                    recursiveSearch(row + 1, col + 1, word, index) ||
                    recursiveSearch(row + 1, col - 1, word, index) ||
                    recursiveSearch(row - 1, col + 1, word, index) ||
                    recursiveSearch(row - 1, col - 1, word, index);

            --index;
            board[row][col] = word.charAt(index);

            return check;
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        new Boggle(board, "BIN").check();
//    }
}
