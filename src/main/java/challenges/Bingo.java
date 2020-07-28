package challenges;
/**
 * https://stackoverflow.com/questions/18387760/bingo-card-game-in-java
 * <p>
 * https://www.winkbingo.com/blog/how-to-play-75-ball-bingo
 */

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Bingo {

    static class BingoDrawer {

        private Set<Integer> numbers = new HashSet<>();

        //list of numbers drawn
        public Set<Integer> getNumbers() {
            return numbers;
        }

        //tests if this number was drawn
        public boolean hasDrawn(Integer num) {
            return numbers.contains(num);
        }

        //draws new numbers
        public void reset() {
            int low = 1;
            int high = 15;
            for (int i = 0; i < 5; i++) {
                List<Integer> list = new ArrayList<>();
                Set<Integer> generated = new HashSet<>();
                for (int j = 0; j < 5; j++) {
                    int generateNumForRC = getNumberInBetween(low, high, generated);
                    list.add(generateNumForRC);
                    generated.add(generateNumForRC);
                }
                low += 15;
                high += 15;
                numbers.addAll(list);
            }
        }

        @Override
        public String toString() {
            return "numbers: {" + Arrays.toString(numbers.toArray()) + "}";
        }

        public int getNumberInBetween(Integer left, Integer right, Set<Integer> generatedNums) {
            int generatedNum = -1;
            do {
                generatedNum = ThreadLocalRandom.current().nextInt(left, right + 1);
            } while (generatedNums.contains(generatedNum) && generatedNums.size() < (right - left + 1));
            return generatedNum;
        }
    }

    static class BingoCard {

        private List<Integer> numbers = new ArrayList<>();

        //gets new numbers for this card
        public void reset() {
            int low = 1;
            int high = 15;
            for (int i = 0; i < 5; i++) {
                List<Integer> list = new ArrayList<>();
                Set<Integer> generated = new HashSet<>();
                for (int j = 0; j < 5; j++) {
                    int generateNumForRC = getNumberInBetween(low, high, generated);
                    list.add(generateNumForRC);
                    generated.add(generateNumForRC);
                }
                low += 15;
                high += 15;
                numbers.addAll(list);
            }
        }

        //list of numbers on card
        public List<Integer> getNumbers() {
            return numbers;
        }

        // Tests to see if this card won on this drawing
        public boolean testIfWon(BingoDrawer bingoDrawer) {
            return bingoDrawer.getNumbers().containsAll(getNumbers());
        }

        @Override
        public String toString() {
            return null;
        }

        public int getNumberInBetween(Integer left, Integer right, Set<Integer> generatedNums) {
            int generatedNum = -1;
            do {
                generatedNum = ThreadLocalRandom.current().nextInt(left, right + 1);
            } while (generatedNums.contains(generatedNum) && generatedNums.size() < (right - left + 1));
            return generatedNum;
        }
    }

    public static void main(String[] args) {
        Bingo.BingoCard bingoCard = new BingoCard();
        //bingoCard.reset();
        //bingoCard.getNumbers();
    }
}
