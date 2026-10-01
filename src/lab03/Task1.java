package lab03;

/**
 * Lab 03, Task 1 (Variant 6)
 * Expression: \sum_{i=1}^{k} \sqrt{m / i} * \sin(m * i), k <= 30
 *
 * @author Kalashnikova
 */
public class Task1 {

    /**
     * Entry point. Tests the method {@code calculateSum(m, k)} by calling the helper
     * method {@code printResults(m, k)} few times with different arguments.
     *
     * @param args command line arguments
     */
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

    /**
     * Calculates the sum of the series: \sum_{i=1}^{k} \sqrt{m / i} * \sin(m * i).
     * Special cases:
     * <ul><li>If parameter k is less than 1 or greater than 30, then
     * exception IllegalArgumentException is thrown.</li>
     * <li>If parameter m is negative or is not a finite number (NaN or Infinity), then
     * exception IllegalArgumentException is thrown.</li></ul>
     *
     * @param m parameter of the series (m >= 0).
     * @param k upper bound of summation (1 <= k <= 30).
     * @return sum of the series.
     * @exception IllegalArgumentException if k < 1, k > 30, m < 0, or m is NaN/Infinite.
     */
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

    /**
     * Helper method for printing result of {@code calculateSum(m, k)}.
     *
     * @param m parameter of the series.
     * @param k upper bound of summation.
     */
    static void printResults(double m, int k) {
        System.out.print("m:" + m + " k:" + k + " result:");
        try {
            System.out.println(calculateSum(m, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
