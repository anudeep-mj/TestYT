package challenges;

public class quadruple {

    static int[] findArrayQuadruplet(int[] arr, int s) {
        if(arr.length < 4) {
            return new int[0];
        }
        int[] result = new int[4];

        for (int j = 0; j<arr.length; j++) {
            int index = 0;
            int count = 0;
            int sum = 0;
            result = new int[4];

            for(int i = j; i < arr.length; i++) {
                if(arr[i] + sum <= s) {
                    ++count;
                    sum = sum + arr[i];
                    result[index++] = arr[i];

                    if(count >= 4) {
                        if(sum != s) {
                            break;
                        } else {
                            return result;
                        }
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String line = "2,7,4,0,9,5,1,3";
        String[] parts = line.split(",");
        int[] ints = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            ints[i] = Integer.parseInt(parts[i]);
        }
        int k = 20;
        int[] result = findArrayQuadruplet(ints, k);
        if (result.length == 4) {
            System.out.println("Yay");
        }
    }
}
