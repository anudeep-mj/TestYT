package challenges;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length() < B.length()*2) {
            sb.append(A);
            count++;
            if(sb.indexOf(B) != -1) {
                return count;
            }
        }
        return -1;
    }
}
