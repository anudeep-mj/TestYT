package challenges;

import java.util.HashSet;
import java.util.TreeSet;

public class MinNumOfDaysToMakeMBouquets
{
    public static int minDays2(int[] bloomDay, int m, int k) {
        TreeSet<Integer> hashSet = new TreeSet<>();
        int maxBloomDay = 0;
        for(int i : bloomDay) {
            hashSet.add(i);
            maxBloomDay = Math.max(i, maxBloomDay);
            //System.out.println(i + ", " + map.get(i));
        }

        System.out.println("----");


        for(Integer entry : hashSet) {
            int day = entry;
            int max = -1;

            int temp = 0;
            int count = 0;
            for(int i : bloomDay) {
                //System.out.println(i);
                if(i > day) {
                    temp = 0;
                } else {
                    max = Math.max(max, i);
                    temp = temp + 1;
                    if(temp % k == 0) {
                        count++;
                        if(count == m) {
                            return max;
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        minDays2(new int[]{1,10,3,10,2}, 3, 1);
    }
}
