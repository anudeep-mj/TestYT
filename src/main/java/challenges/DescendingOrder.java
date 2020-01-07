package challenges;

import java.util.PriorityQueue;

public class DescendingOrder {

    public static int sortDesc(final int num) {
        //Your code
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int num1 = num;
        while(num1 > 0) {
            pq.add(num1 % 10);
            num1 = num1/10;
        }

        System.out.println("hereee");


        int multiple = 1;
        int finalres = 0;
        while(!pq.isEmpty()) {
            int elem = pq.poll();
            System.out.println(elem);
            int elementtobeadded = multiple * elem;
            finalres = finalres + elementtobeadded;
            multiple = multiple * 10;
        }
        return finalres;
    }

    public static void main(String[] args) {
        sortDesc(987654321);
    }
}
