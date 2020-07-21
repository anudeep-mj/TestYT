package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        Integer[] resultArray = new Integer[rowIndex + 1];

        result.add(1);
        for(int i = 1; i < rowIndex + 1; i++) {
            resultArray[0] = 1;

            for(int j = i; j >= 1; j--) {
                resultArray[j] = resultArray[j-1] + resultArray[j];
            }
        }

        return Arrays.asList(resultArray);
    }

    public static void main(String[] args) {
        getRow(2);
    }
}
