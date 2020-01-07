package challenges;

import java.util.HashMap;
import java.util.Map;

public class ScreenLock {

    private static Map<Character, char[]> board = new HashMap<>();
    private static Map<Character, char[]> passOver = new HashMap<>();

    static {
        board.put('A', new char[]{'B', 'D', 'E', 'F', 'H'});
        board.put('C', new char[]{'B', 'F', 'E', 'D', 'H'});
        board.put('I', new char[]{'F', 'H', 'E', 'D', 'B'});
        board.put('G', new char[]{'D', 'H', 'E', 'F', 'B'});
        board.put('B', new char[]{'A', 'C', 'E', 'D', 'F', 'G', 'I'});
        board.put('F', new char[]{'C', 'I', 'E', 'B', 'H', 'G', 'A'});
        board.put('H', new char[]{'G', 'I', 'E', 'D', 'F', 'C', 'A'});
        board.put('D', new char[]{'A', 'G', 'E', 'B', 'H', 'C', 'I'});
        board.put('E', new char[]{'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I'});

        passOver.put('A', new char[]{'C', 'B',  'I', 'E',  'G', 'D'});
        passOver.put('C', new char[]{'A', 'B',  'G', 'E',  'I', 'F'});
        passOver.put('I', new char[]{'C', 'F',  'A', 'E',  'G', 'H'});
        passOver.put('G', new char[]{'A', 'D',  'C', 'E',  'I', 'H'});
        passOver.put('B', new char[]{'H', 'E'});
        passOver.put('H', new char[]{'B', 'E'});
        passOver.put('D', new char[]{'F', 'E'});
        passOver.put('F', new char[]{'D', 'E'});
    }

    public static int calculateCombinations(char startPositionCharacter, int patternLength){
        if (patternLength > 9 || patternLength <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[9];
        int combinations = cal(visited, startPositionCharacter, patternLength);
        return combinations;
    }

    private static int cal(boolean[] visited, char startPositionCharacter, int patternLength) {
        if (patternLength == 1) { return 1;}
        if (patternLength == 0) { return 0;}

        int result = 0;
        visited[toIndex(startPositionCharacter)] = true;

        char[] neighborsOfPosition = board.get(startPositionCharacter);
        for (int i = 0; i < neighborsOfPosition.length; ++i) {
            if (!visited[toIndex(neighborsOfPosition[i])]) {
                result = result + cal(visited, neighborsOfPosition[i], patternLength - 1);
            }
        }

        char[] passOvers = passOver.get(startPositionCharacter);
        if (passOvers != null) {
            for (int i = 0; i<passOvers.length/2; i++) {
                char target = passOvers[i * 2];
                char passOver = passOvers[i * 2 + 1];
                if (!visited[toIndex(target)] && visited[toIndex(passOver)]) {
                    result = result + cal(visited, target, patternLength - 1);
                }
            }
        }

        visited[toIndex(startPositionCharacter)] = false;
        return result;
    }

    private static int toIndex(char c) {
        return c - 'A';
    }


    public static void main(String[] args) {
//        calculateCombinations('A',10); //0
//        calculateCombinations('E',2); //8
        calculateCombinations('C',2); //5
        calculateCombinations('E',4); //256

    }
}
