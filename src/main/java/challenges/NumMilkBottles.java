package challenges;

public class NumMilkBottles {
    public static int numOfMilkBottles(int n, int d) {
        int result = n;
        int remainder = 0;

        //n is the num of empty bottles
        while (n >= d) {

            //new beers that can be bought from the empty bottles
            int newBeers = n / d;

            //num of empty bottles that cant be sold
            remainder = n % d;

            //new number of empty bottles = bottles from the new beers drank + remainder of the bottles which couldnt be sold
            n = newBeers + remainder;

            //updating beers drank
            result = result + newBeers;
        }

        return result;
    }

    public static void main (String[] args) {
        numOfMilkBottles(7, 3);
    }
}
