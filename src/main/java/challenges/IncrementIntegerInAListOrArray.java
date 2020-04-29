package challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * If a number is depicted as an array or a list, increment it by 1
 * From: FB
 */
public class IncrementIntegerInAListOrArray {

    public List<Integer> incrementInteger(ArrayList<Integer> input) {
        if (input == null || input.size() == 0) {
            return new ArrayList<>();
        }

        int numOfZeroes = input.indexOf(0);
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 0) {
                numOfZeroes++;
            } else {
                break;
            }
        }

        ArrayList<Integer> sanitizedList = new ArrayList<>();
        if (numOfZeroes > 0) {
            for (int i = numOfZeroes; i < input.size(); i++) {
                sanitizedList.add(input.get(i));
            }
        } else {
            sanitizedList.addAll(input);
        }

        Collections.reverse(sanitizedList);
        incrementHelper(sanitizedList);
        Collections.reverse(sanitizedList);
        return sanitizedList;
    }

    private void incrementHelper(ArrayList<Integer> input) {
        int carry = 1;
        int index = 0;
        while (index < input.size() && carry > 0) {
            int incrementedNumber = input.get(index) + 1;
            if (incrementedNumber < 10) {
                input.set(index, incrementedNumber);
            } else {
                input.set(index, 0);
            }
            index++;
            carry = (incrementedNumber % 10 == 0) ? 1 : 0;
        }
        if (carry == 1) {
            input.add(1);
        }
    }

    public static void main(String[] args) {
        IncrementIntegerInAListOrArray incrementIntegerInAListOrArray = new IncrementIntegerInAListOrArray();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(5);


        incrementIntegerInAListOrArray.incrementInteger(arrayList);
    }
}
