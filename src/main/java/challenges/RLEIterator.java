package challenges;

import java.util.LinkedList;
import java.util.Queue;

public class RLEIterator
{
    Queue<Integer> q;

    public RLEIterator(int[] A) {
        int len = (A.length % 2 == 0) ? A.length : A.length - 1;
        q = new LinkedList<>();

        for (int i = 0; i < len; i = i + 2) {
            int ct = A[i];
            int val = A[i + 1];
            for (int j = 0; j < ct; j++) {
                q.offer(val);
            }
        }
    }

    public int next(int n) {
        int val = -1;
        for(int i = 0; i < n; i++) {
            if(q.isEmpty()) {
                return -1;
            }
            val = q.poll();
        }
        return val;
    }

    public static void main(String[] args) {
        RLEIterator rleIterator = new RLEIterator(new int[]{3,8,0,9,2});
    }
}
