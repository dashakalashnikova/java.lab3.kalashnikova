package lab03;

public class Task2 {

    public static void main(String[] args) {
        printResults(1.0, 1);
        printResults(Math.E, 1);
        printResults(2.0, 2);
        printResults(0.5, 2);
        printResults(Math.PI / 2, 3);
        printResults(0.0, 4);
        printResults(Math.PI / 6, 5);
        printResults(-1.5, 10);
        printResults(1.0, 0);
        printResults(2.0, -3);
        printResults(0.0, 1);
        printResults(-5.0, 1);
        printResults(-2.5, 2);
        printResults(Double.NaN, 3);
        printResults(Double.POSITIVE_INFINITY, 1);
        printResults(Double.NEGATIVE_INFINITY, 4);
    }

 
    public static double x(double t, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("param i = " + i);
        }
        if (Double.isNaN(t) || Double.isInfinite(t)) {
            throw new IllegalArgumentException("param t = " + t);
        }

        if (i == 1 || i == 2) {
            if (t <= 0) {
                throw new IllegalArgumentException("param t = " + t + " for i = " + i);
            }
            return Math.log(t);
        } else {
            double sum = 0.0;
            double sinT = Math.sin(t);
            for (int k = 1; k <= i; k++) {
                sum += sinT / k;
            }
            return sum;
        }
    }

 
    static void printResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(x(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
