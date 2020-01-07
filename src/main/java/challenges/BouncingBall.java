package challenges;

public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        if ((h <= 0) || (window >= h) || (bounce <= 0) || (bounce >= 1))
            return -1;
        int count = 0;
        if (h < window) {
            return -1;
        } else {
            while (h >= window) {
                h = h * bounce;
                count++;
            }
        }
        return (count-1) * 2 + 1;
    }

    public static void main(String[] args) {
        bouncingBall(2, 0.5, 1.0);
    }
}
