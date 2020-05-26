package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two large articles, please search and return all the sub-sentences existing in both articles.
 * sub-sentence >= three words.
 *
 * For example:
 * String A = "today is sunny and okay I feel yes so happy"
 * String B = "tomorrow is sunny and that makes today is sunny and okay me feel yes so happy too"
 *
 * Output: {"is sunny and", "feel yes so happy", "today is sunny and okay"}
 */
public class SubSentencesExistingInTwoArticles {

    public static List<String> returnSubSentences(String A, String B) {
        //assign each word to an index
        int idx = 0;
        String tempString = A.trim() + " " + B.trim();
        String[] tempStringArr = tempString.split("\\s+");

        HashMap<String, Integer> wordIndexMap = new HashMap<>();
        HashMap<Integer, String> indexWordMap = new HashMap<>();
        for (String s : tempStringArr) {
            if (!wordIndexMap.containsKey(s)) {
                wordIndexMap.put(s, idx);
                indexWordMap.put(idx, s);
                idx++;
            }
        }

        int[] indexA = new int[A.split("\\s+").length];
        int[] indexB = new int[B.split("\\s+").length];

        //you can make this into a small helper function
        idx = 0;
        for (String s : A.split("\\s+")) {
            indexA[idx++] = wordIndexMap.get(s);
        }
        idx = 0;
        for (String s : B.split("\\s+")) {
            indexB[idx++] = wordIndexMap.get(s);
        }

        List<String> result = new ArrayList<>();

        int[][] dpMatrix = new int[indexA.length + 1][indexB.length + 1];
        for (int i = 1; i <= indexA.length; i++) {
            for (int j = 1; j <= indexB.length; j++) {
                if (indexA[i-1] == indexB[j-1]) {
                    dpMatrix[i][j] = 1 + dpMatrix[i-1][j-1];
                    if (dpMatrix[i][j] >= 3) {
                        StringBuilder stringBuilder = new StringBuilder();
                        int row = i-1;
                        int col = j-1;
                        int count = dpMatrix[i][j];
                        while (count > 0) {
                            int wordIndex = indexB[col];
                            String word = indexWordMap.get(wordIndex);
                            stringBuilder.append(word).append(" ");
                            col--;
                            count--;
                        }
                        result.add(ReverseWords.reverseStringByWords(stringBuilder.toString()));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        returnSubSentences("hello world wow", "i am hello world wow");
    }
}
