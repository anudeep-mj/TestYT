package challenges;

/**
 *
 * assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
 *
 * assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
 */
public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        if (arr.length == 0) {
            return sb.toString();
        }
        boolean inRange = false;
        boolean rangeStart = true;
        int count = 1;
        int start = arr[0];
        //sb.append(arr[0]);
        for (int i = 1; i< arr.length; i++) {
            if (arr[i] - arr[i-1] > 1) {
                if (inRange) {
                    sb.append(start);
                    if (count > 2) {
                        sb.append("-");
                    } else {
                        sb.append(",");
                    }
                }
                sb.append(arr[i-1]);
                sb.append(",");

                inRange = false;
                rangeStart = true;
                count = 1;
            } else {
                inRange = true;
                if (rangeStart) {
                    start = arr[i-1];
                    rangeStart = false;
                }
                count++;
            }
        }

        if (inRange) {
            sb.append(start);
            if (count > 2) {
                sb.append("-");
            } else {
                sb.append(",");
            }
            sb.append(arr[arr.length-1]);
        } else {
            sb.append(arr[arr.length-1]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        rangeExtraction(new int[] {-6,-3,-2,-1,2,10,15,16,18,19,20,23});
    }
}
