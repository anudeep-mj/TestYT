package challenges;

import java.util.ArrayList;
import java.util.List;

public class WordTyping {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int row = 1;
        int currColIdx = 0;

        while (row <= rows) {
            for(String string : sentence) {
                int newColIdx = currColIdx + string.length();
                if (newColIdx > cols) {
                    row++;
                    if(row > rows) {
                        return count;
                    }
                    currColIdx = 0;
                    currColIdx = currColIdx + string.length() + 1;
                } else {
                    currColIdx = currColIdx + string.length() + 1;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"hello", "leetcode"};
        int rows = 1;
        int cols = 20;
        wordsTyping(strings, rows, cols);
    }
}