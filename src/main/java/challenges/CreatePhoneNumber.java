package challenges;

public class CreatePhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        if (numbers.length == 10) {
            stringBuilder.append('(');
            for (int i = 0; i<3; i++) {
                stringBuilder.append(numbers[i]);
            }
            stringBuilder.append(')');
            stringBuilder.append(" ");
            for (int i = 3; i<6; i++) {
                stringBuilder.append(numbers[i]);
            }
            stringBuilder.append('-');
            for (int i = 6; i<10; i++) {
                stringBuilder.append(numbers[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }

}
