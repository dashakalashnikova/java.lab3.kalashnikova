package lab03;


public class Task1 {

    public static void main(String[] args) {
        printResults(0.0, 1);
        printResults(0.0, 10);
        printResults(1.0, 1);
        printResults(1.0, 2);
        printResults(1.0, 5);
        printResults(2.0, 10);
        printResults(0.5, 20);
        printResults(3.0, 30);
        printResults(10.5, 1);
        printResults(1.0, 0);
        printResults(1.0, -5);
        printResults(1.0, 31);
        printResults(2.0, 50);
        printResults(-1.0, 10);
        printResults(-0.001, 5);
        printResults(Double.NaN, 10);
        printResults(Double.POSITIVE_INFINITY, 5);
        printResults(Double.NEGATIVE_INFINITY, 5);
    }

 
    public static double calculateSum(double m, int k) {
        if (k < 1 || k > 30) {
            throw new IllegalArgumentException("param k = " + k);
        }
        if (Double.isNaN(m) || Double.isInfinite(m) || m < 0) {
            throw new IllegalArgumentException("param m = " + m);
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(m / i) * Math.sin(m * i);
        }
        return sum;
    }

 
    static void printResults(double m, int k) {
        System.out.print("m:" + m + " k:" + k + " result:");
        try {
            System.out.println(calculateSum(m, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
