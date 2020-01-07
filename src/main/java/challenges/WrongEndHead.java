package challenges;

public class WrongEndHead {
    public static String[] fixTheMeerkat(String[] arr) {
        String buffer = "";
        int end = arr.length;
        for (int i = 0; i < arr.length/2; i++) {
            buffer = arr[i];
            arr[i] = arr[end];
            arr[end] = buffer;
            end--;
        }
        return arr;
    }
}
