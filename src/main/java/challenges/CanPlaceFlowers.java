package challenges;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;

        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }

        return count >= n;
    }

    public static boolean canPlaceFlowerslong(int[] flowerbed, int n) {
        int size = flowerbed.length;
        if (n > size) {
            return false;
        }

        for(int i =0; i<size; ) {

            if (size == 1) {
                if (flowerbed[0] == 0) {
                    flowerbed[0] = 1;
                    n--;
                }
            }

            if(flowerbed[i] == 1) {
                i = i + 2;
                continue;
            }

            if(n == 0) {
                return true;
            }

            if(i == 0 && (i + 1 < size && flowerbed[i + 1] != 1)) {
                flowerbed[i++] = 1;
                n--;
                continue;
            }

            if(i == size - 1 && (i - 1 >= 0 && flowerbed[i - 1] != 1)) {
                flowerbed[i++] = 1;
                n--;
                continue;
            }

            if(flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i++] = 1;
                n--;
                continue;
            }

            i++;
        }

        return n == 0;
    }

    public static void main(String[] args) {
        canPlaceFlowers(new int[]{0,1,0}, 1);
    }
}
